package com.mastery.java.task.rest;

import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.service.EmployeeService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class EmployeeRestController {
    @Autowired
    private EmployeeService employeeService;
    Logger logger = LoggerFactory.getLogger(EmployeeRestController.class);

    @GetMapping("/{id}")
    @ApiOperation(value = "Find employee by id",
            notes = "If you want to find the employee and you know his id use it")
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") Long employeeId) {
        Employee employee = this.employeeService.getEmployeeById(employeeId);
        if (employee == null) {
            logger.debug("Get. Where is no employee with id" + employeeId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping()
    @ApiOperation(value = "Employee adding",
            notes = "If you want to add new employee - use it")
    public ResponseEntity<Employee> addEmployee(@RequestBody @Valid Employee employee) {
        HttpHeaders headers = new HttpHeaders();
        if (employee == null) {
            logger.debug("Post. Bad request, employee is null or bad request from user");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.employeeService.addEmployee(employee);
        return new ResponseEntity<>(employee, headers, HttpStatus.CREATED);
    }


    @PutMapping()
    @ApiOperation(value = "Employee update",
            notes = "If you want to update the employee - use it")
    public ResponseEntity<Employee> updateEmployee(@RequestBody @Valid Employee employee) {
        HttpHeaders headers = new HttpHeaders();
        if (employee == null) {
            logger.debug("Put. Bad request, employee is null or bad request from user");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.employeeService.updateEmployee(employee);
        return new ResponseEntity<>(employee, headers, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete employee by id",
            notes = "If you want to delete the employee - use it ")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") Long id) {
        Employee employee = this.employeeService.getEmployeeById(id);
        if (employee == null) {
            logger.debug("Delete. Where is no employee with id "+ id);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.employeeService.removeEmployee(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping()
    @ApiOperation(value = "View a list of all employees",
            notes = "Return full list of employers who are added")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = (List<Employee>) this.employeeService.listEmployers();
        if (employees == null) {
            logger.debug("Delete. Where are no employees in DB");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

}
