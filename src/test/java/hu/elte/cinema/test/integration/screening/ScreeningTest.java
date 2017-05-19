package hu.elte.cinema.test.integration.screening;

import hu.elte.cinema.dto.MovieDto;
import hu.elte.cinema.dto.RoomDto;
import hu.elte.cinema.dto.ScreeningDto;
import hu.elte.cinema.factory.MovieDtoFactory;
import hu.elte.cinema.factory.RoomDtoFactory;
import hu.elte.cinema.factory.ScreeningDtoFactory;
import hu.elte.cinema.service.interfaces.ScreeningService;
import hu.elte.cinema.test.integration.configuration.IntegrationTestConfig;
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
public class ScreeningTest {
    private static Logger logger = LoggerFactory.getLogger(ScreeningTest.class);

    @Autowired
    private ScreeningService screeningService;
    @Autowired
    private ScreeningDtoFactory screeningDtoFactory;
    @Autowired
    private RoomDtoFactory roomDtoFactory;
    @Autowired
    private MovieDtoFactory movieDtoFactory;


    private ScreeningDto screeningDto;
    private MovieDto movieDto;
    private RoomDto roomDto;


    @Before
    @Transactional
    public void before() {
        logger.info("Preparing DB for integration testing...");
        screeningDto = screeningDtoFactory.createAndSave();
        movieDto = movieDtoFactory.createAndSave();
        roomDto = roomDtoFactory.createAndSave();
        logger.info("Database prepared!");
    }

    @Test
    public void testScreeningDelete() {
        try {
            screeningService.deleteScreeningById(screeningDto.getId());
            assertFalse("Screening should have been deleted", screeningService.exists(screeningDto.getId()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    @Test
    public void testScreeingModify() {
        screeningDto.setRoomId(roomDto.getId());
        screeningDto.setMovieId(movieDto.getId());
        screeningService.update(screeningDto);
        screeningDto = screeningService.findById(screeningDto.getId());
        assertTrue("Movie should have been changed", screeningDto.getMovieId().equals(movieDto.getId()));
        assertTrue("Room should have been changed", screeningDto.getRoomId().equals(roomDto.getId()));
    }
}
