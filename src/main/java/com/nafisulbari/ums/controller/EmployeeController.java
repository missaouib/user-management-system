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

        return "user-management/employee-list";
    }


    @RequestMapping(value = "add-employee-form", method = RequestMethod.GET)
    public String showAddEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("roles", roleRepository.findAll());

        return "user-management/add-employee-form";
    }


    @RequestMapping(value = "add-employee", method = RequestMethod.POST)
    public ModelAndView submitAddEmployeeForm(@Valid @ModelAttribute("employee") Employee employee,
                                              BindingResult result,
                                              @RequestParam(name = "selectedRoles", required = false, defaultValue = "NOROLE") String selectedRoles,
                                              Model model) {

        if (result.hasErrors()) {
            model.addAttribute("roles", roleRepository.findAll());
            return new ModelAndView("user-management/add-employee-form");
        }

        List<Role> listOfAvailableRoles = roleRepository.findAll();
        Set<Role> setOfRolesToAdd = new LinkedHashSet<>();

        for (Role role : listOfAvailableRoles) {
            if (selectedRoles.contains(role.getName())) {
                setOfRolesToAdd.add(role);
            }
        }

        employee.setRoles(setOfRolesToAdd);
        employeeRepository.save(employee);

        return new ModelAndView("redirect:/employee-list");
    }


    @RequestMapping(value = "edit-employee-form/{id}", method = RequestMethod.GET)
    public ModelAndView showEditEmployeeForm(@PathVariable("id") int id, Model model) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (!optionalEmployee.isPresent()) {
            return new ModelAndView("redirect:/error");
        }
        Employee employee = new Employee(optionalEmployee);
        model.addAttribute("employee", employee);
        model.addAttribute("roles", roleRepository.findAll());

        return new ModelAndView("user-management/edit-employee-form");
    }


    @RequestMapping(value = "update-employee/{id}", method = RequestMethod.POST)
    public ModelAndView submitEditEmployeeForm(@Valid @ModelAttribute("employee") Employee employee,
                                               BindingResult result,
                                               @PathVariable("id") int id,
                                               @RequestParam(name = "selectedRoles", required = false, defaultValue = "NOROLE") String selectedRoles,
                                               Model model) {

        // somehow if we are not calling the tempEmployee for nothing, employee is not consisting any id.
        // also it wont work without the @PathVariable for unknown reason.
        Optional<Employee> tempEmployee = employeeRepository.findById(employee.getId());
        if (result.hasErrors() || !tempEmployee.isPresent()) {
            return new ModelAndView("user-management/edit-employee-form");
        }

        List<Role> listOfAvailableRoles = roleRepository.findAll();
        Set<Role> setOfRolesToAdd = new LinkedHashSet<>();

        for (Role role : listOfAvailableRoles) {
            if (selectedRoles.contains(role.getName())) {
                setOfRolesToAdd.add(role);
            }
        }

        employee.setRoles(setOfRolesToAdd);
        employeeRepository.saveAndFlush(employee);

        return new ModelAndView("redirect:/employee-list");
    }


    @RequestMapping(value = "delete-employee/{id}", method = RequestMethod.POST)
    public ModelAndView deleteEmployee(@PathVariable("id") int id) {

        System.err.println(id);
        employeeRepository.deleteById(id);

        return new ModelAndView("redirect:/employee-list");
    }


    //-------------------------------------------------------------------------

    @RequestMapping(value = "role-list")
    public String showRoleList(Model model) {
        model.addAttribute("listOfRoles", roleRepository.findAll());

        return "user-management/role-list";
    }


    @RequestMapping(value = "add-role-form", method = RequestMethod.GET)
    public String showAddRoleForm(Model model) {
        model.addAttribute("role", new Role());

        return "user-management/add-role-form";
    }


    @RequestMapping(value = "add-role", method = RequestMethod.POST)
    public ModelAndView submitAddRoleForm(@Valid @ModelAttribute("role") Role role,
                                          BindingResult result,
                                          Model model) {
        if (result.hasErrors()) {
            return new ModelAndView("user-management/add-role-form");
        }

        roleRepository.save(role);

        return new ModelAndView("redirect:/role-list");
    }


    @RequestMapping(value = "edit-role-form/{id}", method = RequestMethod.GET)
    public ModelAndView showEditRoleForm(@PathVariable("id") int id, Model model) {
        Optional<Role> optionalRole = roleRepository.findById(id);

        if (!optionalRole.isPresent()) {
            return new ModelAndView("redirect:/error");
        }
        Role role = new Role(optionalRole);
        model.addAttribute("role", role);

        return new ModelAndView("user-management/edit-role-form");
    }


    @RequestMapping(value = "update-role/{id}", method = RequestMethod.POST)
    public ModelAndView submitEditRoleForm(@Valid @ModelAttribute("role") Role role,
                                           BindingResult result,
                                           @PathVariable("id") int id,
                                           Model model) {

        // somehow if we are not calling the tempEmployee for nothing, employee is not consisting any id.
        // also it wont work without the @PathVariable for unknown reason.
        Optional<Role> tempRole = roleRepository.findById(id);
        if (result.hasErrors() || !tempRole.isPresent()) {
            return new ModelAndView("user-management/edit-role-form");
        }

        role.setId(tempRole.get().getId());
        roleRepository.saveAndFlush(role);

        return new ModelAndView("redirect:/role-list");
    }


    @RequestMapping(value = "delete-role/{id}", method = RequestMethod.POST)
    public ModelAndView deleteRole(@PathVariable("id") int id) {


        //todo if exception found(roles been assigned) therefore don't allow delete
        roleRepository.deleteById(id);

        return new ModelAndView("redirect:/role-list");
    }


}
