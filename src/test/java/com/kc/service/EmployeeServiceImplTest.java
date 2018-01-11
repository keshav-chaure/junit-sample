package com.kc.service;

import com.kc.dao.EmployeeDao;
import com.kc.dao.EmployeeDaoImpl;
import com.kc.domain.EmployeeMapper;
import com.kc.dto.Employee;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

;

public class EmployeeServiceImplTest extends TestCase {
    @Mock
    private EmployeeDao employeeDao;

    @InjectMocks
    private EmployeeService employeeServiceImpl ;
    @Mock
    private EmployeeMapper employeeMapper;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        System.out.println("setup");
    }

    @Test
    public void testEmployee() {
        Employee emp = new Employee();

        employeeServiceImpl.insertEmployee(emp);

        // here we can verify directly with the emp object we are
        // passing while calling to the service
        verify(employeeDao).insertEmployee(emp);
    }

    @Test
    public void testEmployeeWithEmployeeId() {
        ArgumentCaptor<Employee> captor = ArgumentCaptor.forClass(Employee.class);

        Employee emp = new Employee();
        emp.setEmpId(123);
        emp.setEmpName("testEmp");

        employeeServiceImpl.insertEmployeeUsingEmployeeId(123);

        // here we dont have instance of employee object(since it is created in
        // the service class
        // and not passed externally) but we want to verify the employee
        // object which was used to call repository. So we use captor.
        // passing while calling to the service
        verify(employeeDao).insertEmployee(captor.capture());

        //get the Employee object used by the employeeDao using ArgumentCaptor
        Employee actual = captor.getValue();
        assertEquals(emp.getEmpName(), actual.getEmpName());
        assertEquals(emp.getEmpId(), actual.getEmpId());

    }

    @Test
    public void shouldAddEmployee() throws Exception {
        Employee e=new Employee();
        when(employeeMapper.mapToDomainEmp(e)).thenReturn(e);

        employeeServiceImpl.addEmployee(e);

    }

}