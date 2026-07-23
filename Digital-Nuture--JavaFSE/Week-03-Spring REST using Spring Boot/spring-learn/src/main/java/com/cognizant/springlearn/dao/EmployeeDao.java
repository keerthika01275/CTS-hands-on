package com.cognizant.springlearn.dao;

import com.cognizant.springlearn.Employee;
import com.cognizant.springlearn.service.exception.EmployeeNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDao {
    // In-memory mock database
    private static List<Employee> EMPLOYEE_LIST = new ArrayList<>();

    public EmployeeDao() {
        // Pre-populating a mock employee so we can actually test PUT and DELETE operations
        Employee emp = new Employee();
        emp.setId(1L);
        emp.setName("Mock Employee");
        emp.setSalary(75000.0);
        emp.setPermanent(true);
        EMPLOYEE_LIST.add(emp);
    }

    public List<Employee> getAllEmployees() {
        return EMPLOYEE_LIST;
    }

    public void updateEmployee(Employee employee) throws EmployeeNotFoundException {
        for (int i = 0; i < EMPLOYEE_LIST.size(); i++) {
            if (EMPLOYEE_LIST.get(i).getId().equals(employee.getId())) {
                EMPLOYEE_LIST.set(i, employee);
                return;
            }
        }
        throw new EmployeeNotFoundException("Employee with ID " + employee.getId() + " not found");
    }

    public void deleteEmployee(Long id) throws EmployeeNotFoundException {
        boolean removed = EMPLOYEE_LIST.removeIf(emp -> emp.getId().equals(id));
        if (!removed) {
            throw new EmployeeNotFoundException("Employee with ID " + id + " not found");
        }
    }
}
