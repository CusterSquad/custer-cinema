package hu.elte.cinema.service.impl;


import hu.elte.cinema.dao.interfaces.RoomDao;
import hu.elte.cinema.dto.RoomDto;
import hu.elte.cinema.model.Room;
import hu.elte.cinema.service.interfaces.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class RoomServiceImpl extends AbstractCrudServiceImpl<Room, RoomDto, Integer>
    implements RoomService{

    @Autowired
    public RoomServiceImpl(RoomDao dao) {
        super(Room.class, RoomDto.class, dao);
    }
}
