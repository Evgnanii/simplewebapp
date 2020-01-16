package com.mastery.java.task.dao;

import com.mastery.java.task.dto.Employee;

import java.util.List;

public interface EmployeeRepo {
    public void addEmployee(Employee employee);

    public void updateEmployee(Employee employee, long id);

    public void removeEmployee(long id);

    public Employee getEmployeeById(Long id);

    public List<Employee> listEmployers();
}
