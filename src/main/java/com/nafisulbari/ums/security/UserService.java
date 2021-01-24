package com.nafisulbari.ums.security;

import com.nafisulbari.ums.entity.Employee;

public interface UserService {

    void save(Employee employee);

    Employee findByEmployeeId(String employeeId);

}
