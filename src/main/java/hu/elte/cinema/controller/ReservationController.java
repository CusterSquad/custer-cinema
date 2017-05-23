package hu.elte.cinema.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import hu.elte.cinema.configuration.properties.SelectorProperties;
import hu.elte.cinema.dto.RoomDto;
import hu.elte.cinema.dto.ScreeningDto;
import hu.elte.cinema.dto.SimpleDto;
import hu.elte.cinema.dto.TicketDto;
import hu.elte.cinema.model.Movie;
import hu.elte.cinema.model.Room;
import hu.elte.cinema.model.Screening;
import hu.elte.cinema.model.Ticket;
import hu.elte.cinema.response.CustomResponse;
import hu.elte.cinema.response.ResponseEnum;
import hu.elte.cinema.util.ModelAndViewUtil;
import hu.elte.cinema.util.ServiceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReservationController {

    @Autowired
    private SelectorProperties selectorProperties;
    @Autowired
    private ServiceProvider serviceProvider;

    @RequestMapping(value = "/saveReservation", method = RequestMethod.POST)
    public ModelAndView saveReservation(@ModelAttribute("ticketDto") TicketDto ticketDto, @ModelAttribute("roomDto")RoomDto roomDto, BindingResult errors, Model model) {
        CustomResponse response = serviceProvider.getService(Ticket.class).addNewReservation(ticketDto);
        if(response.getResponseEnum() == ResponseEnum.SUCCESS) {
            return ModelAndViewUtil.getView("success");
        } else {
            return ModelAndViewUtil.getView("error", response.getMessage());
        }
    }
    @RequestMapping(value = "/getTicketById", method = RequestMethod.POST)
    public ModelAndView getTicketById(@ModelAttribute("simpleDto") SimpleDto simpleDto, BindingResult errors, Model model) {
        CustomResponse response = serviceProvider.getService(Ticket.class).findById(simpleDto.getId());
        if(response.getResponseEnum() == ResponseEnum.SUCCESS) {
            TicketDto result = (TicketDto) response.getData();
            ModelAndView mav = new ModelAndView("modifyreservation");
            mav.addObject("ticketDto", result);
            mav.addObject("screeningDto", serviceProvider.getService(Screening.class).findById(result.getScreeningId()).getData());
            mav.addObject("movieDto", serviceProvider.getService(Movie.class).findById(result.getMovieId()).getData());
            mav.addObject("screeningList", serviceProvider.getService(Screening.class).list().getData());
            return mav;
        } else {
            return ModelAndViewUtil.getView("error", response.getMessage());
        }

    }
    @RequestMapping(value = "/modifyTicket", method = RequestMethod.POST)
    public ModelAndView modifyTicket(@ModelAttribute("ticketDto") TicketDto ticketDto, BindingResult errors, Model model) {
        CustomResponse response = serviceProvider.getService(Ticket.class).update(ticketDto);
        if(response.getResponseEnum() == ResponseEnum.SUCCESS) {
            return ModelAndViewUtil.getView("success");
        } else {
            return ModelAndViewUtil.getView("error", response.getMessage());
        }
    }

    @RequestMapping(value = "/findScreeningById", method = RequestMethod.GET)
    public ModelAndView getScreeningById(@ModelAttribute("simpleDto") SimpleDto simpleDto,@ModelAttribute("ticketDto")TicketDto ticketDto, BindingResult errors, Model model) {
        CustomResponse response = serviceProvider.getService(Screening.class).findById(simpleDto.getId());
        if(response.getResponseEnum() == ResponseEnum.SUCCESS) {
            ScreeningDto result = (ScreeningDto) response.getData();
            ModelAndView mav = new ModelAndView("newreservation");
            mav.addObject("screeningDto", result);
            mav.addObject("ticketDto", ticketDto);
            mav.addObject("roomDto", serviceProvider.getService(Room.class).findById(result.getRoomId()).getData());
            mav.addObject("movieDto", serviceProvider.getService(Movie.class).findById(result.getMovieId()).getData());
            return mav;
        } else {
            return ModelAndViewUtil.getView("error", response.getMessage());
        }

    }
    @RequestMapping(value = "/deleteReservationById", method = RequestMethod.POST)
    public ModelAndView deleteReservationbyId(@ModelAttribute("simpleDto")SimpleDto simpleDto, BindingResult errors, Model model) {
        CustomResponse response = serviceProvider.getService(Ticket.class).deleteResevation(simpleDto);
        if(response.getResponseEnum() == ResponseEnum.SUCCESS) {
            return ModelAndViewUtil.getView("success");
        } else {
            return ModelAndViewUtil.getView("error", response.getMessage());
        }
    }
}
