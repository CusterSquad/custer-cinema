package hu.elte.cinema.test.integration.movie;


import hu.elte.cinema.dto.MovieDto;
import hu.elte.cinema.factory.MovieDtoFactory;
import hu.elte.cinema.service.interfaces.MovieService;
import hu.elte.cinema.test.integration.configuration.IntegrationTestConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { IntegrationTestConfig.class })
@WebAppConfiguration
public class MovieTest {
    private static Logger logger = LoggerFactory.getLogger(MovieTest.class);

    @Autowired
    private MovieService movieService;
    @Autowired
    private MovieDtoFactory movieDtoFactory;

    private MovieDto movieDto;

    @Before
    @Transactional
    public void before() {
        logger.info("Preparing DB for integration testing...");
        movieDto = movieDtoFactory.createAndSave();
        logger.info("Database prepared!");
    }

    @Test
    public void testMovieDelete() {
        movieService.delete(movieDto);
        assertFalse("Movie should have been deleted", movieService.exists(movieDto.getId()));
    }
    @Test
    public void testMovieModify() {
        movieDto.setDirector("Sanyi");
        movieService.update(movieDto);
        assertTrue("Director name should have been updated", movieService.findById(movieDto.getId()).getDirector().equals("Sanyi"));
    }

}
