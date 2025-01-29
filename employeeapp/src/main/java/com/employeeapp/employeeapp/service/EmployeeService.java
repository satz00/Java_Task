package com.employeeapp.employeeapp.service;

import com.employeeapp.employeeapp.entity.Employee;
import com.employeeapp.employeeapp.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(String id) {
        return employeeRepository.findById(id).orElse(null);
    }
}
