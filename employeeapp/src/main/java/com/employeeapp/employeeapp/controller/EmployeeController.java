package com.employeeapp.employeeapp.controller;

import com.employeeapp.employeeapp.entity.Employee;
import com.employeeapp.employeeapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/employee")
    public String index(Model model) {
        model.addAttribute("employee", new Employee());
        return "index";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute Employee employee, Model model) {
        Employee savedEmployee = employeeService.saveEmployee(employee);
        model.addAttribute("message", "Employee saved successfully!");
        model.addAttribute("employee", new Employee()); // Reset form
        return "index";
    }

    @GetMapping("/displayAll")
    public String displayAllEmployee(Model model) {
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        return "employeeList";
    }

    @GetMapping("/display/{id}")
    public String displayEmployeeById(@PathVariable String id, Model model) {
        Employee employee= employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "employeeDetails";
    }
}
