package co.newtonschool.contactmanager.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("")
public class HomeController {
    @GetMapping("")
    public ModelAndView viewHome() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("create-person");

        return modelAndView;
    }
}
