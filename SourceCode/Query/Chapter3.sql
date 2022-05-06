/****************************
	     CHAPTER 03
****************************/

-- 2 and 3
SELECT employee_id, last_name, salary, (salary + salary*0.155) as "New Salary"
FROM employees


-- 4
SELECT employee_id, 
		last_name, 
			salary, 
			(salary + salary*0.155) AS "New Salary",
			(salary * 0.155) AS "Increase"
FROM employees


-- 6
SELECT last_name,  
	ROUND (Extract(day FROM (NOW()- hire_date))/30) AS "MONTHS WORKED"
FROM employees
ORDER BY "MONTHS WORKED"


-- 7
SELECT (last_name||' earns $' || salary || ' monthly but wants $' || salary * 3) AS "Dream salaries"
FROM employees


-- 8
SELECT last_name, 
	LPAD(cast(salary AS VARCHAR), 15,'$') AS "Salary"
FROM employees

-- 10
SELECT last_name AS "LAST_NAME", 
		hire_date AS "HIRE_DATE", 
		TO_CHAR(hire_date, 'Day') AS "DAY"
FROM employees
ORDER BY EXTRACT(isodow FROM hire_date)
