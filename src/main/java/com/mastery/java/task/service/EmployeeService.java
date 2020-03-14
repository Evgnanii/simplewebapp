package com.mastery.java.task.service;

import com.mastery.java.task.dto.Employee;

import java.util.List;

public interface EmployeeService {
    public Employee addEmployee(Employee employee);

    public void updateEmployee(Employee employee, Long employeeId);

    public void removeEmployee(Long id);

    public Employee getEmployeeById(Long id);

    public Iterable<Employee> listEmployers();

    public void sendMessage(Long id, String title);

    public List<Employee> updateTitlesByDepartmentId(Long departmentId, String newDepartmentTitle);
}
