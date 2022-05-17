/****************************
	     CHAPTER 06
****************************/

-- 1
SELECT last_name, 
		hire_date,
		department_id
FROM employees
WHERE department_id = ( -- department_id = department_id_of_the_searched_name
			SELECT department_id
			FROM employees
			WHERE last_name = 'Zlotkey' -- put the searched_name here
) AND last_name <> 'Zlotkey'


-- 2
SELECT employee_id,
		last_name,
		salary
FROM employees
WHERE salary > (
		SELECT AVG(salary)
		FROM employees
	)
ORDER BY salary ASC


-- 3
SELECT employee_id,
		last_name
FROM employees
WHERE department_id IN (
	SELECT department_id
	FROM employees
	WHERE last_name LIKE '%u%'
) 


-- 4
SELECT last_name,
		department_id,
		job_id
FROM employees
WHERE department_id IN (
	SELECT department_id
	FROM departments
	WHERE location_id = 1700
	)
	
	
-- 5
SELECT last_name,
		salary
FROM employees
WHERE manager_id = (
	SELECT employee_id
	FROM employees
	WHERE employee_id = 100
)


-- 6
SELECT department_id,
		last_name,
		job_id
FROM employees
WHERE department_id = 90


-- 7
SELECT employee_id,
		last_name,
		salary
FROM employees
WHERE salary > ( -- SALARY > average salary
	SELECT AVG(salary)
	FROM employees
) AND department_id IN ( -- department_id same with people who have a and u in their name
	SELECT department_id
	FROM employees
	WHERE last_name LIKE '%u%'
)

