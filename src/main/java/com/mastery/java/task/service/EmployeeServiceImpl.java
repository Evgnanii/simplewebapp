package com.mastery.java.task.service;

import com.mastery.java.task.dao.EmployeeDao;
import com.mastery.java.task.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    @Override
    @Transactional
    public void addEmployee(Employee employee) {employeeDao.addEmployee(employee);
    }

    @Override
    @Transactional
    public void updateEmployee(Employee employee, long id) {
        employeeDao.updateEmployee(employee, id);
    }

    @Override
    @Transactional
    public void removeEmployee(long id) {
        employeeDao.removeEmployee(id);
    }

    @Override
    @Transactional
    public Employee getEmployeeById(Long id) {
        return  employeeDao.getEmployeeById(id);
    }

    @Override
    @Transactional
    public List<Employee> listEmployers() {
        return  employeeDao.listEmployers();
    }
}
