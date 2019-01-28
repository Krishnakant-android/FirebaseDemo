package com.krishna.firebaseproject.module;

public class Employee {
    private String empId;
    private String empName;
    private String empDesignation;
 

    public Employee(String empId, String empName, String empDesignation) {
        this.empId = empId;
        this.empName = empName;
        this.empDesignation = empDesignation;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpDesignation() {
        return empDesignation;
    }

    public void setEmpDesignation(String empDesignation) {
        this.empDesignation = empDesignation;
    }
}