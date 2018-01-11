package com.kc.dao;

import com.kc.dto.Employee;

import java.util.List;

public interface EmployeeDao {
    void insertEmployee(Employee emp);
    void insertEmployees(List<Employee> emps);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(String empid);
    public void addEmployee(Employee e);

}
