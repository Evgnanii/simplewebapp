package com.mastery.java.task.service;

import com.mastery.java.task.dao.EmployeeDaoHibernate;
import com.mastery.java.task.dto.Employee;
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
@Transactional()
public class EmployeeServiceTest {
    @Autowired
    EmployeeDaoHibernate employeeDaoHibernate;

    @Test
    public void createTest() {
        int size = (employeeDaoHibernate.findAll()).size();
        employeeDaoHibernate.save(new Employee("Dmitry", "Sergievich", new Date(1998, 1, 31), "Manager", (long) 5, "MALE"));
        assertEquals(size + 1, ( employeeDaoHibernate.findAll()).size());
    }

    @Test
    public void updateTest() {
        employeeDaoHibernate.save(new Employee("Dmitry", "Sergievich", new Date(1998, 1, 31), "HR manager", (long) 5, "MALE"));

        assertEquals("HR manager", employeeDaoHibernate.findByEmployeeId(1L).getJobTitle());
    }

    @Test
    public void findAllTest() {
        List<Employee> employees = employeeDaoHibernate.findAll();
        assertEquals(1, employees.size());
    }

    @Test
    public void getByIdTest() {
        Employee employee = employeeDaoHibernate.findByEmployeeId(1L);
        assertEquals("Dmitry", employee.getFirstName());
    }


    @Test
    public void deleteTest() {
        int size = ((List<Employee>) employeeDaoHibernate.findAll()).size();
        employeeDaoHibernate.deleteById(1L);
        assertEquals(size - 1, (employeeDaoHibernate.findAll()).size());
    }
}
