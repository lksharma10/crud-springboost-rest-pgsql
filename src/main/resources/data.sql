DROP TABLE IF EXISTS employee;
CREATE TABLE employee(id serial PRIMARY KEY, name VARCHAR(100), designation VARCHAR(100), department VARCHAR(100), salary DOUBLE );