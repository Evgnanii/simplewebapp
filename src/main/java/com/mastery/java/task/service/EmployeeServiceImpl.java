package com.mastery.java.task.service;

import com.mastery.java.task.ActiveMQ.MyMessage;
import com.mastery.java.task.ActiveMQ.Producer;
import com.mastery.java.task.dao.EmployeeDaoHibernate;
import com.mastery.java.task.dto.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    Producer producer;
    @Autowired
    private EmployeeDaoHibernate employeeDaoHibernate;
    Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Override
    public Employee addEmployee(Employee employee) {
        logger.debug("User tried to add a new employee {}", employee);
        employeeDaoHibernate.save(employee);
        logger.info("Created new employee with id {}", employee.getEmployeeId());
        logger.debug("Created new employee {}", employee);
        return employee;

    }

    @Override
    public void updateEmployee(Employee employee, Long employeeId) {
        logger.debug("User tried to update the employee with id {} to {}", employeeId, employee);
        employee.setEmployeeId(employeeId);
        employeeDaoHibernate.save(employee);
        logger.info("Employee with id {} was updated", employee.getEmployeeId());
        logger.debug("Employee with id {} was updated to {}", employee.getEmployeeId(), employee);
    }

    @Override
    public void removeEmployee(Long id) {
        logger.debug("User tried to delete the employee with id {}", id);
        employeeDaoHibernate.deleteById(id);
        logger.info("Employee with id {} was deleted", id);

    }

    @Override
    public Employee getEmployeeById(Long id) {
        logger.debug("User tried to get the employee with id {}", id);
        logger.info("The user received data about employee with id {}", id);
        return employeeDaoHibernate.findByEmployeeId(id);
    }


    @Override
    public List<Employee> listEmployers() {
        return (List<Employee>) employeeDaoHibernate.findAll();
    }

    @Override
    public void sendMessage(Long id, String title) {
        MyMessage message = new MyMessage(id, title);
        producer.sendMessage(message);
    }

    @Override
    public List<Employee> updateTitlesByDepartmentId(Long departmentId, String newDepartmentTitle) {
        List<Employee> updatedEmployees = new LinkedList<>();
        List<Employee> employees;
        employees = employeeDaoHibernate.findAll();
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getDepartmentId() == departmentId) {
                employees.get(i).setJobTitle(newDepartmentTitle);
                employeeDaoHibernate.save(employees.get(i));
                updatedEmployees.add(employees.get(i));
            }
        }
        return updatedEmployees;
    }
}
