package hu.elte.cinema.test.integration.configuration;

import hu.elte.cinema.configuration.ApplicationConfig;
import hu.elte.cinema.factory.MovieDtoFactory;
import hu.elte.cinema.factory.RoomDtoFactory;
import hu.elte.cinema.factory.ScreeningDtoFactory;
import hu.elte.cinema.factory.TicketDtoFactory;
import hu.elte.cinema.service.interfaces.MovieService;
import hu.elte.cinema.service.interfaces.RoomService;
import hu.elte.cinema.service.interfaces.ScreeningService;
import hu.elte.cinema.service.interfaces.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(ApplicationConfig.class)
public class IntegrationTestConfig {

    @Autowired
    private MovieService movieService;
    @Autowired
    private RoomService roomService;
    @Autowired
    private ScreeningService screeningService;
    @Autowired
    private TicketService ticketService;

    @Bean
    MovieDtoFactory movieDtoFactory() {
        return new MovieDtoFactory(movieService);
    }
    @Bean
    RoomDtoFactory roomDtoFactory() {
        return new RoomDtoFactory(roomService);
    }
    @Bean
    ScreeningDtoFactory screeningDtoFactory(MovieDtoFactory movieDtoFactory, RoomDtoFactory roomDtoFactory) {
        return new ScreeningDtoFactory(screeningService, movieDtoFactory, roomDtoFactory);
    }
    @Bean
    TicketDtoFactory ticketDtoFactory(ScreeningDtoFactory screeningDtoFactory) {
        return new TicketDtoFactory(ticketService, screeningDtoFactory);
    }
}
