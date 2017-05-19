package hu.elte.cinema.factory;


import hu.elte.cinema.dao.interfaces.MovieDao;
import hu.elte.cinema.enums.AgeLimit;
import hu.elte.cinema.model.Movie;

import java.util.Random;
import java.util.UUID;

public class MovieFactory extends AbstractFactory<Movie> {


    public MovieFactory(MovieDao dao) {
        super(dao);
    }

    @Override
    public Movie createOne(Object... arguments) {
        Movie movie = new Movie();
        movie.setDirector(UUID.randomUUID().toString());
        movie.setDubbed(false);
        movie.setLength(new Random().nextInt());
        movie.setTitle(UUID.randomUUID().toString());
        movie.setAgeLimit(AgeLimit.R_RATING);
        movie.setStory(UUID.randomUUID().toString());
        movie.setMaxScreenNumber(new Random().nextInt());
        return movie;
    }
}
