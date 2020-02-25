package com.mastery.java.task.rest;

import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;


    @GetMapping
    public String main(Map<String, Object> model) {
        Iterable<Employee> employees = employeeServiceImpl.listEmployers();
        model.put("employers", employees);
        return "Employee";

    }

    @PostMapping("add")
    public String add(@RequestParam String firstName,
                      @RequestParam String gender,
                      @RequestParam String lastName,
                      @RequestParam Long departmentId,
                      @RequestParam String jobTitle,
                      @RequestParam Date dateOfBirth,
                      Map<String, Object> model) {
        Employee employee = new Employee(firstName, lastName, dateOfBirth, jobTitle, departmentId, gender);
        employeeServiceImpl.addEmployee(employee);
        List<Employee> employees = employeeServiceImpl.listEmployers();
        model.put("employers", employees);
        return "Employee";
    }

    @PostMapping("delete")
    public String delete(@RequestParam long id, Map<String, Object> model) {
        employeeServiceImpl.removeEmployee(id);
        Iterable<Employee> employees = employeeServiceImpl.listEmployers();
        model.put("employers", employees);
        return "Employee";
    }

    @PostMapping("update")
    public String delete(
            @RequestParam String firstName,
            @RequestParam String gender,
            @RequestParam String lastName,
            @RequestParam Long departmentId,
            @RequestParam String jobTitle,
            @RequestParam Long id,
            @RequestParam Date dateOfBirth,
            Map<String, Object> model) {
        Employee employee = new Employee(id, firstName, lastName, dateOfBirth, jobTitle, departmentId, gender);
        employeeServiceImpl.updateEmployee(employee);
        Iterable<Employee> employees = employeeServiceImpl.listEmployers();
        model.put("employers", employees);
        return "Employee";
    }
}
