package hu.elte.cinema.configuration;

import hu.elte.cinema.response.CustomResponseFactory;
import hu.elte.cinema.service.interfaces.MovieService;
import hu.elte.cinema.service.interfaces.RoomService;
import hu.elte.cinema.service.interfaces.ScreeningService;
import hu.elte.cinema.service.interfaces.TicketService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;

import static org.mockito.Mockito.mock;

@Configuration
public class MockedServiceContext {
    @Bean
    public MovieService movieService() {
        return mock(MovieService.class);
    }
    @Bean
    public RoomService roomService() {
        return mock(RoomService.class);
    }
    @Bean
    public ScreeningService screeningService() {
        return mock(ScreeningService.class);
    }
    @Bean
    public TicketService ticketService() {
        return mock(TicketService.class);
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
