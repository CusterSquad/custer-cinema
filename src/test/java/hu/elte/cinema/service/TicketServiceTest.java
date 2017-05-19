package hu.elte.cinema.service;


import hu.elte.cinema.dao.interfaces.CrudDao;
import hu.elte.cinema.dao.interfaces.TicketDao;
import hu.elte.cinema.dto.TicketDto;
import hu.elte.cinema.model.Ticket;
import hu.elte.cinema.service.configuration.ServiceTestConfig;
import hu.elte.cinema.service.interfaces.CrudService;
import hu.elte.cinema.service.interfaces.TicketService;
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
public class TicketServiceTest extends AbstractServiceTest<Ticket, TicketDto> {

    @Autowired
    private TicketService ticketService;
    @Autowired
    private TicketDao ticketDao;
    @Autowired
    private ConversionService conversionService;

    @Override
    protected CrudService<Ticket, TicketDto, Integer> getService() {
        return ticketService;
    }

    @Override
    protected CrudDao<Ticket, Integer> getDao() {
        return ticketDao;
    }

    @Override
    protected ConversionService getConversionService() {
        return conversionService;
    }

    @Override
    protected Class<Ticket> getEntityClass() {
        return Ticket.class;
    }

    @Override
    protected Ticket createEntity(boolean withId) {
        Ticket ticket = new Ticket();
        if(withId) {
            ticket.setId(1);
        }
        return ticket;
    }

    @Override
    protected TicketDto createDto() {
        return new TicketDto();
    }
}
