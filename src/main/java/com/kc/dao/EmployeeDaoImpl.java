package com.kc.dao;

import com.kc.dto.Employee;
import com.kc.service.EmployeeServiceImpl;
import com.kc.util.HibernateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    private HibernateUtil hibernateUtil;
    private static final Logger logger = LoggerFactory.getLogger(EmployeeDaoImpl.class);

    public void insertEmployee(Employee emp) {
        System.out.println("Employee inserted");
        hibernateUtil.create(emp);

    }

    public void insertEmployees(List<Employee> emps) {
        for(Employee emp : emps){
            insertEmployee(emp);
        }
    }

    public List<Employee> getAllEmployees() {
        logger.info("in EmployeeServiceImpl ...");
        return hibernateUtil.fetchAll(Employee.class);
    }

    public Employee getEmployeeById(String empid) {
        return null;
    }
}
