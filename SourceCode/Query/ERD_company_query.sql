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
	deptid bigint
)


-- Create Employee
CREATE TABLE employee(
	employeeid varchar(9) NOT NULL PRIMARY KEY,
	date_of_birth date NOT NULL,
	first_name varchar(20) NOT NULL,
	gender varchar(10) NOT NULL,
	last_name varchar(20) NOT NULL,
	middle_name varchar(20) NOT NULL,
	salary int,
	deptid bigint NOT NULL
)


-- Create Project
CREATE TABLE project(
	projectid bigint NOT NULL PRIMARY KEY,
	area varchar(100),
	project_name varchar(100) NOT NULL,
	managed_department bigint NOT NULL
)


-- Create Assignment
CREATE TABLE assignment(
	id bigint NOT NULL PRIMARY KEY,
	number_of_hour int,
	employeeid varchar(9) NOT NULL,
	projectid bigint NOT NULL
)



-- Create Relatives
CREATE TABLE relatives(
	id bigint NOT NULL PRIMARY KEY,
	fullname varchar(255) NOT NULL,
	gender int NOT NULL,
	phone_number varchar(255) NOT NULL,
	relationship varchar(255) NOT NULL,
	employeeid varchar(9) NOT NULL
)

/*
	2. ADD FOREIGN KEY
*/

-- FROM assignment TO project and employee
ALTER TABLE assignment
ADD CONSTRAINT fk_employeeid -- to employee
	FOREIGN KEY (employeeid)
	REFERENCES employee(employeeid),
ADD CONSTRAINT fk_projectid -- to project
	FOREIGN KEY (projectid)
	REFERENCES project(projectid)



-- FROM project to deparment
ALTER TABLE project
ADD CONSTRAINT fk_managed_department
	FOREIGN KEY (managed_department)
	REFERENCES department(departmentid)



-- FROM department_location to deparment
ALTER TABLE department_location
ADD CONSTRAINT fk_deptid
	FOREIGN KEY (deptid)
	REFERENCES department(departmentid)



-- FROM employee to deparment
ALTER TABLE employee
ADD CONSTRAINT fk_deptid
	FOREIGN KEY (deptid)
	REFERENCES department(departmentid)

-- FROM relatives to employee
ALTER TABLE relatives
ADD CONSTRAINT fk_employeeid
	FOREIGN KEY (employeeid)
	REFERENCES employee(employeeid)

/*
	employe_id :_ (0001, 0002, .. 0020) increase by 1
	department_id :_ (1010, 1020 .. 1100) increase by 10
	project_id :_ (2010, 2020 .. 2100) increase by 10 has 10 records
	assignment_id:_ (1011, 1021, 1031, ... 1211)
	relatives_id:_ (10001, 10002, .. 10020)
	
*/
INSERT INTO department(
	departmentid,
	department_name,
	start_date
)
VALUES 
	(1010, 'IT', '2000/07/12'),
	(1020, 'Sales', '2012/06/08'),
	(1030, 'Hr', '2003/08/03'),
	(1040, 'R&D', '2012/05/01'),
	(1050, 'Customer Service', '2018/11/10'),
	(1060, 'Finance', '2016/08/13'),
	(1070, 'Accounting', '2021/12/14'),
	(1080, 'Marketing', '2017/05/18'),
	(1090, 'Administration', '2007/07/07'),
	(1100, 'Media', '2015/05/20')





INSERT INTO project(
	projectid,
	area,
	project_name,
	managed_department
)
VALUES 
	(2010,  'New Orland',           'HELIOS', 1010),
	(2020,  'New Jersey',           'REGENT', 1020),
	(2030,    'Kentucky',            'COBRA', 1030),
	(2040, 'Matsachuset',            'EAGLE', 1040),
	(2050,     'Orlando',           'BEAVER', 1050),
	(2060,      'Zurich',     'ALONELY WOLF', 1060), 
	(2070,       'Basel',     'HAPPY POTATO', 1070),
	(2080,     'Lucerne', 'SMILES FOR CHILD', 1080),
	(2090,      'Geneva', 'YOU DONT KNOW JS', 1090),
	(2100, 'Ho Chi Minh',     'NONITPROGRAM', 1100)




INSERT INTO department_location(
	id,
	location,
	deptid
)
VALUES 
	(678, 'New York', 1010),
	(679, 'New Orland', 1020),
	(680, 'Ho Chi Minh', 1030),
	(681, 'Singapore', 1040),
	(682, 'Taiwan', 1050),
	(683, 'Washington', 1060),
	(684, 'L.A', 1070),
	(685, 'Chicago', 1080),
	(686, 'New Jersey', 1090),
	(687, 'California', 1100)






INSERT INTO employee(
	employeeid,
	date_of_birth,
	first_name,
	gender,
	last_name,
	middle_name,
	salary,
	deptid
)
VALUES 
			('0001', '1999/12/24',  'Linh',  'female',     'Vo',       'Van', 1000, 1010),
            ('0002', '2000/07/26',  'Khoa',    'male',    'Mac',       'Van', 1200, 1030),
            ('0003', '1995/04/12',   'Nam',    'male', 'Nguyen',     'Thanh', 1000, 1030),
            ('0004', '1998/12/14',  'Hung',    'male', 'Truong',     'Thanh', 3300, 1040),
            ('0005', '1997/05/10',    'Vu',    'male',   'Tong',          '', 4200, 1050),
            ('0006', '1996/05/08',   'Anh',  'female', 'Nguyen', 'Ngoc Truc', 5700, 1100),
            ('0007', '1993/06/17',  'Liem',    'male',     'Ha',     'Thanh', 9000, 1100),
            ('0008', '1994/08/23',   'Huy',    'male', 'Truong',      'Quoc', 5000, 1040),
            ('0009', '2000/04/29', 'Phuoc',    'male',     'Ho',       'Huu', 4000, 1070),
            ('0010', '1998/07/30',  'Ngoc',  'female', 'Truong',       'Thi',  800, 1080),
            ('0011', '1998/01/31',   'Hai',    'male',   'Tran',       'Van', 1800, 1010),
            ('0012', '1996/02/14',    'Au',    'male',     'Le',       'Hai', 2300, 1020),
            ('0013', '1992/03/18',   'Cao',    'male', 'Nguyen',       'Kim', 1600, 1060),
            ('0014', '1980/09/22',   'Chu',  'female',     'Le',          '', 1400, 1070),
            ('0015', '1983/10/23',   'Anh',    'male', 'Nguyen',       'Hai', 2300, 1060),
            ('0016', '1987/12/05','Thuong',  'female',   'Tran',      'Hoai', 3300, 1010),
            ('0017', '1989/11/02',   'Lam',  'female',    'Phu',     'Thanh', 3100, 1020),
            ('0018', '1991/11/03', 'Phong',    'male', 'Truong',      'Hoai', 1700, 1090),
            ('0019', '1990/08/08',  'Kieu',  'female', 'Nguyen',     'Thanh', 2200, 1070),
            ('0020', '1994/10/04',  'Hanh',  'female', 'Nguyen',       'Thi', 1800, 1070)




INSERT INTO relatives(
	id,
	fullname,
	gender,
	phone_number,
	relationship,
	employeeid
)
VALUES 
	(10001, 'John Harvard', 1, '0934120150','father', '0001'),
	(10002, 'Jack Dorsey', 1, '0904777555','uncle', '0002'),
	(10003, 'Elon Musk', 1, '0901414818','step-father', '0004'),
	(10004, 'Bill Gates', 1, '0914422555','little uncle', '0003'),
	(10005, 'Richard Johnson', 1, '0915898989','father', '0001'),
	(10006, 'Steve Wozniack', 1, '0931567907','father', '0003'),
	(10007, 'Steve Jobs', 1, '0913512412','father', '0005'),
	(10008, 'Bill Ellen', 1, '0913531531','kin', '0006'),
	(10009, 'Richard Brandson', 1, '0934891572','father', '0007'),
	(10000, 'Donald Trumph', 1, '0903000513','kin', '0008'),
	(10011, 'Barrack Obama', 1, '0903582653','father', '0009'),
	(10012, 'Usaint Bolt', 1, '0905818562','father', '0010'),
	(10013, 'Stephen Curry', 1, '0929181482','father', '0011'),
	(10014, 'Linus Tovarld', 1, '0915358372','father', '0012'),
	(10015, 'Uncle Bob', 1, '0901468523','father', '0015'),
	(10016, 'Miranda Kerr', 0, '0909914312','mother', '0016'),
	(10017, 'Jeff Dean', 1, '0931592837','father', '0013'),
	(10018, 'Marisa Meyer', 0, '0934150813','aunt', '0020'),
	(10019, 'King James', 1, '0929555888','father', '0019'),
	(10020, 'Marrilin Monroe', 0, '0918538175','mother', '0017')




INSERT INTO assignment(
	id,
	number_of_hour,
	employeeid,
	projectid
)
VALUES 
	(1011, 5000, '0001', 2010),
	(1021, 5230, '0002', 2030),
	(1031, 5011, '0003', 2030),
	(1041, 4200, '0004', 2040),
	(1051, 1454, '0005', 2050),
	(1061, 6522, '0006', 2100),
	(1071, 4604, '0007', 2100),
	(1081, 5050, '0008', 2040),
	(1091, 3100, '0009', 2070),
	(1101, 5400, '0010', 2080),
	(1111, 3600, '0011', 2010),
	(1121, 1070, '0012', 2020),
	(1131, 5150, '0013', 2060),
	(1141, 5940, '0014', 2070),
	(1151, 1560, '0015', 2060),
	(1161, 1507, '0016', 2010),
	(1171, 5006, '0017', 2020),
	(1181, 1570, '0018', 2090),
	(1191, 5410, '0019', 2070),
	(1201, 6110, '0020', 2070)
	


