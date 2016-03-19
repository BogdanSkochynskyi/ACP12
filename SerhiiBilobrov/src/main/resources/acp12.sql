CREATE DATABASE ACP12;


CREATE TABLE addresses (
  id INT PRIMARY KEY,
  city VARCHAR (20),
  street VARCHAR (20),
  house_num int
);

INSERT INTO addresses(id,city) VAlUES (1,'Kiev');
INSERT INTO addresses(id,city) VAlUES (2,'Odessa');
INSERT INTO addresses(id,city) VAlUES (3,'Kharkiv');

CREATE TABLE students(
  name VARCHAR(20),
  mail VARCHAR(255) UNIQUE NOT NULL,
  age int,
  birth DATE NOT NULL,
  salary DOUBLE,
  address_id INT,
  FOREIGN KEY(address_id) REFERENCES addresses(id)
);

CREATE TABLE

INSERT INTO students(name,birth,salary,address) VALUES ('Serhii',NOW(),3000.00,'Kiev');
INSERT INTO students(name,birth,salary,address) VALUES ('Oleg',NOW(),6000.00,'Odessa');
INSERT INTO students(name,birth,salary,address) VALUES ('Ivan',NOW(),2000.00,'Kharkiv');
INSERT INTO students(name,birth,salary,address) VALUES ('Gavriil',NOW(),13000.00,'Kiev');

SELECT * FROM students;
SELECT name, birth FROM students;
