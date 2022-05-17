/****************************
	     CHAPTER 01
****************************/

/*	
	PART 1 
*/

-- 3. TRUE
SELECT last_name, job_id, salary AS Sal
FROM employees;

-- 4. TRUE
SELECT * 
FROM job_grades;

-- 5. 
-- ERROR FROM THE SLIDES
SELECT employee_id, last_name, sal x 12 ANNUAL SALARY
FROM employees;

-- CORRECT THE ERROR
SELECT employee_id, last_name, salary*12 AS "Annual Salary"
FROM employees;

/*	***************
	PART 2 
*/

-- 8
SELECT employees.employee_id AS employee_id, 
		employees.last_name AS last_name, 
		employees.job_id as job_id, 
		job_history.start_date as start_date
FROM employees, job_history

-- 9
SELECT DISTINCT job_id FROM employees

-- 10
SELECT employees.employee_id as "#emp",
	employees.first_name as "Employee",
	employees.job_id as "Jobs",
	employees.hire_date as "Hire Date"
FROM employees

-- 11
SELECT last_name||', '||job_id as "Employee and Title"
FROM employees