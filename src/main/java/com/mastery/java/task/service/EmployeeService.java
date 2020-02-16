package com.mastery.java.task.service;

import com.mastery.java.task.dto.Employee;

import java.util.List;

public interface EmployeeService {
    public void addEmployee(Employee employee);

    public void updateEmployee(Employee employee);

    public void removeEmployee(Long id);

    public Employee getEmployeeById(Long id);

    public Iterable<Employee> listEmployers();
}
