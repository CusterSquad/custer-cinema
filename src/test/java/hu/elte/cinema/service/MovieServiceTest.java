package hu.elte.cinema.service;


import hu.elte.cinema.dao.interfaces.CrudDao;
import hu.elte.cinema.dao.interfaces.MovieDao;
import hu.elte.cinema.dto.MovieDto;
import hu.elte.cinema.model.Movie;
import hu.elte.cinema.service.configuration.ServiceTestConfig;
import hu.elte.cinema.service.interfaces.CrudService;
import hu.elte.cinema.service.interfaces.MovieService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ServiceTestConfig.class})
@Transactional
@Rollback(false)
public class MovieServiceTest extends AbstractServiceTest<Movie, MovieDto> {

    @Autowired
    private MovieService movieService;
    @Autowired
    private MovieDao movieDao;
    @Autowired
    private ConversionService conversionService;

    @Override
    protected CrudService<Movie, MovieDto, Integer> getService() {
        return movieService;
    }

    @Override
    protected CrudDao<Movie, Integer> getDao() {
        return movieDao;
    }

    @Override
    protected ConversionService getConversionService() {
        return conversionService;
    }

    @Override
    protected Class<Movie> getEntityClass() {
        return Movie.class;
    }

    @Override
    protected Movie createEntity(boolean withId) {
        Movie movie = new Movie();
        if(withId) {
            movie.setId(1);
        }
        return movie;
    }

    @Override
    protected MovieDto createDto() {
        return new MovieDto();
    }
}
