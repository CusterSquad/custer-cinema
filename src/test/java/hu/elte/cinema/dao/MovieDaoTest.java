package hu.elte.cinema.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;


import hu.elte.cinema.dao.configuration.DaoTestConfig;
import hu.elte.cinema.dao.interfaces.MovieDao;
import hu.elte.cinema.factory.MovieFactory;
import hu.elte.cinema.model.Movie;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DaoTestConfig.class })
@Transactional
public class MovieDaoTest {

    @Autowired
    private MovieDao movieDao;
    @Autowired
    private MovieFactory movieFactory;

    @Before
    public void before() {
        assertNotNull("DAO under test should not be null", movieDao);
    }

    @Test
    public void testSave() {
        Movie movie = movieFactory.createOne();

        assertNull("Id should be null before save", movie.getId());
        movieDao.createEntity(movie);
        assertNotNull("Id should not be null after save", movie.getId());

    }
}
