package hu.elte.cinema.dao.impl;


import hu.elte.cinema.dao.interfaces.RoomDao;
import hu.elte.cinema.model.Room;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class RoomDaoImpl extends CrudDaoImpl<Room, Integer>
    implements RoomDao {

    @Autowired
    public RoomDaoImpl(SessionFactory sessionFactory) {
        super(Room.class, sessionFactory);
    }
}
