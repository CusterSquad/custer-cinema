package hu.elte.cinema.factory;


import hu.elte.cinema.dto.MovieDto;
import hu.elte.cinema.service.interfaces.MovieService;

import java.util.Random;
import java.util.UUID;

public class MovieDtoFactory {
    private final MovieService movieService;

    public MovieDtoFactory(MovieService movieService) {
        this.movieService = movieService;
    }

    public MovieDto createAndSave() {
        MovieDto movieDto = createOne();
        movieDto.setId(movieService.create(movieDto));
        return movieDto;
    }

    public MovieDto createOne(Object... arguments) {
        MovieDto movie = new MovieDto();
        movie.setDirector(UUID.randomUUID().toString());
        movie.setDubbed(false);
        movie.setLength(new Random().nextInt());
        movie.setTitle(UUID.randomUUID().toString());
        movie.setAgeLimit("Adult");
        movie.setStory(UUID.randomUUID().toString());
        movie.setMaxScreenNumber(new Random().nextInt());
        return movie;
    }
}
