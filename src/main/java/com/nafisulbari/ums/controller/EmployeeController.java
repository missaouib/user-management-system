package com.nafisulbari.ums.controller;

import com.nafisulbari.ums.entity.Employee;
import com.nafisulbari.ums.entity.Role;
import com.nafisulbari.ums.repository.EmployeeRepository;
import com.nafisulbari.ums.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.*;


@Controller
public class EmployeeController {


    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    RoleRepository roleRepository;


    @GetMapping("/")
    public String getHomePage(Model model) {

        return "index";
    }


    @RequestMapping(value = "employee-list")
    public String showEmployeeList(Model model) {
        model.addAttribute("listOfEmployees", employeeRepository.findAll());

        return "employee-list";
    }


    @RequestMapping(value = "add-employee-form", method = RequestMethod.GET)
    public String showAddEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("roles", roleRepository.findAll());

        return "add-employee-form";
    }


    @RequestMapping(value = "add-employee", method = RequestMethod.POST)
    public ModelAndView submitAddEmployeeForm(@Valid @ModelAttribute("employee") Employee employee,
                                               @RequestParam(name = "selectedRoles", required = false, defaultValue = "NOROLE") String selectedRoles,
                                              BindingResult result, Model model) {
        if (result.hasErrors()) {
            new ModelAndView("add-employee-form");
        }

        List<Role> listOfAvailableRoles = roleRepository.findAll();
        Set<Role> setOfRolesToAdd= new LinkedHashSet<>();

        for (Role role : listOfAvailableRoles){
            if (selectedRoles.contains(role.getName())){
                setOfRolesToAdd.add(role);
            }
        }

        employee.setRoles(setOfRolesToAdd);
        employeeRepository.save(employee);

        return new ModelAndView("redirect:/employee-list");
    }


    @RequestMapping(value = "edit-employee-form/{id}", method = RequestMethod.GET)
    public ModelAndView showEditEmployeeForm(@PathVariable("id") int id, Model model) {
        Optional<Employee> employee = employeeRepository.findById(id);
        model.addAttribute("employee", employee);

        return new ModelAndView("edit-employee-form");
    }


    @RequestMapping(value = "update-employee/{id}", method = RequestMethod.POST)
    public ModelAndView submitEditEmployeeForm(@Valid @ModelAttribute("employee") Employee employee,
                                               @PathVariable("id") int id,
                                               BindingResult result) {

        // somehow if we are not calling the tempEmployee for nothing, employee is not consisting any id.
        // also it wont work without the @PathVariable for unknown reason.
        Optional<Employee> tempEmployee = employeeRepository.findById(employee.getId());
        if (result.hasErrors() || !tempEmployee.isPresent()) {
            return new ModelAndView("edit-employee-form");
        }
        employeeRepository.saveAndFlush(employee);

        return new ModelAndView("redirect:/employee-list");
    }


    @RequestMapping(value = "delete-employee/{id}", method = RequestMethod.POST)
    public ModelAndView deleteEmployee(@PathVariable("id") int id,
                                       Model model) {

        employeeRepository.deleteById(id);

        return new ModelAndView("redirect:/employee-list");
    }


}
