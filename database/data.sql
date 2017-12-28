-- *****************************************************************************
-- This script contains INSERT statements for populating tables with seed data
-- *****************************************************************************

BEGIN;
INSERT INTO users (userName, password, firstName, lastName, salt) VALUES ('RickRicardo', 'ilovelucy!1', 'Rick', 'Wiley', 'ipreferpepper');
INSERT INTO users (userName, password, firstName, lastName, salt) VALUES ('SamLovesCheese', 'cantbeontimetosavemylife', 'Sam', 'Auvil', 'cheeseistheway');
INSERT INTO users (userName, password, firstName, lastName, salt) VALUES ('RoscoePecoTrain', 'icantbelieveSammadeusdothisalone', 'Ross', 'Fischer', 'saltysalt101');

INSERT INTO restaurants (restaurantName, streetAddress, zipCode, foodType, rating) VALUES ('Chipotle', '3725 Paxton Ave', '45212', 'Burritos', '4');
INSERT INTO restaurants (restaurantName, streetAddress, zipCode, foodType, rating) VALUES ('Subway', '4580 Montgomery Rd', '45212', 'Subs', '4');
INSERT INTO restaurants (restaurantName, streetAddress, zipCode, foodType, rating) VALUES ('Skyline Chili', '4588 Montgomery Rd', '45212', 'Chili', '4');
INSERT INTO restaurants (restaurantName, streetAddress, zipCode, foodType, rating) VALUES ('Lemon Grass Thai Cuisine', '2666 Madison Rd', '45208', 'Thai', '5');
INSERT INTO restaurants (restaurantName, streetAddress, zipCode, foodType, rating) VALUES ('Buffalo Wild Wings', '2692 Madison Rd', '45208', 'Chicken Wings', '4');
INSERT INTO restaurants (restaurantName, streetAddress, zipCode, foodType, rating) VALUES ('Hitching Post', '2715 Madison Rd', '45208', 'Fried Chicken', '5');
INSERT INTO restaurants (restaurantName, streetAddress, zipCode, foodType, rating) VALUES ('Green Papaya', '2942 Wasson Rd', '45209', 'Sushi', '5');
INSERT INTO restaurants (restaurantName, streetAddress, zipCode, foodType, rating) VALUES ('Singha Contemporary Thai & Sushi', '2912 Wasson Rd', '45209', 'Sushi', '4');
INSERT INTO restaurants (restaurantName, streetAddress, zipCode, foodType, rating) VALUES ('Penn Station', '3646 Edwards Rd', '45208', 'Subs', '4');
INSERT INTO restaurants (restaurantName, streetAddress, zipCode, foodType, rating) VALUES ('Taco Bell', '4478 Montgomery Rd', '45212', 'Mexican', '2');
INSERT INTO restaurants (restaurantName, streetAddress, zipCode, foodType, rating) VALUES ('Kentucky Fried Chicken', '4478 Montgomery Rd', '45212', 'Fried Chicken', '2');
INSERT INTO restaurants (restaurantName, streetAddress, zipCode, foodType, rating) VALUES ('Wendys', '4474 Montgomery Rd', '45212', 'Burgers', '2');
INSERT INTO restaurants (restaurantName, streetAddress, zipCode, foodType, rating) VALUES ('Jimmy Johns', '4440 Montgomery Rd', '45212', 'Subs', '3');
INSERT INTO restaurants (restaurantName, streetAddress, zipCode, foodType, rating) VALUES ('Cancun Mexican', '4410 Montgomery Rd', '45212', 'Mexican', '4');
INSERT INTO restaurants (restaurantName, streetAddress, zipCode, foodType, rating) VALUES ('Gordos', '4328 Montgomery Rd', '45212', 'Burgers', '5');

COMMIT;