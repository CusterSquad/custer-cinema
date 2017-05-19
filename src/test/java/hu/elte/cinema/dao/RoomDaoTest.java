package hu.elte.cinema.dao;

import hu.elte.cinema.dao.configuration.DaoTestConfig;
import hu.elte.cinema.dao.interfaces.RoomDao;
import hu.elte.cinema.factory.RoomFactory;
import hu.elte.cinema.model.Room;
import org.junit.Before;
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
public class RoomDaoTest {

    @Autowired
    private RoomDao roomDao;
    @Autowired
    private RoomFactory roomFactory;

    @Before
    public void before() {
        assertNotNull("DAO under test should not be null", roomDao);
    }

    @Test
    public void testSave() {
        Room room = roomFactory.createOne();

        assertNull("Id should be null before save", room.getId());
        roomDao.createEntity(room);
        assertNotNull("Id should not be null after save", room.getId());
    }

}
