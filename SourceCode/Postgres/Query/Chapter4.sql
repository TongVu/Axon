/****************************
	     CHAPTER 04
****************************/

-- 1. TRUE

-- 2. FALSE 

-- 3. TRUE


-- 4
SELECT MAX(salary) AS "Maximum",
		MIN(salary) AS "Minimum",
		SUM(salary) AS "Sum",
		AVG(salary) AS "Average"
FROM employees 


-- 5
SELECT job_id,
		MAX(salary) AS "Maximum",
		MIN(salary) AS "Minimum",
		SUM(salary) AS "Sum",
		AVG(salary) AS "Average"
FROM employees 
GROUP BY job_id

-- 6
SELECT job_id,
		COUNT(*)
FROM employees 
GROUP BY job_id
ORDER BY job_id


-- 9
SELECT manager_id, 
		MIN(salary)
FROM employees
WHERE manager_id IS NOT NULL  
GROUP BY manager_id HAVING (MIN(SALARY) > 6000)