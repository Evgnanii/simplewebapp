package com.mastery.java.task.dto;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @Column(name = "employee_id")
    @GeneratedValue
    private Long employeeId;
    @NotNull(message = "First name cannot be null")
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    @NotNull(message = "Last name cannot be null")
    private String lastName;
    @Column(name = "date_of_birth")
    private Date dateOfBirth;
    @Column(name = "job_title")
    @NotNull(message = "Job title cannot be null")
    private String jobTitle;
    @Max(message = "Were are only 10 departments", value = 15)
    @NotNull(message = "Department id cannot be null")
    @Column(name = "department_id")
    private Long departmentId;
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Gender cannot be null")
    @Column(name = "gender")
    private Gender gender;

    public Employee() {
    }

    public Employee(Long id, String firstName, String lastName, Date dateOfBirth, String jobTitle, Long departmentId, String gender) {
        this.employeeId = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.jobTitle = jobTitle;
        this.departmentId = departmentId;
        this.gender = Gender.valueOf(gender);
    }

    public Employee(String firstName, String lastName, Date dateOfBirth, String jobTitle, Long departmentId, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.jobTitle = jobTitle;
        this.departmentId = departmentId;
        this.gender = Gender.valueOf(gender);
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public Gender getGender() {
        return gender;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return
                "employeeId=" + employeeId +
                        ", firstName='" + firstName + '\'' +
                        ", lastName='" + lastName + '\'' +
                        ", dateOfBirth=" + dateOfBirth +
                        ", jobTitle='" + jobTitle + '\'' +
                        ", departmentId=" + departmentId +
                        ", gender=" + gender
                ;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}