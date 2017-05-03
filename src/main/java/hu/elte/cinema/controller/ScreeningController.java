package hu.elte.cinema.controller;

import hu.elte.cinema.configuration.properties.SelectorProperties;
import hu.elte.cinema.dto.ScreeningDto;
import hu.elte.cinema.dto.SimpleDto;
import hu.elte.cinema.model.Movie;
import hu.elte.cinema.model.Room;
import hu.elte.cinema.model.Screening;
import hu.elte.cinema.response.CustomResponse;
import hu.elte.cinema.response.ResponseEnum;
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
public class ScreeningController {

    @Autowired
    private SelectorProperties selectorProperties;
    @Autowired
    private ServiceProvider serviceProvider;

    @RequestMapping(value = "/saveScreening", method = RequestMethod.POST)
    public ModelAndView saveScreening(@ModelAttribute("screeningDto")ScreeningDto screeningDto, BindingResult errors, Model model) {
        CustomResponse response = serviceProvider.getService(Screening.class).addNewScreening(screeningDto);
        if(response.getResponseEnum() == ResponseEnum.SUCCESS) {
            return new ModelAndView("success");
        } else {
            return new ModelAndView("error");
        }
    }
    @RequestMapping(value = "/getScreeningById", method = RequestMethod.POST)
    public ModelAndView getScreeningById(@ModelAttribute("simpleDto") SimpleDto simpleDto, BindingResult erros, Model model) {
        ScreeningDto result = (ScreeningDto) serviceProvider.getService(Screening.class).findById(simpleDto.getId()).getData();
        ModelAndView mav = new ModelAndView("modifyscreening");
        mav.addObject("roomList", serviceProvider.getService(Room.class).list().getData());
        mav.addObject("movieList", serviceProvider.getService(Movie.class).list().getData());
        mav.addObject("screeningDto", result);
        return mav;
    }
    @RequestMapping(value = "/modifyScreening", method = RequestMethod.POST)
    public ModelAndView modifyScreening(@ModelAttribute("screeningDto") ScreeningDto screeningDto, BindingResult errors, Model model) {
        CustomResponse result = serviceProvider.getService(Screening.class).update(screeningDto);
        if(result.getResponseEnum() == ResponseEnum.SUCCESS) {
            return new ModelAndView("success");
        } else {
            return new ModelAndView("error");
        }
    }
    @RequestMapping(value = "/deleteScreeningById", method = RequestMethod.POST)
    public ModelAndView deleteScreeningById(@ModelAttribute("simpleDto")SimpleDto simpleDto, BindingResult erros, Model model) {
        CustomResponse response = serviceProvider.getService(Screening.class).deleteScreening(simpleDto);
        if(response.getResponseEnum() == ResponseEnum.SUCCESS) {
            return new ModelAndView("success");
        } else {
            return new ModelAndView("error");
        }
    }
}
