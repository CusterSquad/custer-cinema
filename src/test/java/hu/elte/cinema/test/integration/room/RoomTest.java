package hu.elte.cinema.test.integration.room;

import hu.elte.cinema.dto.RoomDto;
import hu.elte.cinema.factory.RoomDtoFactory;
import hu.elte.cinema.service.interfaces.RoomService;
import hu.elte.cinema.test.integration.configuration.IntegrationTestConfig;
import hu.elte.cinema.test.integration.movie.MovieTest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { IntegrationTestConfig.class })
@WebAppConfiguration
public class RoomTest {
    private static Logger logger = LoggerFactory.getLogger(RoomTest.class);

    @Autowired
    private RoomService roomService;
    @Autowired
    private RoomDtoFactory roomDtoFactory;

    private RoomDto roomDto;

    @Before
    @Transactional
    public void before() {
        logger.info("Preparing DB for integration testing...");
        roomDto = roomDtoFactory.createAndSave();
        logger.info("Database prepared!");
    }

    @Test
    public void testRoomDelete() {
        roomService.delete(roomDto);
        assertFalse("Room should have been deleted", roomService.exists(roomDto.getId()));
    }
    @Test
    public void testRoomModify() {
        roomDto.setRoomName("Sanyi");

        roomService.update(roomDto);
        assertTrue("Room name should have been updated", roomService.findById(roomDto.getId()).getRoomName().equals("Sanyi"));
    }
}
