package com.employeeapp.employeeapp.entity;

import lombok.Data;
import lombok.Generated;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "employee")
public class Employee {
    @Id
    private String id;
    private String employeeName;
    private String employeeEmail;
    private String location;
}
