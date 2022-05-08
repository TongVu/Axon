/****************************
	    ERD _ Company
****************************/


/*
	1. CREATE TABLE
*/

-- Create Department
CREATE TABLE department(
	departmentid bigint NOT NULL PRIMARY KEY,
	department_name varchar(20) NOT NULL,
	start_date date
)


-- Create Department Location 
CREATE TABLE department_location(
	id bigint NOT NULL PRIMARY KEY,
	location varchar(100),
	dept_id bigint
)


-- Create Employee
CREATE TABLE employee(
	employee_id varchar(9) NOT NULL PRIMARY KEY,
	date_of_birth date NOT NULL,
	first_name varchar(20) NOT NULL,
	gender varchar(10) NOT NULL,
	last_name varchar(20) NOT NULL,
	middle_name varchar(20) NOT NULL,
	salary int,
	dept_id bigint NOT NULL
)


-- Create Project
CREATE TABLE project(
	project_id bigint NOT NULL PRIMARY KEY,
	area varchar(100),
	project_name varchar(100) NOT NULL,
	managed_department bigint NOT NULL
)


-- Create Assignment
CREATE TABLE assignment(
	id bigint NOT NULL PRIMARY KEY,
	number_of_hour int,
	employee_id varchar(9) NOT NULL,
	project_id bigint NOT NULL
)



-- Create Relatives
CREATE TABLE relatives(
	id bigint NOT NULL PRIMARY KEY,
	fullname varchar(255) NOT NULL,
	gender int NOT NULL,
	phone_number varchar(255) NOT NULL,
	relationship varchar(255) NOT NULL,
	employee_id varchar(9) NOT NULL
)


/*
	2. ADD FOREIGN KEY
*/

-- FROM assignment TO project and employee
ALTER TABLE assignment
ADD CONSTRAINT fk_employee_id -- to employee
	FOREIGN KEY (employee_id)
	REFERENCES employee(employee_id),
ADD CONSTRAINT fk_project_id -- to project
	FOREIGN KEY (project_id)
	REFERENCES project(project_id)



-- FROM project to deparment
ALTER TABLE project
ADD CONSTRAINT fk_department_id
	FOREIGN KEY (managed_department)
	REFERENCES department(departmentid)



-- FROM department_location to deparment
ALTER TABLE department_location
ADD CONSTRAINT fk_dept_id
	FOREIGN KEY (dept_id)
	REFERENCES department(departmentid)



-- FROM employee to deparment
ALTER TABLE employee
ADD CONSTRAINT fk_dept_id
	FOREIGN KEY (dept_id)
	REFERENCES department(departmentid)


