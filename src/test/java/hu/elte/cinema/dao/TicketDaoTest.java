package hu.elte.cinema.dao;

import hu.elte.cinema.dao.configuration.DaoTestConfig;
import hu.elte.cinema.dao.interfaces.TicketDao;
import hu.elte.cinema.factory.TicketFactory;
import hu.elte.cinema.model.Room;
import hu.elte.cinema.model.Ticket;
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
public class TicketDaoTest {

    @Autowired
    private TicketDao ticketDao;
    @Autowired
    private TicketFactory ticketFactory;

    @Before
    public void before() {
        assertNotNull("DAO under test should not be null", ticketDao);
    }

    @Test
    public void testSave() {
        Ticket ticket = ticketFactory.createOne();

        assertNull("Id should be null before save", ticket.getId());
        ticketDao.createEntity(ticket);
        assertNotNull("Id should not be null after save", ticket.getId());
    }
    @Test
    public void testSaveConnections() {
        Ticket ticket = ticketFactory.createOne();
        assertNull("Id should be null before save", ticket.getId());
        ticketDao.createEntity(ticket);
        ticket = ticketDao.findById(ticket.getId());
        assertNotNull("Screening should not be null", ticket.getScreening());
    }

}
