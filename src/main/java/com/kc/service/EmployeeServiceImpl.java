package com.kc.service;

import com.kc.dto.Employee;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeServiceImpl implements EmployeeService {

//    @Autowired
//    EmployeeDao employeeDao;

    public void insertEmployee(Employee employee)
    {
    //    employeeDao.insertEmployee(employee);
    }


    public void insertEmployeeUsingEmployeeId(String employeeId) {
        Employee emp = new Employee();
        emp.setEmpId(employeeId);
        emp.setEmpName("testEmp");
        System.out.println(emp);
       // employeeDao.insertEmployee(emp);
    }


    public void insertEmployees(List<Employee> employees) {

        //employeeDao.insertEmployees(employees);
    }

    public void getAllEmployees() {
       /* List<Employee> employees = employeeDao.getAllEmployees();
        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
        */
    }


    public void getEmployeeById(String empId) {
        /*Employee employee = employeeDao.getEmployeeById(empId);
        System.out.println(employee);
        */
    }

}
