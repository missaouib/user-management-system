package com.nafisulbari.ums.controller;

import com.nafisulbari.ums.entity.Employee;
import com.nafisulbari.ums.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
public class EmployeeController {


    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/")
    public String getHomePage(Model model) {

        return "index";
    }


    @RequestMapping(value = "add-employee-form", method = RequestMethod.GET)
    public String showForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "add-employee-form";
    }


    @RequestMapping(value = "add-employee-form-action", method = RequestMethod.POST)
    public String submit(@Valid @ModelAttribute("employee") Employee employee,
                         BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "add-employee-form";
        }

        model.addAttribute("listOfEmployees", employeeRepository.findAll());
        return "employee-view";
    }


}
