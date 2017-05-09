package hu.elte.cinema.dao.impl;

import hu.elte.cinema.dao.interfaces.OccupiedDao;
import hu.elte.cinema.model.Occupied;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class OccupiedDaoImpl extends CrudDaoImpl<Occupied, Integer> implements OccupiedDao {

    @Autowired
    public OccupiedDaoImpl(SessionFactory sessionFactory) {
        super(Occupied.class, sessionFactory);
    }
}
