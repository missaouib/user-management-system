package com.nafisulbari.ums.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class CustomErrorController implements ErrorController {


    //deprecated method
    @Override
    public String getErrorPath() {

        return null;
    }


    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        Object errorCodeObject = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        Object errorMessage = request.getAttribute(RequestDispatcher.ERROR_MESSAGE);

        if (errorCodeObject == null) {
            model.addAttribute("errorCode", 500);
            model.addAttribute("errorMessage", "Something Went Wrong");
        } else if (errorMessage == null || errorMessage.toString().isEmpty()) {
            model.addAttribute("errorCode", errorCodeObject);
            model.addAttribute("errorMessage", "Something Went Wrong");
        } else {
            model.addAttribute("errorCode", errorCodeObject);
            model.addAttribute("errorMessage", errorMessage);
        }

        return "error";
    }
}
