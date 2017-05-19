package hu.elte.cinema.configuration;

import hu.elte.cinema.dao.interfaces.*;
import hu.elte.cinema.response.CustomResponseFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;

import static org.mockito.Mockito.mock;

@Configuration
public class MockedDaoContext {
    @Bean
    public MovieDao movieDao() {
        return mock(MovieDao.class);
    }
    @Bean
    public OccupiedDao occupiedDao() {
        return mock(OccupiedDao.class);
    }
    @Bean
    public RoomDao roomDao() {
        return mock(RoomDao.class);
    }
    @Bean
    public ScreeningDao screeningDao() {
        return mock(ScreeningDao.class);
    }
    @Bean
    public TicketDao ticketDao() {
        return mock(TicketDao.class);
    }
    @Bean
    public ConversionService conversionService() {
        return mock(ConversionService.class);
    }
    @Bean
    public CustomResponseFactory customResponseFactory() {
        return mock(CustomResponseFactory.class);
    }
}
