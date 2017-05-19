package hu.elte.cinema.dao;

import hu.elte.cinema.dao.configuration.DaoTestConfig;
import hu.elte.cinema.dao.interfaces.ScreeningDao;
import hu.elte.cinema.factory.ScreeningFactory;
import hu.elte.cinema.model.Screening;
import hu.elte.cinema.model.Ticket;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DaoTestConfig.class })
@Transactional
public class ScreeningDaoTest {

    @Autowired
    private ScreeningDao screeningDao;
    @Autowired
    private ScreeningFactory screeningFactory;

    @Test
    public void testSave() {
        Screening screening = screeningFactory.createOne();

        assertNull("Id should be null before save", screening.getId());
        screeningDao.createEntity(screening);
        assertNotNull("Id should not be null after save", screening.getId());
    }
    @Test
    public void testSaveConnections() {
        Screening screening = screeningFactory.createOne();

        assertNull("Id should be null before save", screening.getId());
        screeningDao.createEntity(screening);
        screening = screeningDao.findById(screening.getId());
        assertNotNull("Movie should not be null", screening.getMovie());
        assertNotNull("Room should not be null", screening.getRoom());
    }
}
