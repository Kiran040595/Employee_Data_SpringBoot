--liquibase formatted sql
--DO NOT DELETE ABOVE LINE. IT IS NEEDED BY LIQUIBASE.

 

--changeset kiran.dadi:001 failOnError:true splitStatements:false logicalFilePath:employee.sql

 

CREATE TABLE employee_demo
(
    emp_id SERIAL,
    employee_name VARCHAR(50) NOT NULL,
    role VARCHAR(50) NOT NULL,
    CONSTRAINT employee_data_pkey PRIMARY KEY (emp_id)
)	

--changeset kiran.dadi:002 failOnError:true splitStatements:false logicalFilePath:employee.sql

ALTER TABLE employee_demo

ADD COLUMN emp_address VARCHAR(100)

--changeset kiran.dadi:003 failOnError:true splitStatements:false logicalFilePath:employee.sql

ALTER TABLE employee_demo

ADD COLUMN age int


