package hu.elte.cinema.dao.impl;


import hu.elte.cinema.dao.interfaces.ScreeningDao;
import hu.elte.cinema.model.Screening;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ScreeningDaoImpl extends CrudDaoImpl<Screening, Integer>
    implements ScreeningDao {

    @Autowired
    public ScreeningDaoImpl(SessionFactory sessionFactory) {
        super(Screening.class, sessionFactory);
    }
}
