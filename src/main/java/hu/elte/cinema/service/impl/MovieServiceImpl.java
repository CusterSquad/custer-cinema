package hu.elte.cinema.service.impl;

import hu.elte.cinema.dao.interfaces.MovieDao;
import hu.elte.cinema.dto.MovieDto;
import hu.elte.cinema.model.Movie;

import hu.elte.cinema.service.interfaces.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public class MovieServiceImpl extends AbstractCrudServiceImpl<Movie, MovieDto, Integer>
    implements MovieService{

    @Autowired
    public MovieServiceImpl(MovieDao dao) {
        super(Movie.class, MovieDto.class, dao);
    }
}
