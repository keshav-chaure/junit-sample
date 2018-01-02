package com.kc.service;

import com.kc.dto.Employee;

import java.util.List;

public interface EmployeeService {
    void insertEmployeeUsingEmployeeId(String employeeId);

    void insertEmployee(Employee emp);

    void insertEmployees(List<Employee> employees);

    void getAllEmployees();

    void getEmployeeById(String empid);
}
