package hu.elte.cinema.configuration;


import hu.elte.cinema.configuration.properties.SelectorProperties;
import hu.elte.cinema.dao.impl.*;
import hu.elte.cinema.dao.interfaces.*;
import hu.elte.cinema.model.*;
import hu.elte.cinema.response.CustomResponseFactory;
import hu.elte.cinema.service.impl.*;
import hu.elte.cinema.service.interfaces.*;
import hu.elte.cinema.util.ServiceProvider;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.convert.ConversionService;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@Import({DatabaseConfig.class})
public class ServiceConfig {

    @Autowired
    private ConversionService conversionService;
    @Autowired
    private SessionFactory sessionFactory;

    @Bean
    MovieDao movieDao() {
        return new MovieDaoImpl(sessionFactory);
    }

    @Bean
    RoomDao roomDao() {
        return new RoomDaoImpl(sessionFactory);
    }
    @Bean
    ScreeningDao screeningDao() {
        return new ScreeningDaoImpl(sessionFactory);
    }
    @Bean
    TicketDao ticketDao() {
        return new TicketDaoImpl(sessionFactory);
    }
    @Bean
    OccupiedDao occupiedDao() {
        return new OccupiedDaoImpl(sessionFactory);
    }

    @Bean
    MovieService movieService() {
        return new MovieServiceImpl(movieDao());
    }

    @Bean
    RoomService roomService() {
        return new RoomServiceImpl(roomDao());
    }
    @Bean
    ScreeningService screeningService() {
        return new ScreeingServiceImpl(screeningDao());
    }
    @Bean
    TicketService ticketService() {
        return new TicketServiceImpl(ticketDao());
    }

    @Bean
    ServiceProvider serviceProvider() {
        ServiceProvider serviceProvider = new ServiceProvider(customResponseFactory());
        serviceProvider.registerService(Movie.class, movieService());
        serviceProvider.registerService(Room.class, roomService());
        serviceProvider.registerService(Ticket.class, ticketService());
        serviceProvider.registerService(Screening.class, screeningService());
        return serviceProvider;
    }


    @Bean
    CustomResponseFactory customResponseFactory() {
        return new CustomResponseFactory();
    }

    @Bean
    SelectorProperties selectorProperties() {
        return new SelectorProperties();
    }


}
