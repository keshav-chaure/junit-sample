package com.kc.service;

import com.kc.dao.EmployeeDao;
import com.kc.domain.EmployeeMapper;
import com.kc.dto.Employee;
import com.kc.validators.DataValidation;
import com.kc.validators.DataValidationList;
import com.kc.validators.EmployeeValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    EmployeeMapper employeeMapper;




    private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
    private EmployeeValidator employeeValidator;

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

    public void addEmployee(Employee emp) throws Exception {
        Employee DomainEmp=employeeMapper.mapToDomainEmp(emp);
        List<DataValidation> validation=employeeValidator.validate(DomainEmp);
        if(!validation.isEmpty()){
            throw new Exception();
        }
        employeeDao.addEmployee(emp);
    }


    public void insertEmployees(List<Employee> employees) {

        //employeeDao.insertEmployees(employees);
    }

    public void getAllEmployees() {
        logger.info("in EmployeeServiceImpl > getAllEmployee() ...");
        List<Employee> employees = employeeDao.getAllEmployees();
        logger.info("List of Employees");
        for (Employee employee : employees) {
            logger.info("fetched Employee id {}", employee.getEmpId());
            logger.info("fetched Employee {}",employee.toString());
        }
    }


    public void getEmployeeById(String empId) {
        logger.info("in EmployeeServiceImpl ...");
      /*  Employee employee = employeeDao.getEmployeeById(empId);
        System.out.println(employee);*/
    }

}
