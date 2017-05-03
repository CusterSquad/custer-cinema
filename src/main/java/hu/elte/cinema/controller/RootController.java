package hu.elte.cinema.controller;



import hu.elte.cinema.configuration.properties.SelectorProperties;
import hu.elte.cinema.dto.*;
import hu.elte.cinema.model.Movie;
import hu.elte.cinema.model.Room;
import hu.elte.cinema.model.Screening;
import hu.elte.cinema.model.Ticket;
import hu.elte.cinema.util.ServiceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class RootController {

    @Autowired
    private SelectorProperties selectorProperties;
    @Autowired
    private ServiceProvider serviceProvider;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getIndex() {
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/newscreening", method = RequestMethod.GET)
    public ModelAndView getNewScreeing(@ModelAttribute("screeningDto") ScreeningDto screeningDto) {
        ModelAndView mav = new ModelAndView("newscreening");

        if(screeningDto == null) {
            screeningDto = new ScreeningDto();
        }

        mav.addObject("roomList", serviceProvider.getService(Room.class).list().getData());
        mav.addObject("movieList", serviceProvider.getService(Movie.class).list().getData());
        mav.addObject("screeningDto", screeningDto);
        return mav;
    }
    @RequestMapping(value = "/newreservation", method = RequestMethod.GET)
    public ModelAndView getNewReservation(@ModelAttribute("ticketDto")TicketDto ticketDto, @ModelAttribute("simpleDto")SimpleDto simpleDto) {
        ModelAndView mav = new ModelAndView("newreservation");

        if(ticketDto == null) {
            ticketDto = new TicketDto();
        }
        mav.addObject("ticketDto", ticketDto);
        mav.addObject("simpleDto", simpleDto);
        mav.addObject("screeningList", serviceProvider.getService(Screening.class).list().getData());

        return mav;
    }
    @RequestMapping(value = "/modifymovie", method = RequestMethod.GET)
    public ModelAndView getModifyMovie(@ModelAttribute("movieDto") MovieDto movieDto, @ModelAttribute("simpleDto")SimpleDto simpleDto) {
        ModelAndView mav = new ModelAndView("modifymovie");
        mav.addObject("movieList", serviceProvider.getService(Movie.class).list().getData());
        mav.addObject("simpleDto", simpleDto);
        mav.addObject("movieDto", movieDto);
        return mav;
    }
    @RequestMapping(value = "/newmovie", method = RequestMethod.GET)
    public ModelAndView getNewMovie(@ModelAttribute("movieDto") MovieDto movieDto) {
        ModelAndView mav = new ModelAndView("newmovie");

        if(movieDto == null) {
            movieDto = new MovieDto();
        }
        mav.addObject("movieDto", movieDto);
        mav.addObject("dubList", selectorProperties.getDubbedSelectorList());
        mav.addObject("limitList", selectorProperties.getAgeLimitSelectorList());

        return mav;
    }
    @RequestMapping(value = "/modifyscreening", method = RequestMethod.GET)
    public ModelAndView getModifyScreening(@ModelAttribute("screeningDto") ScreeningDto screeningDto, @ModelAttribute("simpleDto") SimpleDto simpleDto) {
        ModelAndView mav = new ModelAndView("modifyscreening");
        mav.addObject("movieList", serviceProvider.getService(Movie.class).list().getData());
        mav.addObject("roomList", serviceProvider.getService(Room.class).list().getData());
        mav.addObject("screeningList", serviceProvider.getService(Screening.class).list().getData());
        mav.addObject("screeningDto", screeningDto);
        mav.addObject("simpleDto", simpleDto);
        return mav;
    }
    @RequestMapping(value = "/modifyreservation", method = RequestMethod.GET)
    public ModelAndView getModifyReservation(@ModelAttribute("ticketDto") TicketDto ticketDto, @ModelAttribute("simpleDto") SimpleDto simpleDto) {
        ModelAndView mav = new ModelAndView("modifyreservation");
        mav.addObject("ticketList", serviceProvider.getService(Ticket.class).list().getData());
        mav.addObject("ticketDto", ticketDto);
        mav.addObject("simpleDto", simpleDto);
        return mav;
    }
    @RequestMapping(value = "/deletemovie", method = RequestMethod.GET)
    public ModelAndView getDeleteMovie(@ModelAttribute("simpleDto")SimpleDto simpleDto) {
        ModelAndView mav = new ModelAndView("deletemovie");
        mav.addObject("movieList", serviceProvider.getService(Movie.class).list().getData());
        mav.addObject("simpleDto", simpleDto);
        return mav;
    }
    @RequestMapping(value = "/deletereservation", method = RequestMethod.GET)
    public ModelAndView getDeleteReservation(@ModelAttribute("simpleDto") SimpleDto simpleDto) {
        ModelAndView mav = new ModelAndView("deletereservation");
        mav.addObject("reservationList", serviceProvider.getService(Ticket.class).list().getData());
        mav.addObject("simpleDto", simpleDto);
        return mav;
    }
    @RequestMapping(value = "/deletescreening", method = RequestMethod.GET)
    public ModelAndView getDeleteScreening(@ModelAttribute("simpleDto")SimpleDto simpleDto) {
        ModelAndView mav = new ModelAndView("deletescreening");
        mav.addObject("screeningList", serviceProvider.getService(Screening.class).list().getData());
        mav.addObject("simpleDto", simpleDto);
        return mav;
    }
}
