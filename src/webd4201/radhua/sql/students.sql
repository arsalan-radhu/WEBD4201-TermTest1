--Name: Arsalan Arif Radhu
--Student ID: 100813965
--Date: 8 February 2021
--Description: SQL File containing student data

CREATE EXTENSION IF NOT EXISTS pgcrypto;

DROP TABLE IF EXISTS students;
CREATE TABLE students (
                          id BIGINT PRIMARY KEY,
                          program_code VARCHAR(4),
                          program_description VARCHAR(255),
                          year INT,
                          FOREIGN KEY(id) REFERENCES users(id)
);

INSERT INTO students (id, program_code, program_description, year) VALUES (100101010, 'CPA', 'Computer Programmer Analyst', 3);

INSERT INTO students (id, program_code, program_description, year) VALUES (100813965, 'CPA', 'Computer Programmer Analyst', 2);

INSERT INTO students (id, program_code, program_description, year) VALUES (100111111, 'CSTY', 'Computer System Technology', 3);

SELECT * FROM students;