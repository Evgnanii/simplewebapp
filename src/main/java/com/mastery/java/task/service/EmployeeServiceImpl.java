package com.mastery.java.task.service;

import com.mastery.java.task.dao.EmployeeDaoHibernate;
import com.mastery.java.task.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDaoHibernate employeeDaoHibernate;

    @Override
    public void addEmployee(Employee employee) {employeeDaoHibernate.save(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeDaoHibernate.save(employee);
    }

    @Override
    public void removeEmployee(Long id) {
        employeeDaoHibernate.deleteById(id);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return  employeeDaoHibernate.findByEmployeeId(id);
    }

    @Override
    public List<Employee> listEmployers() {
        return (List<Employee>) employeeDaoHibernate.findAll();
    }
}
