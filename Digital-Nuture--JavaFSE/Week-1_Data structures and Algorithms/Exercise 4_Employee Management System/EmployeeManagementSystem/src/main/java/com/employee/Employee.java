package com.employee;

public class Employee {
    private final int employeeId;
    private String name;
    private String position;
    private double salary;
    private String department;

    public Employee(int employeeId, String name, String position, double salary, String department) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
        this.department = department;
    }

    // Getters and Setters
    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return String.format("Employee{id=%d, name='%s', position='%s', salary=%.2f, department='%s'}", 
            employeeId, name, position, salary, department);
    }
}
