package hu.elte.cinema.controller;

import hu.elte.cinema.configuration.properties.SelectorProperties;
import hu.elte.cinema.dto.MovieDto;
import hu.elte.cinema.dto.SimpleDto;
import hu.elte.cinema.model.Movie;
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
public class MovieController {
    @Autowired
    private SelectorProperties selectorProperties;
    @Autowired
    private ServiceProvider serviceProvider;

    @RequestMapping(value = "/modifyMovie", method = RequestMethod.POST)
    public ModelAndView modifyMovie(@ModelAttribute("movieDto")MovieDto movieDto, BindingResult errors, Model model) {
        CustomResponse result = serviceProvider.getService(Movie.class).update(movieDto);
        if(result.getResponseEnum() == ResponseEnum.SUCCESS) {
            return new ModelAndView("success");
        } else {
            return new ModelAndView("error");
        }

    }
    @RequestMapping(value = "/getMovieById", method = RequestMethod.POST)
    public ModelAndView getMovieById(@ModelAttribute("simpleDto") SimpleDto simpleDto, BindingResult errors, Model model) {
        MovieDto result = (MovieDto) serviceProvider.getService(Movie.class).findById(simpleDto.getId()).getData();
        ModelAndView mav = new ModelAndView("modifymovie");
        mav.addObject("movieDto", result);
        mav.addObject("dubList", selectorProperties.getDubbedSelectorList());
        mav.addObject("limitList", selectorProperties.getAgeLimitSelectorList());
        return mav;
    }
    @RequestMapping(value = "/saveMovie", method = RequestMethod.POST)
    public ModelAndView saveMovie(@ModelAttribute("movieDto") MovieDto movieDto, BindingResult errors, Model model) {
        CustomResponse response = serviceProvider.getService(Movie.class).create(movieDto);
        if(response.getResponseEnum() == ResponseEnum.SUCCESS) {
            return new ModelAndView("success");
        } else {
            return new ModelAndView("error");
        }
    }
    @RequestMapping(value = "/deleteMovieById", method = RequestMethod.POST)
    public ModelAndView deleteMovieById(@ModelAttribute("simpleDto")SimpleDto simpleDto, BindingResult errors, Model model) {
        CustomResponse response = serviceProvider.getService(Movie.class).delete(simpleDto);
        if(response.getResponseEnum() == ResponseEnum.SUCCESS) {
            return new ModelAndView("success");
        } else {
            return new ModelAndView("error");
        }
    }
}
