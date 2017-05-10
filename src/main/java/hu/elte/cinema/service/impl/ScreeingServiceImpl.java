package hu.elte.cinema.service.impl;



import hu.elte.cinema.dao.interfaces.*;
import hu.elte.cinema.dto.RoomDto;
import hu.elte.cinema.dto.ScreeningDto;
import hu.elte.cinema.model.*;
import hu.elte.cinema.service.interfaces.ScreeningService;
import hu.elte.cinema.util.DateUtil;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Transactional
public class ScreeingServiceImpl extends AbstractCrudServiceImpl<Screening, ScreeningDto, Integer>
    implements ScreeningService {


    @Autowired
    private RoomDao roomDao;
    @Autowired
    private MovieDao movieDao;
    @Autowired
    private OccupiedDao occupiedDao;
    @Autowired
    private TicketDao ticketDao;
    @Autowired
    private ScreeningDao screeningDao;

    @Autowired
    public ScreeingServiceImpl(ScreeningDao dao) {
        super(Screening.class, ScreeningDto.class, dao);
    }

    public void createNewScreening(ScreeningDto screeningDto) throws Exception {
        Room room = roomDao.findById(screeningDto.getRoomId());
        Movie movie = movieDao.findById(screeningDto.getMovieId());

        screeningDto.setDate(screeningDto.getDate().replace('T', ' '));

        List<Occupied> occupiedList = (List<Occupied>) room.getOccupied();
        for (Occupied item : occupiedList) {
            if(DateUtil.isBetween(DateUtil.getDate(screeningDto.getDate()), item)) {
                throw new Exception("Room is occupied between this date");
            }
        }

        Date movieEnds = DateUtils.addMinutes(DateUtil.getDate(screeningDto.getDate()), movie.getLength());
        Occupied occupied = new Occupied(DateUtil.getDate(screeningDto.getDate()), movieEnds);
        occupiedList.add(occupied);

        occupiedDao.createEntity(occupied);
        roomDao.updateEntity(room);
        create(screeningDto);
    }

    @Override
    public void deleteScreeningById(Integer id) throws Exception {
        Screening selectedScreening = screeningDao.findById(id);
        List<Ticket> ticketList = ticketDao.list();
        for(Ticket ticket : ticketList) {
            if(ticket.getScreening().getId() == selectedScreening.getId()) {
                Seat seat = selectedScreening.getRoom().getSeat(ticket.getSeatX(), ticket.getSeatY());
                seat.setReserved(false);
                roomDao.updateEntity(selectedScreening.getRoom());
                ticketDao.deleteEntity(ticket);
            }
        }

        screeningDao.deleteEntity(selectedScreening);
    }
}
