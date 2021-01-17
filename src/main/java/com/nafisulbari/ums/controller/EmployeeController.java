package com.nafisulbari.ums.controller;

import com.nafisulbari.ums.entity.Employee;
import com.nafisulbari.ums.repository.EmployeeRepository;
import com.nafisulbari.ums.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {


    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/")
    public String getHomePage(){

        Employee employee = new Employee();

        employee.setEmployeeId(1010);
        employee.setFirstName("bari");
        employee.setLastName("BB");
        employee.setCompany("apex");
        employee.setDepartment("l");
        employee.setEmail("n");
        employee.setDesignation("ss");
        employee.setExtension("g");
        employee.setMobile("ss");
        employee.setRole("s");
        employee.setStatus("s");
        employee.setWorkLocation("ss");

        employeeRepository.save(employee);

        return "index";
    }
}
