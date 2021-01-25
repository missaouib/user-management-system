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
        int errorCode = Integer.parseInt(errorCodeObject.toString());
        String errorMessage = (String) request.getAttribute(RequestDispatcher.ERROR_MESSAGE);

        if (errorMessage.isEmpty()) {
            model.addAttribute("errorMessage", "Something Went Wrong");
        } else {
            model.addAttribute("errorMessage", errorMessage);
        }

        model.addAttribute("errorCode", errorCode);

        return "error";
    }
}
