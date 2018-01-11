
package com.kc.dto;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Employee")
public class Employee implements Serializable {

    @Column(name = "name")
    String empName;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int empId;

    @Override
    public String toString() {
        return "Employee{" +
                "empName='" + empName + '\'' +
                ", empId='" + empId + '\'' +
                '}';
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }
}
