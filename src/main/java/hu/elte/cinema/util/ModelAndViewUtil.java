package hu.elte.cinema.util;


import org.springframework.web.servlet.ModelAndView;

public class ModelAndViewUtil {
    public static ModelAndView getView(String viewName) {
        ModelAndView mav = new ModelAndView(viewName);
        return mav;
    }
    public static ModelAndView getView(String viewName, String message) {
        ModelAndView mav = new ModelAndView(viewName);
        mav.addObject("errorMessage", message);
        return mav;
    }
}
