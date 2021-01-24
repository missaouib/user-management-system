package com.nafisulbari.ums.security;

import com.nafisulbari.ums.entity.Employee;
import com.nafisulbari.ums.entity.Role;
import com.nafisulbari.ums.repository.EmployeeRepository;
import com.nafisulbari.ums.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public void save(Employee employee) {
        employee.setPassword(bCryptPasswordEncoder.encode(employee.getPassword()));
        employee.setRoles(new HashSet<>(roleRepository.findAll()));
        employeeRepository.save(employee);

    }

    @Override
    public Employee findByEmployeeId(String employeeId) {
        return employeeRepository.findByEmployeeId(Integer.parseInt(employeeId));
    }
}
