package com.mastery.java.task.service;

import com.mastery.java.task.dao.EmployeeDaoHibernate;
import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.dto.Gender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class EmployeeServiceTest {
    @Autowired
    EmployeeDaoHibernate employeeDaoHibernate;

    @Test
    public void findAllTest() {
        List<Employee> employees = (List<Employee>) employeeDaoHibernate.findAll();
        assertEquals(11, employees.size());
    }

    @Test
    public void getByIdTest() {
        Employee employee = employeeDaoHibernate.findByEmployeeId(2L);
        assertEquals("John", employee.getFirstName());
    }

    @Test
    public void createTest() {
        int size = ((List<Employee>) employeeDaoHibernate.findAll()).size();
        employeeDaoHibernate.save(new Employee("Dmitry", "Sergievich", new Date(1998, 1, 31), "Manager", (long) 5, Gender.MALE));
        assertEquals(size + 1, ((List<Employee>) employeeDaoHibernate.findAll()).size());
    }

    @Test
    public void updateTest() {
        employeeDaoHibernate.save(new Employee("Dmitry", "Sergievich", new Date(1998, 1, 31), "HR manager", (long) 5, Gender.MALE));

        assertEquals("HR manager", employeeDaoHibernate.findByEmployeeId(11L).getJobTitle());
    }

    @Test
    public void deleteTest() {
        int size = ((List<Employee>) employeeDaoHibernate.findAll()).size();
        employeeDaoHibernate.deleteById(5L);
        assertEquals(size - 1, ((List<Employee>) employeeDaoHibernate.findAll()).size());
    }
}
