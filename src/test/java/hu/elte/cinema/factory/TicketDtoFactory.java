package hu.elte.cinema.factory;


import hu.elte.cinema.dto.ScreeningDto;
import hu.elte.cinema.dto.TicketDto;
import hu.elte.cinema.service.interfaces.TicketService;

import java.util.Random;
import java.util.UUID;


public class TicketDtoFactory {
    private final TicketService ticketService;
    private final ScreeningDtoFactory screeningDtoFactory;

    public TicketDtoFactory(TicketService ticketService, ScreeningDtoFactory screeningDtoFactory) {
        this.ticketService = ticketService;
        this.screeningDtoFactory = screeningDtoFactory;
    }
    public TicketDto createAndSave() {
        TicketDto ticketDto = createOne();
        ticketDto.setId(ticketService.create(ticketDto));
        return ticketDto;
    }
    public TicketDto createOne() {
        TicketDto ticketDto = new TicketDto();
        ScreeningDto screeningDto = screeningDtoFactory.createAndSave();
        ticketDto.setMovieTitle(screeningDto.getMovieTitle());
        ticketDto.setMovieId(screeningDto.getMovieId());
        ticketDto.setAge(new Random().nextInt());
        ticketDto.setName(UUID.randomUUID().toString());
        ticketDto.setScreeningId(screeningDto.getId());
        ticketDto.setSeatX(0);
        ticketDto.setSeatY(0);
        return ticketDto;
    }
}
