package hu.elte.cinema.service;

import hu.elte.cinema.dao.interfaces.CrudDao;
import hu.elte.cinema.dao.interfaces.RoomDao;
import hu.elte.cinema.dto.RoomDto;
import hu.elte.cinema.model.Room;
import hu.elte.cinema.service.configuration.ServiceTestConfig;
import hu.elte.cinema.service.interfaces.CrudService;
import hu.elte.cinema.service.interfaces.RoomService;
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
public class RoomServiceTest extends AbstractServiceTest<Room, RoomDto> {

    @Autowired
    private RoomService roomService;
    @Autowired
    private RoomDao roomDao;
    @Autowired
    private ConversionService conversionService;

    @Override
    protected CrudService<Room, RoomDto, Integer> getService() {
        return roomService;
    }

    @Override
    protected CrudDao<Room, Integer> getDao() {
        return roomDao;
    }

    @Override
    protected ConversionService getConversionService() {
        return conversionService;
    }

    @Override
    protected Class<Room> getEntityClass() {
        return Room.class;
    }

    @Override
    protected Room createEntity(boolean withId) {
        Room room = new Room();
        if(withId) {
            room.setId(1);
        }
        return room;
    }

    @Override
    protected RoomDto createDto() {
        return new RoomDto();
    }
}
