package hu.elte.cinema.converter.model;


import hu.elte.cinema.dto.MovieDto;
import hu.elte.cinema.enums.AgeLimit;
import hu.elte.cinema.model.Movie;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class MovieConverter implements Converter<MovieDto, Movie> {
    @Override
    public Movie convert(MovieDto movieDto) {
        Movie movie = new Movie();
        movie.setId(movieDto.getId());
        movie.setTitle(movieDto.getTitle());
        movie.setAgeLimit(AgeLimit.getLimit(movieDto.getAgeLimit()));
        movie.setDirector(movieDto.getDirector());
        movie.setDubbed(movieDto.getDubbed());
        movie.setLength(movieDto.getLength());
        movie.setStory(movieDto.getStory());
        movie.setTicketSold(movieDto.getTicketSold());
        movie.setMaxScreenNumber(movieDto.getMaxScreenNumber());
        return movie;
    }
}
