package hu.elte.cinema.dao.impl;


import hu.elte.cinema.dao.interfaces.TicketDao;
import hu.elte.cinema.model.Ticket;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class TicketDaoImpl extends CrudDaoImpl<Ticket, Integer>
    implements TicketDao {

    @Autowired
    public TicketDaoImpl(SessionFactory sessionFactory) {
        super(Ticket.class, sessionFactory);
    }
}
