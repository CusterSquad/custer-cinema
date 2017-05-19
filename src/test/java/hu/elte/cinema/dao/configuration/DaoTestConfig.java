package hu.elte.cinema.dao.configuration;

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
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;

@Configuration
@Import(ServiceConfig.class)
public class DaoTestConfig {
    @Bean
    ConversionService conversionService() {
        return new DefaultConversionService();
    }
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
