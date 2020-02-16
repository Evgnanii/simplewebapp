create database employeedb;
create table employee
(
    employee_id   serial primary key,
    first_name    varchar not null,
    last_name     varchar not null,
    department_id int     not null,
    job_title     varchar not null,
    gender        varchar not null,
    date_of_birth date

);


insert into employee(employee_id, first_name, last_name, department_id, job_title, gender, date_of_birth)
values (DEFAULT, 'Evgeni', 'Nikonovich', random() * 3 + 1, 'Junior programmer', 'MALE',
        date((current_date - '65 years'::interval) +
             trunc(random() * 365) * '1 day'::interval +
             trunc(random() * 50) * '1 year'::interval));
insert into employee(employee_id, first_name, last_name, department_id, job_title, gender, date_of_birth)
values (DEFAULT, 'John', 'Johnson', random() * 3 + 1, 'Middle programmer', 'MALE',
        date((current_date - '65 years'::interval) +
             trunc(random() * 365) * '1 day'::interval +
             trunc(random() * 50) * '1 year'::interval));
insert into employee(employee_id, first_name, last_name, department_id, job_title, gender, date_of_birth)
values (DEFAULT, 'Ivan', 'Ivanov', random() * 3 + 1, 'Middle programmer', 'MALE',
        date((current_date - '65 years'::interval) +
             trunc(random() * 365) * '1 day'::interval +
             trunc(random() * 50) * '1 year'::interval));
insert into employee(employee_id, first_name, last_name, department_id, job_title, gender, date_of_birth)
values (DEFAULT, 'Jack', 'Jackson', random() * 3 + 1, 'Middle programmer', 'MALE',
        date((current_date - '65 years'::interval) +
             trunc(random() * 365) * '1 day'::interval +
             trunc(random() * 50) * '1 year'::interval));
insert into employee(employee_id, first_name, last_name, department_id, job_title, gender, date_of_birth)
values (DEFAULT, 'Brad', 'Pitt', random() * 3 + 1, 'Senior programmer', 'MALE',
        date((current_date - '65 years'::interval) +
             trunc(random() * 365) * '1 day'::interval +
             trunc(random() * 50) * '1 year'::interval));
insert into employee(employee_id, first_name, last_name, department_id, job_title, gender, date_of_birth)
values (DEFAULT, 'Andrew', 'Jefferson', random() * 3 + 1, 'QA tester', 'MALE',
        date((current_date - '65 years'::interval) +
             trunc(random() * 365) * '1 day'::interval +
             trunc(random() * 50) * '1 year'::interval));
insert into employee(employee_id, first_name, last_name, department_id, job_title, gender, date_of_birth)
values (DEFAULT, 'Andy', 'Dufresne', random() * 3 + 1, 'Director', 'MALE',
        date((current_date - '65 years'::interval) +
             trunc(random() * 365) * '1 day'::interval +
             trunc(random() * 50) * '1 year'::interval));
insert into employee(employee_id, first_name, last_name, department_id, job_title, gender, date_of_birth)
values (DEFAULT, 'Peter', 'Jackson', random() * 3 + 1, 'HR manager', 'MALE',
        date((current_date - '65 years'::interval) +
             trunc(random() * 365) * '1 day'::interval +
             trunc(random() * 50) * '1 year'::interval));
insert into employee(employee_id, first_name, last_name, department_id, job_title, gender, date_of_birth)
values (DEFAULT, 'Marilyn', 'Monroe', random() * 3 + 1, 'QA tester', 'FEMALE',
        date((current_date - '65 years'::interval) +
             trunc(random() * 365) * '1 day'::interval +
             trunc(random() * 50) * '1 year'::interval));
insert into employee(employee_id, first_name, last_name, department_id, job_title, gender, date_of_birth)
values (DEFAULT, 'Natalie', 'Portman', random() * 3 + 1, 'Junior programmer', 'FEMALE',
        date((current_date - '65 years'::interval) +
             trunc(random() * 365) * '1 day'::interval +
             trunc(random() * 50) * '1 year'::interval));
insert into employee(employee_id, first_name, last_name, department_id, job_title, gender, date_of_birth)
values (DEFAULT, 'Scarlett', 'Johansson', random() * 3 + 1, 'Senior programmer', 'FEMALE',
        date((current_date - '65 years'::interval) +
             trunc(random() * 365) * '1 day'::interval +
             trunc(random() * 50) * '1 year'::interval));


