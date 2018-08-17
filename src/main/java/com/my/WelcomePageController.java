package com.my;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by User on 16.08.2018.
 */
@Controller

public class WelcomePageController {
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ModelAndView showWelcomePage(ModelMap model){
        model.addAttribute("title", "Главная");
        return new ModelAndView("index",model);
    }
}
