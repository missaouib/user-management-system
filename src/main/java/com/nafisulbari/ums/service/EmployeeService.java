package com.nafisulbari.ums.service;

import com.nafisulbari.ums.entity.Employee;
import com.nafisulbari.ums.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeService {


    @Autowired
    EmployeeRepository employeeRepository;


    public void saveEmployee(Employee employee) {

        employeeRepository.save(employee);
    }
}
