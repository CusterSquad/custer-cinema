package hu.elte.cinema.service.configuration;

import hu.elte.cinema.configuration.MockedDaoContext;
import hu.elte.cinema.configuration.ServiceConfig;
import hu.elte.cinema.dao.interfaces.MovieDao;
import hu.elte.cinema.dao.interfaces.RoomDao;
import hu.elte.cinema.dao.interfaces.ScreeningDao;
import hu.elte.cinema.dao.interfaces.TicketDao;
import hu.elte.cinema.factory.MovieFactory;
import hu.elte.cinema.factory.RoomFactory;
import hu.elte.cinema.factory.ScreeningFactory;
import hu.elte.cinema.factory.TicketFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ServiceConfig.class, MockedDaoContext.class})
public class ServiceTestConfig {
    @Bean
    MovieFactory movieFactory(MovieDao movieDao) {
        return new MovieFactory(movieDao);
    }
    @Bean
    RoomFactory roomFactory(RoomDao roomDao) {
        return new RoomFactory(roomDao);
    }
    @Bean
    ScreeningFactory screeningFactory(ScreeningDao screeningDao, MovieFactory movieFactory, RoomFactory roomFactory) {
        return new ScreeningFactory(screeningDao, movieFactory, roomFactory);
    }
    @Bean
    TicketFactory ticketFactory(TicketDao ticketDao, ScreeningFactory screeningFactory, RoomFactory roomFactory) {
        return new TicketFactory(ticketDao, screeningFactory, roomFactory);
    }
}
