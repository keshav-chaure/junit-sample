package com.kc.dao;

import com.kc.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeDaoImpl implements EmployeeDao{

    public void insertEmployee(Employee emp) {
        System.out.println("Employee inserted");
    }

    public void insertEmployees(List<Employee> emps) {

    }

    public List<Employee> getAllEmployees() {
        return null;
    }

    public Employee getEmployeeById(String empid) {
        return null;
    }
}
