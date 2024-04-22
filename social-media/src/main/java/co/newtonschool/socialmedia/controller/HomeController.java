package co.newtonschool.socialmedia.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("")
public class HomeController {
    @GetMapping("")
    public ModelAndView getHome() {
        return new ModelAndView("redirect:" + "/posts");
    }
}
