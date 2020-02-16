package com.mastery.java.task.dao;

import com.mastery.java.task.dto.Employee;
import org.springframework.data.repository.CrudRepository;


public interface EmployeeDaoHibernate extends CrudRepository<Employee, Long> {
    Employee findByEmployeeId(Long id);

}
