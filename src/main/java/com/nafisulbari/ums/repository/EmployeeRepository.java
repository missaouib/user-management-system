package com.nafisulbari.ums.repository;

import com.nafisulbari.ums.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {


}
