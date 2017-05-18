package hu.elte.cinema.converter.dto;

import hu.elte.cinema.dto.MovieDto;
import hu.elte.cinema.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class MovieDtoConverter implements Converter<Movie, MovieDto> {

    @Override
    public MovieDto convert(Movie movie) {
        MovieDto movieDto = new MovieDto();
        movieDto.setId(movie.getId());
        movieDto.setTitle(movie.getTitle());
        movieDto.setAgeLimit(movie.getAgeLimit().toString());
        movieDto.setDirector(movie.getDirector());
        movieDto.setDubbed(movie.getDubbed());
        movieDto.setLength(movie.getLength());
        movieDto.setStory(movie.getStory());
        movieDto.setTicketSold(movie.getTicketSold());
        movieDto.setMaxScreenNumber(movie.getMaxScreenNumber());
        return movieDto;
    }
}
