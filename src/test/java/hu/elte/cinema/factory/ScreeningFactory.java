package hu.elte.cinema.factory;


import hu.elte.cinema.dao.interfaces.ScreeningDao;
import hu.elte.cinema.model.Screening;

import java.util.Date;

public class ScreeningFactory extends AbstractFactory<Screening> {

    private final MovieFactory movieFactory;
    private final RoomFactory roomFactory;

    public ScreeningFactory(ScreeningDao dao, MovieFactory movieFactory, RoomFactory roomFactory) {
        super(dao);
        this.movieFactory = movieFactory;
        this.roomFactory = roomFactory;
    }

    @Override
    public Screening createOne(Object... arguments) {
        Screening screening = new Screening();
        screening.setDate(new Date());
        screening.setMovie(movieFactory.createOneAndSave());
        screening.setRoom(roomFactory.createOneAndSave());
        return screening;
    }
}
