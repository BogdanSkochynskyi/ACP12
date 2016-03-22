CREATE DATABASE ACP12;


CREATE TABLE addresses (
  id INT PRIMARY KEY AUTO_INCREMENT,
  city VARCHAR (20),
  street VARCHAR (20),
  house_num int
);

INSERT INTO addresses(city) VAlUES ('Kiev');
INSERT INTO addresses(city) VAlUES ('Odessa');
INSERT INTO addresses(city) VAlUES ('Kharkiv');

CREATE TABLE students(
  name VARCHAR(20),
  mail VARCHAR(255) UNIQUE NOT NULL,
  age int,
  birth DATE NOT NULL,
  salary DOUBLE,
  address_id INT,
  FOREIGN KEY(address_id) REFERENCES addresses(id)
);


INSERT INTO students(name,birth,mail,salary,address_id) VALUES ('Serhii',NOW(),'abc@mail.ru',3000.00,2);
INSERT INTO students(name,birth,mail,salary,address_id) VALUES ('Oleg',NOW(),'abc2@mail.ru',4000.00,1);
INSERT INTO students(name,birth,mail,salary,address_id) VALUES ('Ivan',NOW(),'abc3@mail.ru',5000.00,1);

SELECT * FROM students;
SELECT name, birth FROM students;
