package hu.elte.cinema.service.impl;


import hu.elte.cinema.dao.interfaces.MovieDao;
import hu.elte.cinema.dao.interfaces.RoomDao;
import hu.elte.cinema.dao.interfaces.ScreeningDao;
import hu.elte.cinema.dao.interfaces.TicketDao;
import hu.elte.cinema.dto.TicketDto;
import hu.elte.cinema.enums.AgeLimit;
import hu.elte.cinema.model.Movie;
import hu.elte.cinema.model.Room;
import hu.elte.cinema.model.Seat;
import hu.elte.cinema.model.Ticket;
import hu.elte.cinema.service.interfaces.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Transactional
public class TicketServiceImpl extends AbstractCrudServiceImpl<Ticket, TicketDto, Integer>
    implements TicketService {

    @Autowired
    private MovieDao movieDao;
    @Autowired
    private ScreeningDao screeningDao;
    @Autowired
    private RoomDao roomDao;
    @Autowired
    private TicketDao ticketDao;

    @Autowired
    public TicketServiceImpl(TicketDao dao) {
        super(Ticket.class, TicketDto.class, dao);
    }

    @Override
    public void createNewReservation(TicketDto ticketDto) throws Exception {
        Movie selectedMovie = movieDao.findById(ticketDto.getMovieId());
        AgeLimit personAgeCategory = AgeLimit.getLimit(ticketDto.getAge());

        if(selectedMovie.getAgeLimit().compareTo(personAgeCategory) <= 0) {
            Room room = screeningDao.findById(ticketDto.getScreeningId()).getRoom();
            Seat selectedSeat = room.getSeat(ticketDto.getSeatX(), ticketDto.getSeatY());
            if(selectedSeat != null) {
                if(!selectedSeat.getReserved()) {
                    selectedSeat.setReserved(true);
                    roomDao.updateEntity(room);

                    create(ticketDto);

                } else {
                    throw new Exception("This seat is already reserved.");
                }
            } else {
                throw new Exception("Invalid seat");
            }

        } else {
            throw new Exception("This person is not allowed to watch this movie.");
        }
    }

    @Override
    public void deleteReservation(Integer id) throws Exception {
        Objects.requireNonNull(id, "The id to be deleted must not be null.");
        Ticket selectedTicket = ticketDao.findById(id);
        Room room = selectedTicket.getScreening().getRoom();
        Seat seat = room.getSeat(selectedTicket.getSeatX(), selectedTicket.getSeatY());
        seat.setReserved(false);
        roomDao.updateEntity(room);
        ticketDao.deleteEntity(selectedTicket);
    }
}
