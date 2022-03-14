--Name: Arsalan Arif Radhu
--Student ID: 100813965
--Date: 8 February 2021
--Description: SQL File containing user data

CREATE EXTENSION IF NOT EXISTS pgcrypto;

DROP TABLE IF EXISTS users;
CREATE TABLE users(
                      id BIGINT PRIMARY KEY,
                      password VARCHAR(40) NOT NULL,
                      first_name VARCHAR(128),
                      last_name VARCHAR(128),
                      email_address VARCHAR(255) UNIQUE,
                      last_access DATE,
                      enrol_date DATE,
                      enabled BOOLEAN,
                      type VARCHAR(2)
);

INSERT INTO users (id, password, first_name, last_name, email_address, last_access, enrol_date, enabled, type)
VALUES (100101010, ENCODE(DIGEST('100101010','sha1'), 'hex'), 'Iron', 'Man', 'iron.man@avengers.ca', '2019-03-07', '2002-10-13', true, 's');

INSERT INTO users (id, password, first_name, last_name, email_address, last_access, enrol_date, enabled, type)
VALUES (100813965, ENCODE(DIGEST('100813965', 'sha1'), 'hex'), 'Arsalan', 'Radhu', 'arsalan.radhu@dcmail.ca', '2022-02-08', '2020-11-22', true, 's');

INSERT INTO users (id, password, first_name, last_name, email_address, last_access, enrol_date, enabled, type)
VALUES (100111111, ENCODE(DIGEST('password', 'sha1'), 'hex'), 'Mike', 'Jones', 'mjones@email.com', '2022-02-08', '2021-09-11', true, 's');

INSERT INTO users (id, password, first_name, last_name, email_address, last_access, enrol_date, enabled, type)
VALUES (100234567, ENCODE(DIGEST('100234567', 'sha1'), 'hex'), 'Captain', 'America', 'captain.america@avengers.ca', '2019-01-02', '2000-01-08', true, 'f');

INSERT INTO users (id, password, first_name, last_name, email_address, last_access, enrol_date, enabled, type)
VALUES (100890123, ENCODE(DIGEST('100890123', 'sha1'), 'hex'), 'John', 'Wick', 'john.wick@doglover.org', '2017-11-22', '2012-01-21', true, 'f');

INSERT INTO users (id, password, first_name, last_name, email_address, last_access, enrol_date, enabled, type)
VALUES (100334455, ENCODE(DIGEST('100334455', 'sha1'), 'hex'), 'Percy', 'Jackson', 'percy.jacson@demigod.com', '2012-10-15', '2021-11-28', true, 'f');

SELECT * FROM users;