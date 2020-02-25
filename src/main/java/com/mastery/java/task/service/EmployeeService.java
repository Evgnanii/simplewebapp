package com.mastery.java.task.service;

import com.mastery.java.task.dto.Employee;

public interface EmployeeService {
    public Employee addEmployee(Employee employee);

    public void updateEmployee(Employee employee);

    public void removeEmployee(Long id);

    public Employee getEmployeeById(Long id);

    public Iterable<Employee> listEmployers();
}
