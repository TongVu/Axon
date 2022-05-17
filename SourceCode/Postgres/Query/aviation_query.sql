-- 1. Show all flights arrive to Da Lat
SELECT flight_id,
	departure_time,
	arrival_time,
	price
FROM flights
WHERE arrival_terminal = 'DAD'
ORDER BY departure_time


-- 2. Show all aircrafts which has a range more than 10,000km
SELECT aircraft_id,
	aircraft_type,
	aircraft_range
FROM aircrafts
WHERE aircraft_range > 10000


-- 3. Show all employees who have salary < 10,000
SELECT *
FROM employees
WHERE salary < 10000


-- 4. Show all flights which have distance < 10.000km
SELECT *
FROM flights
WHERE distance < 10000 AND distance > 8000
ORDER BY distance


-- 5. Show all flights from Saigon to Ban Me Thuot
SELECT *
FROM flights
WHERE departure_terminal = 'SGN'
	AND arrival_terminal = 'BMV'
ORDER BY departure_time


-- 6. Show number of all flights from Sai Gon
SELECT count(*) as "Total flights from Sai Gon"
FROM flights
WHERE departure_terminal = 'SGN'


-- 7. How many Boeing aircrafts
SELECT count(aircraft_type) AS "Total BOEING aircrafts"
FROM aircrafts
WHERE aircraft_type LIKE '%Boeing%'
	OR aircraft_type LIKE '%boeing%'


-- 8. Show total salary have to pay to all employees
SELECT SUM(salary)
FROM employees


-- 9. Show id of all pilots who fly BOEING aircraft_id
SELECT *
FROM employees
WHERE employee_id IN (
		SELECT employee_id
		FROM certificates
		WHERE aircraft_id IN (
			SELECT aircraft_id
			FROM aircrafts
			WHERE aircraft_id IN (727, 737, 747, 757, 767, 777)
		)
	)



-- 10. Show all employees who can fly the aircraft has id 747
SELECT *
FROM employees
WHERE employee_id IN (
	SELECT employee_id
	FROM certificates
	WHERE aircraft_id = '747'
)


-- 11. Show all aircraft_id that people has name Nguyen can fly 
SELECT aircraft_id -- aircraft_id of employee_id that match Nguyen
FROM certificates
WHERE employee_id IN (
		SELECT employee_id -- all employees who's name is Nguyen
		FROM employees
		WHERE employee_name LIKE '%Nguyen%'
	)
	
	
-- 12. Show all pilots' id who can fly Boeing and Airbus
SELECT employee_id -- pilots who can flight boeing
FROM certificates
WHERE aircraft_id IN ( 
	SELECT aircraft_id
	FROM aircrafts
	WHERE LOWER(aircraft_type) LIKE '%boeing%'
)
INTERSECT
SELECT employee_id -- pilots who can flight airbus
FROM certificates
WHERE aircraft_id IN ( 
	SELECT aircraft_id
	FROM aircrafts
	WHERE LOWER(aircraft_type) LIKE '%airbus%'
)


-- 13. Show all aircrafts which can operate VN280 flight 
SELECT aircraft_id
FROM aircrafts
WHERE aircraft_range >= ( -- compare aircraft_range with the distance
	SELECT distance -- get the distance from the flights
	FROM flights
	WHERE flight_id = 'VN280'
)


-- 14. Show all flights can be operate by the Airbus A320 aircraft
SELECT flight_id
FROM flights
WHERE distance < ( -- if the distance smaller than the range, then it's safe to fly
	SELECT aircraft_range -- get the range of Airbus A320
	FROM aircrafts
	WHERE aircraft_type = 'Airbus A320'
)


-- 15. Show all pilots' name who can fly Boeing
SELECT employee_name -- get their name
FROM employees
WHERE employee_id IN (
	SELECT employee_id -- find all the id of employee who can fly boeing
	FROM certificates
	WHERE aircraft_id IN (
		SELECT aircraft_id -- find all the boeing id
		FROM aircrafts
		WHERE LOWER(aircraft_type) LIKE '%boeing%'
	)
)


-- 16. With each aircraft, show aircraft_id, aircraft_type and total pilots who can fly that aicraft
SELECT aircraft_id,
		aircraft_type,
		COUNT(employee_id) AS "Total pilots can fly"
FROM aircrafts JOIN certificates USING (aircraft_id)
GROUP BY aircraft_id


-- 17. Show all the flights have a round flight
SELECT destinationA.flight_id, 
	destinationA.departure_terminal, 
	destinationA.arrival_terminal,
	destinationB.flight_id, 
	destinationB.departure_terminal, 
	destinationB.arrival_terminal
FROM flights AS destinationA, flights AS destinationB
WHERE destinationA.departure_terminal = destinationB.arrival_terminal
	AND destinationA.arrival_terminal = destinationB.departure_terminal
	
	
-- 18. count all the depatures from each terminal
SELECT departure_terminal,
		COUNT(departure_time) AS "Departures"
FROM flights
GROUP BY departure_terminal


-- 19. Show all the salary have to pay for the pilots each terminal
SELECT flight_id,
	departure_terminal,
	SUM(price) AS "Total payment"
FROM flights
GROUP BY flight_id, departure_terminal
ORDER BY SUM(price)


-- 20. Show all the flights have departure time before 12:00
SELECT flight_id,
	departure_time,
	arrival_time
FROM flights
WHERE departure_time < '12:00:00'
ORDER BY departure_time


-- 21. At each location, count all the flights could depature before 12:00
SELECT departure_terminal,
		COUNT(departure_terminal) as "Flights before 12"
FROM flights
WHERE departure_time < '12:00:00'
GROUP BY departure_terminal


-- 22. Show id pilots who can fly only 3 aircraft
SELECT employee_id, 
	count(aircraft_id) AS "Number of aircrafts"
FROM certificates
GROUP BY employee_id
HAVING count(aircraft_id) = 3


-- 23. With each pilots who can fly more than 3 aircrafts,
-- show pilots' id and max range of each aircraft that pilot can fly
SELECT employee_id,
		MAX(aircraft_range) AS "MAX range the aircraft can fly"		
FROM certificates JOIN aircrafts USING(aircraft_id)
WHERE employee_id IN (
		SELECT employee_id -- a bunch of id who can fly more than 3 aircrafts
		FROM certificates
		GROUP BY employee_id
		HAVING count(aircraft_id) > 3
	)
GROUP BY employee_id


-- 24. With each pilot, show that pilot's id and the number of aircrafts that pilot can fly
SELECT employee_id,
		count(aircraft_id)
FROM certificates
GROUP BY employee_id


-- 25. Find all employees who aren't pilot
SELECT * 
FROM employees
WHERE employee_id NOT IN (
	SELECT employee_id
	FROM certificates
)


-- 26. Show id of employees who have the highest salary
SELECT employee_id
FROM employees
WHERE salary = (
	SELECT MAX(salary)
	FROM employees
)


-- 27. Show total salary have to pay for all the pilots
SELECT SUM(salary) AS "Total salary to pay for all the pilots"
FROM employees
WHERE employee_id IN (
	SELECT employee_id -- these employee are the one who have certificate to fly aircraft
	FROM certificates
)


-- 28. Show all the flights which can be done by Boeing aircrafts
SELECT flight_id,
		distance
FROM flights
WHERE distance < ( -- if the distance < range of the boeing, then all of them can fly
	SELECT MIN(aircraft_range) -- get the smallest distance boeing aircrafts can operate
	FROM aircrafts
	WHERE LOWER(aircraft_type) LIKE '%boeing%' -- get all the boeing aircrafts
)


















