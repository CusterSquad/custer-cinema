package hu.elte.cinema.factory;


import hu.elte.cinema.dao.interfaces.TicketDao;
import hu.elte.cinema.model.Screening;
import hu.elte.cinema.model.Ticket;

import java.util.Random;
import java.util.UUID;

public class TicketFactory extends AbstractFactory<Ticket>{

    private final ScreeningFactory screeningFactory;
    private final RoomFactory roomFactory;

    public TicketFactory(TicketDao dao, ScreeningFactory screeningFactory, RoomFactory roomFactory) {
        super(dao);
        this.screeningFactory = screeningFactory;
        this.roomFactory = roomFactory;
    }

    @Override
    public Ticket createOne(Object... arguments) {
        Ticket ticket = new Ticket();
        ticket.setAge(new Random().nextInt());
        ticket.setName(UUID.randomUUID().toString());
        Screening screening = screeningFactory.createOneAndSave();
        int x = Math.abs(new Random().nextInt(screening.getRoom().getMaxRowNumber()));
        int y = Math.abs(new Random().nextInt(screening.getRoom().getMaxColumnNumber()));
        screening.getRoom().getSeat(x,y).setReserved(true);
        roomFactory.updateRoom(screening.getRoom());
        ticket.setSeatX(x);
        ticket.setSeatY(y);
        ticket.setScreening(screening);
        return ticket;
    }
}
