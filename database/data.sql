-- *****************************************************************************
-- This script contains INSERT statements for populating tables with seed data
-- *****************************************************************************

BEGIN;
INSERT INTO user (userName, password, firstName, lastName, salt) VALUES ('RickRicardo', 'ilovelucy!1', 'Rick', 'Wiley', 'ipreferpepper');
INSERT INTO user (userName, password, firstName, lastName, salt) VALUES ('SamLovesCheese', 'cantbeontimetosavemylife', 'Sam', 'Auvil', 'cheeseistheway');
INSERT INTO user (userName, password, firstName, lastName, salt) VALUES ('RoscoePecoTrain', 'icantbelieveSammadeusdothisalone', 'Ross', 'Fischer');

INSERT INTO restaurant (restaurantName, streetAddress, zipCode, foodType, rating) VALUES ('Chipotle', '3725 Paxton Ave', '45212', 'Burritos', '2');
INSERT INTO restaurant (restaurantName, streetAddress, zipCode, foodType, rating) VALUES ('Subway', '4580 Montgomery Rd', '45212', 'Subs', '3');
INSERT INTO restaurant (restaurantName, streetAddress, zipCode, foodType, rating) VALUES ('Skyline Chili', '4588 Montgomery Rd', '45212', 'Chili', '3');

COMMIT;