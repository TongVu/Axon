/****************************
	     CHAPTER 10
****************************/

-- 1 + 2
CREATE VIEW employees_vu
AS
SELECT employee_id,
		last_name AS "employee",
		department_id
FROM employees
ORDER BY department_id

SELECT * FROM employees_vu

-- 3
SELECT employee,
		department_id
FROM employees_vu
ORDER BY department_id

-- 4 + 5
CREATE VIEW dept50
AS
	SELECT employee_id AS "EMPNO",
			last_name AS "DEPT",
			department_id
	FROM employees
	WHERE department_id = 50
	
SELECT * FROM dept50