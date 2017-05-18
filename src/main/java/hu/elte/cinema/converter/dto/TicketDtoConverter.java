package hu.elte.cinema.converter.dto;

import hu.elte.cinema.dao.interfaces.ScreeningDao;
import hu.elte.cinema.dto.ScreeningDto;
import hu.elte.cinema.dto.TicketDto;
import hu.elte.cinema.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TicketDtoConverter implements Converter<Ticket, TicketDto> {

    @Override
    public TicketDto convert(Ticket ticket) {
        TicketDto ticketDto = new TicketDto();
        ticketDto.setId(ticket.getId());
        if(ticket.getScreening() == null) {
            ticketDto.setScreeningId(null);
            ticketDto.setMovieId(null);
            ticketDto.setMovieTitle(null);
        } else {
            ticketDto.setScreeningId(ticket.getScreening().getId());
            ticketDto.setMovieId(ticket.getScreening().getMovie().getId());
            ticketDto.setMovieTitle(ticket.getScreening().getMovie().getTitle());
        }

        ticketDto.setName(ticket.getName());
        ticketDto.setAge(ticket.getAge());
        ticketDto.setSeatX(ticket.getSeatX());
        ticketDto.setSeatY(ticket.getSeatY());

        return ticketDto;
    }
}
