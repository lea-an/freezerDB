DROP TABLE IF EXISTS product; 
DROP TABLE IF EXISTS category; 
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS file_model; 

CREATE TABLE category
(id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(50) NOT NULL);


CREATE TABLE product (
id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(50) NOT NULL,
date DATE,
lastdate DATE,
quantity BIGINT,
categoryid BIGINT);

CREATE TABLE user (
id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
username VARCHAR(50) NOT NULL,
password VARCHAR(200) NOT NULL,
role VARCHAR(50) NOT NULL);

CREATE TABLE file_model (
id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
file_name VARCHAR(200) NOT NULL,
mime_type VARCHAR(200) NOT NULL,
base64str VARCHAR(200),
file LONGBLOB);


INSERT INTO category (name) VALUES ('Marjat'), ('Välipala'), ('Ruoka');

INSERT INTO product (name, date, lastdate, quantity, categoryid) 
VALUES ('Mansikat', '2019-11-04', '2020-02-04', 5, 1), 
('Maksalaatikko', '2019-10-10', '2020-02-10',2, 3);

INSERT INTO user (username, password, role) 
VALUES ("user", "$2a$10$zxPl2U8FBIJcvo/urKZVqOGCgeIz0FLN1v8LEOgbT7RdFEW7boGBW", "USER"), 
("admin", "$2a$10$B9RXEpy0tKunJXu3hp4S4OnazDbsdtcRYAMuWaqn1694JJumqWY7O", "ADMIN");

SELECT * FROM product;
SELECT * FROM category;
SELECT * FROM user; 
SELECT * FROM file_model;