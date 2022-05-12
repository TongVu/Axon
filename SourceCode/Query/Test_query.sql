-- 1 list all departments that locate in 'HCM'
SELECT *
FROM department
WHERE departmentid = (
	SELECT deptid
	FROM department_location
	WHERE location = 'HCM'
)

-- 2 list all employees that have relative
SELECT *
FROM employee
WHERE employeeid NOT IN (
	SELECT employeeid
	FROM relatives
)

-- 3 all employees assigned to a project for more than 4 hrs
SELECT *
FROM employee
WHERE employeeid IN (
	SELECT employeeid
	FROM assignment
	WHERE number_of_hour > 4
	ORDER BY number_of_hour
)

-- 5 list information of employees who has salary less than 3000
SELECT e.employeeid,
		e.first_name,
		e.last_name,
		e.gender,
		e.salary,
		d.department_name
FROM employee e JOIN department d ON (e.deptid = d.departmentid)
WHERE salary < 3000
ORDER BY salary


-- 6 all projects that the 'IT' department manages it
SELECT *
FROM project
WHERE managed_department = (
	SELECT departmentid -- department IT's id
	FROM department
	WHERE departmentid = 1010
)

-- 7 all projects (project id, project name, department id, department name) that 
-- a department starts after 2020 manage
SELECT *
FROM project
WHERE managed_department = (
	SELECT departmentid -- department starts after 2020
	FROM department
	WHERE start_date > '2020/01/01'
)

-- 8 full name, phone number, and relationship of relatives of employees who have a birthday today
SELECT fullname,
		phone_number,
		relationship
FROM relatives
WHERE employeeid IN (
	SELECT employeeid
	FROM employee
	WHERE EXTRACT(DAY FROM date_of_birth) = (SELECT *FROM EXTRACT (DAY FROM CURRENT_DATE))
	AND EXTRACT (MONTH FROM date_of_birth) = (SELECT * FROM EXTRACT (DAY FROM CURRENT_DATE))
)

-- 9 all projects (project name) with the number of employees and number of hours
SELECT p.project_name,
		COUNT(a.employeeid) AS "number of employees",
		SUM(number_of_hour) AS "number of hours"
FROM assignment a JOIN project p USING (projectid)
GROUP BY (project_name)

-- 10 List of projects at ‘VIETNAM’, number of employees, the total number of hours with the 
-- total number of hours greater than 20 hours
SELECT p.area,
		COUNT(a.employeeid) AS "number of employees",
		SUM(number_of_hour) AS "number of hours"
FROM assignment a JOIN project p USING (projectid)
GROUP BY (p.area)
HAVING SUM(number_of_hour) > 20 AND p.area = 'VIETNAM'

-- 11 List all departments (department name) with the number of employees and the total 
-- salary that the company has to pay
SELECT d.department_name,
		COUNT(department_name) AS "Number of employees",
		(SELECT sum(salary) FROM employee) as "Total salary"
FROM employee e, department d
WHERE e.deptid = d.departmentid
GROUP BY d.department_name


/*  12.
	List project name, employee first name, employee gender, department name of that 
	employee, relative name, and relative phone with all employees that work greater than 
	8 hours for corresponding project.
*/




-- 13 List all employees having a salary greater than the maximum salary of the department “IT”.
SELECT MAX(salary)
FROM employee
WHERE deptid = (
	SELECT departmentid
	FROM department
	WHERE department_name = 'IT'
)

-- 14 List all employees having a salary greater than the minimum salary of the department 
-- “IT” and not belonging to this department. (5 points)

SELECT *
FROM employee
WHERE salary > (
	SELECT MIN(salary)
	FROM employee
	WHERE deptid = (
		SELECT departmentid
		FROM department
		WHERE department_name = 'IT'
	)
) AND employeeid IN (
	SELECT employeeid
	FROM employee
	WHERE deptid NOT IN (
		SELECT departmentid
		FROM department
		WHERE department_name ='IT'
	)
)
ORDER BY salary


