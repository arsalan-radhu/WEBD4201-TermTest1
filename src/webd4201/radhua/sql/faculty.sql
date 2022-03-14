--Name: Arsalan Arif Radhu
--Student ID: 100813965
--Description: SQL File containing faculty data

CREATE EXTENSION IF NOT EXISTS pgcrypto;

DROP TABLE IF EXISTS faculty;
CREATE TABLE faculty (
                         id BIGINT PRIMARY KEY,
                         school_code VARCHAR(5),
                         school_description VARCHAR(255),
                         office VARCHAR(5),
                         phone_extension INT,
                         FOREIGN KEY(id) REFERENCES users(id)
);

INSERT INTO faculty (id, school_code, school_description, office, phone_extension)
VALUES (100234567, 'AV', 'Avengers School of Superheroes', 'A-22', 911);

INSERT INTO faculty (id, school_code, school_description, office, phone_extension)
VALUES (100890123, 'JW', 'School of Dog Appreciation', 'D-1', 266);

INSERT INTO faculty (id, school_code, school_description, office, phone_extension)
VALUES (100334455, 'CHB', 'Camp Half-Blood', 'H-53', 999);

SELECT * FROM faculty;