package com.nafisulbari.ums.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SecurityController {


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView loginPage() {

        return new ModelAndView("login");
    }
}
