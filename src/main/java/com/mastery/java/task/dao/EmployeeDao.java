package com.mastery.java.task.dao;

import com.mastery.java.task.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class EmployeeDao implements EmployeeRepo {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void addEmployee(Employee employee) {
        jdbcTemplate.update("insert  into employee ( first_name, " +
                        "gender, " +
                        "last_name, " +
                        "department_id, " +
                        "job_title," +
                        "date_of_birth)  values ( ?, ?, ?, ?, ?,?) ",
                employee.getFirstName(),
                employee.getGender().toString(),
                employee.getLastName(),
                employee.getDepartmentId(),
                employee.getJobTitle(),
                employee.getDateOfBirth());
    }

    @Override
    public void updateEmployee(Employee employee, long id) {
        jdbcTemplate.update("update employee" +
                        " set first_name = ?," +
                        " gender = ?," +
                        " last_name = ?," +
                        " department_id=?," +
                        " job_title = ? ," +
                        "date_of_birth=?" +
                        " WHERE employee_id = ?",
                employee.getFirstName(),
                employee.getGender().toString(),
                employee.getLastName(),
                employee.getDepartmentId(),
                employee.getJobTitle(),
                employee.getDateOfBirth(),
                id);
    }

    @Override
    public void removeEmployee(long id) {

        jdbcTemplate.update("delete from employee where employee_id = ?", id);
    }

    @Override
    public Employee getEmployeeById(int id) {
        String sql = "SELECT * FROM employee WHERE employee_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new EmployeeRowMapper());


    }

    @Override
    public List<Employee> listEmployers() {
        List<Employee> employeeList = jdbcTemplate.query("select * from employee", new EmployeeRowMapper());
        return employeeList;
    }
}
