CREATE TABLE IF NOT EXISTS groups
(
    id SERIAL NOT NULL PRIMARY KEY ,
    groupName VARCHAR
);

CREATE TABLE IF NOT EXISTS students
(
    id SERIAL NOT NULL PRIMARY KEY ,
    middleName VARCHAR,
    firstName VARCHAR,
    lastName VARCHAR
)
