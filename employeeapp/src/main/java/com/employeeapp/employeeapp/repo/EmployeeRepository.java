package com.employeeapp.employeeapp.repo;

import com.employeeapp.employeeapp.entity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
}
