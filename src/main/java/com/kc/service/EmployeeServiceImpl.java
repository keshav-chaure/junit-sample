package com.kc.service;

import com.kc.dao.EmployeeDao;
import com.kc.dto.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeDao employeeDao;
    private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    public void insertEmployee(Employee employee) {
        //    employeeDao.insertEmployee(employee);
    }


    public void insertEmployeeUsingEmployeeId(int employeeId) {
        Employee emp = new Employee();
        emp.setEmpId(employeeId);
        emp.setEmpName("testEmp");
        System.out.println(emp);
        employeeDao.insertEmployee(emp);
    }


    public void insertEmployees(List<Employee> employees) {

        //employeeDao.insertEmployees(employees);
    }

    public void getAllEmployees() {
        logger.info("in EmployeeServiceImpl > getAllEmployee() ...");
        List<Employee> employees = employeeDao.getAllEmployees();
        for (Employee employee : employees) {
            System.out.println(employee.toString());
            logger.info("fetched Employee {}",employee.getEmpId());
        }
    }


    public void getEmployeeById(String empId) {
        logger.info("in EmployeeServiceImpl ...");
      /*  Employee employee = employeeDao.getEmployeeById(empId);
        System.out.println(employee);*/
    }

}
