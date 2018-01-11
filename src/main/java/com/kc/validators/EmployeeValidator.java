package com.kc.validators;

import com.kc.dto.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeValidator {
    ArrayList<DataValidation> errors= new ArrayList<DataValidation>();
    public List<DataValidation> validate(Employee emp) {
        validateName(emp);
        validateEmpId(emp);
        return errors;

    }

    private void validateName(Employee emp) {
        if(emp.getEmpName().isEmpty()){
           errors.add(new DataValidation("name is not present"));
        }
    }

    private void validateEmpId(Employee emp) {
        if(emp.getEmpName().isEmpty()){
            errors.add(new DataValidation("name is not present"));
        }
    }

}

