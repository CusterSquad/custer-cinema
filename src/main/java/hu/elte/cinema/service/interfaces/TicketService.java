package hu.elte.cinema.service.interfaces;


import hu.elte.cinema.dto.TicketDto;
import hu.elte.cinema.model.Ticket;

public interface TicketService extends CrudService<Ticket, TicketDto, Integer> {

    void createNewReservation(TicketDto ticketDto) throws Exception;
    void deleteReservation(Integer id) throws Exception;
}
