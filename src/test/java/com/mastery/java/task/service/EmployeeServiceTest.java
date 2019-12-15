package com.mastery.java.task.service;

import com.mastery.java.task.dao.EmployeeDao;
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
    EmployeeDao employeeDao;

    @Test
    public void findAllTest() {
        List<Employee> employees = employeeDao.listEmployers();
        assertEquals(11, employees.size());
    }

    @Test
    public void getByIdTest() {
        Employee employee = employeeDao.getEmployeeById(2);
        assertEquals("John", employee.getFirstName());
    }

    @Test
    public void createTest() {
        int size = employeeDao.listEmployers().size();
        employeeDao.addEmployee(new Employee("Dmitry", "Sergievich", new Date(1998, 1, 31), "Manager", (long) 5, Gender.MALE));
        assertEquals(size + 1, employeeDao.listEmployers().size());
    }

    @Test
    public void updateTest() {
        employeeDao.updateEmployee(new Employee("Dmitry", "Sergievich", new Date(1998, 1, 31), "HR manager", (long) 5, Gender.MALE), 11);

        assertEquals("HR manager", employeeDao.getEmployeeById(11).getJobTitle());
    }

    @Test
    public void deleteTest() {
        int size = employeeDao.listEmployers().size();
        employeeDao.removeEmployee(5);
        assertEquals(size - 1, employeeDao.listEmployers().size());
    }
}
