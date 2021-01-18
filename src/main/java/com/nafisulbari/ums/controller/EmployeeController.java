package com.nafisulbari.ums.controller;

import com.nafisulbari.ums.entity.Employee;
import com.nafisulbari.ums.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;


@Controller
public class EmployeeController {


    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/")
    public String getHomePage(Model model) {

        Employee employee = new Employee();

        employee.setEmployeeId(1010);
        employee.setFirstName("bari");
        employee.setLastName("BB");
        employee.setCompany("comp");
        employee.setDepartment("l");
        employee.setEmail("n");
        employee.setDesignation("ss");
        employee.setExtension("g");
        employee.setMobile("ss");
        employee.setRole("s");
        employee.setStatus("s");
        employee.setWorkLocation("ss");


        employeeRepository.save(employee);

        model.addAttribute("employee", employee);
        return "index";
    }


    @RequestMapping(value = "add-employee-form", method = RequestMethod.GET)
    public ModelAndView showForm() {
        return new ModelAndView("add-employee-form", "employee", new Employee());
    }


    @RequestMapping(value = "add-employee-form-action", method = RequestMethod.POST)
    public String submit(@Valid @ModelAttribute("employee") Employee employee,
                         BindingResult result) {

        System.out.println(employee.toString());
        System.out.println(result.hasErrors());


        if (result.hasErrors()) {
            System.out.println("err");
            System.out.println("Error: " + result.toString());
            //todo
            // add a label for error in add-employee-form.jsp
            return "add-employee-form";
        }


        return "employee-view";
    }


}
