package com.mastery.java.task.rest;


import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.exceptions.EmployeeAlreadyExistsException;
import com.mastery.java.task.exceptions.NoEmployeesException;
import com.mastery.java.task.exceptions.NoSuchEmployeeException;
import com.mastery.java.task.service.EmployeeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employees/")
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;
    Logger logger = LoggerFactory.getLogger(EmployeeRestController.class);

    @GetMapping("/{employee_id}")
    @ApiOperation(value = "Find employee by id",
            notes = "If you want to find the employee and you know his id use it")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved employee"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")})
    public ResponseEntity<Employee> getEmployee(@PathVariable("employee_id") Long employeeId) {
        Employee employee = this.employeeService.getEmployeeById(employeeId);
        if (employee == null) {
            logger.debug("Get. Where is no employee with id {}", employeeId);
            throw new NoSuchEmployeeException("There is no employee with id " + employeeId);
        }
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully created employee"),
            @ApiResponse(code = 400, message = "Bad request. Employee already exists")})
    @ApiOperation(value = "Employee adding",
            notes = "If you want to add new employee - use it")
    public ResponseEntity<Employee> addEmployee(@RequestBody @Valid Employee employee) {
        HttpHeaders headers = new HttpHeaders();
        if (employeeService.getEmployeeById(employee.getEmployeeId()) != null) {
            throw new EmployeeAlreadyExistsException("Employee with id" + employee.getEmployeeId() + " already exists. You can update it with Put method");
        }
        this.employeeService.addEmployee(employee);

        return new ResponseEntity<>(employee, headers, HttpStatus.CREATED);
    }

    @PutMapping("/{employee_id}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated employee"),
            @ApiResponse(code = 404, message = "The employee you were trying to reach is not found")})
    @ApiOperation(value = "Employee update",
            notes = "If you want to update the employee - use it")
    public ResponseEntity<Employee> updateEmployee(@RequestBody @Valid Employee employee, @PathVariable("employee_id") Long employeeId) {
        HttpHeaders headers = new HttpHeaders();
        if (employeeService.getEmployeeById(employeeId) == null) {
            throw new NoEmployeesException("There is no employee with id " + employee.getEmployeeId() + ". You can create it with Post method");
        }
        this.employeeService.updateEmployee(employee, employeeId);
        return new ResponseEntity<>(employee, headers, HttpStatus.OK);
    }

    @DeleteMapping("/{employee_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Successfully deleted employee"),
            @ApiResponse(code = 404, message = "The employee you were trying to reach is not found")})
    @ApiOperation(value = "Delete employee by id",
            notes = "If you want to delete the employee - use it ")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable("employee_id") Long employeeId) {
        Employee employee = this.employeeService.getEmployeeById(employeeId);
        if (employee == null) {
            logger.debug("Delete. Where is no employee with id {}", employeeId);
            throw new NoSuchEmployeeException("There is no employee with id " + employeeId);
        }
        this.employeeService.removeEmployee(employeeId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping()

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated employees"),
            @ApiResponse(code = 404, message = "The employee you were trying to reach is not found")})
    @ApiOperation(value = "View a list of all employees",
            notes = "Return full list of employers who are added")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = (List<Employee>) this.employeeService.listEmployers();
        if (employees == null) {
            logger.debug("Delete. Where are no employees in DB");
            throw new NoEmployeesException("There are no employees");
        }

        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @PutMapping("/{department_id}/{new_title}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated list"),
            @ApiResponse(code = 404, message = "No employees with the given parameters")})
    @ApiOperation(value = "Update employees job title by department ID",
            notes = "Update employees and lists updated workers in response")
    public ResponseEntity<List<Employee>> updateTitlesByDepartmentId(@PathVariable("department_id") Long departmentId, @PathVariable("new_title") String newTitle) {
        List<Employee> employees = employeeService.updateTitlesByDepartmentId(departmentId, newTitle);
        if (employees.isEmpty()) {
            throw new NoEmployeesException("There are no employees with department id " + departmentId);
        }
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
}
