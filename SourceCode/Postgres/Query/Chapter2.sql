/****************************
	     CHAPTER 02
****************************/


-- 1
SELECT last_name, salary
FROM employees
WHERE salary > 12000


-- 2
SELECT last_name, department_id
FROM employees
WHERE employee_id = 176


--3
SELECT last_name, salary
FROM employees
WHERE salary < 5000 OR salary > 12000


--4
SELECT last_name, job_id, hire_date
FROM employees
WHERE last_name = 'Matos' OR last_name = 'Taylor'
ORDER BY hire_date ASC


-- 5
SELECT last_name, department_id
FROM employees
WHERE department_id in (20, 50)
ORDER BY last_name ASC


-- 6
SELECT last_name as "Employee", 
		salary as "Monthly Salary"
FROM employees
WHERE (salary >= 5000 AND salary <= 12000) AND
		(department_id IN (20, 50))
ORDER BY salary DESC


-- 7
SELECT last_name, hire_date
FROM employees
WHERE extract (year FROM hire_date) = 1994
-- WHERE hire_date BETWEEN '1994-01-01' AND '1994-12-31'
-- WHERE '[1994-01-01,1995-01-01]'::daterange@> hire_date


-- 8
SELECT last_name, job_id
FROM employees
WHERE manager_id IS NULL


-- 12
SELECT last_name
FROM employees
WHERE last_name LIKE '__a%'


-- 13
SELECT last_name
FROM employees
WHERE last_name LIKE '%a%' AND 
		last_name LIKE '%e%'


-- 14
SELECT last_name, job_id, salary
FROM employees
WHERE (job_id = 'SA_REP' OR job_id = 'ST_CLERK')
		AND (salary <> 2500 
			 AND salary <> 3500 
			 AND salary <> 7000)
ORDER BY salary DESC


-- 15
SELECT last_name, salary, commission_pct
FROM employees
WHERE commission_pct = .2
