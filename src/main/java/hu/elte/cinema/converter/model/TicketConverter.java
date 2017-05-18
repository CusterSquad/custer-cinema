package hu.elte.cinema.converter.model;

import hu.elte.cinema.dao.interfaces.ScreeningDao;
import hu.elte.cinema.dto.TicketDto;
import hu.elte.cinema.model.Screening;
import hu.elte.cinema.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TicketConverter implements Converter<TicketDto, Ticket> {

    @Autowired
    private ScreeningDao screeningDao;

    @Override
    public Ticket convert(TicketDto ticketDto) {
        Ticket ticket = new Ticket();
        ticket.setId(ticketDto.getId());
        ticket.setScreening(screeningDao.findById(ticketDto.getScreeningId()));
        ticket.setName(ticketDto.getName());
        ticket.setAge(ticketDto.getAge());
        ticket.setSeatX(ticketDto.getSeatX());
        ticket.setSeatY(ticketDto.getSeatY());
        return ticket;
    }
}
