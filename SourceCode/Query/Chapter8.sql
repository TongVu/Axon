/****************************
	     CHAPTER 08
****************************/

-- 1 + 2
CREATE TABLE my_employee(
	id INTEGER NOT NULL,
	last_name VARCHAR(25),
	first_name VARCHAR(25),
	user_id VARCHAR(8),
	salary INTEGER
)


-- 3
INSERT INTO my_employee (
	id,
	last_name,
	first_name,
	user_id,
	salary)
VALUES (1, 'Patel', 'Ralph', 'rpatel', 895)


-- 4
INSERT INTO my_employee (
	id,
	last_name,
	first_name,
	user_id,
	salary)
VALUES (2, 'Dancs', 'Betty', 'bdancs', 860)


-- 5
INSERT INTO my_employee (
	id,
	last_name,
	first_name,
	user_id,
	salary)
VALUES (3, 'Biri', 'Ben', 'bbiri', 1100),
(4, 'Newman', 'Chad', 'cnewman', 750),
(5, 'Ropeburn', 'Audrey', 'aropebur', 1550);


-- 6
-- loademp.sql
CREATE TABLE loademp(
	id INTEGER,
	last_name VARCHAR(25),
	first_name VARCHAR(25),
	user_id VARCHAR(8),
	salary DOUBLE PRECISION
)
INSERT INTO loademp(id, last_name, first_name, user_id, salary)
SELECT id, last_name, first_name, LOWER(LEFT(first_name,1))||LOWER(LEFT(last_name,7)),salary
FROM my_employee WHERE id = 1;


-- 7 + 8
INSERT INTO loademp(id, last_name, first_name, user_id, salary)
SELECT id, last_name, first_name, LOWER(LEFT(first_name,1))||LOWER(LEFT(last_name,7)),salary
FROM my_employee WHERE id = 2;

INSERT INTO loademp(id, last_name, first_name, user_id, salary)
SELECT id, last_name, first_name, LOWER(LEFT(first_name,1))||LOWER(LEFT(last_name,7)),salary
FROM my_employee WHERE id = 3;

INSERT INTO loademp(id, last_name, first_name, user_id, salary)
SELECT id, last_name, first_name, LOWER(LEFT(first_name,1))||LOWER(LEFT(last_name,7)),salary
FROM my_employee WHERE id = 4;

SELECT * FROM loademp

-- 9
UPDATE loademp
SET salary = 1100 WHERE id = 3

-- 10
UPDATE my_employee
SET last_name = 'Drexler'
WHERE id = 3

-- 11
DELETE FROM my_employee WHERE id = 2


-- 12
SELECT * FROM my_employee
ORDER BY id


-- 13
DELETE FROM my_employee WHERE id = 2


-- 14
SELECT * FROM my_employee
ORDER BY id