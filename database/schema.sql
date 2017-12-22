-- *************************************************************************************************
-- This script creates all of the database objects (tables, sequences, etc) for the database
-- *************************************************************************************************

BEGIN;
CREATE TABLE users(
	userId SERIAL primary key,
	userName VARCHAR (64) UNIQUE,
	password VARCHAR (64),
	firstName VARCHAR (64),
	lastName VARCHAR (64),
	salt VARCHAR (255)
);

CREATE TABLE restaurants(
	restaurantId SERIAL primary key,
	restaurantName VARCHAR (128),
	streetAddress VARCHAR (128),
	zipCode VARCHAR (12),
	foodType VARCHAR (64),
	rating INTEGER
);

-- CREATE statements go here

COMMIT;