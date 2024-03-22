CREATE DATABASE IF NOT EXISTS week8;

USE exampledatabase;

CREATE TABLE IF NOT EXISTS makeup (
                          id int NOT NULL AUTO_INCREMENT,
                          brand varchar(50) NOT NULL,
                          product varchar(50) NOT NULL,
                          item_no int NOT NULL,
                          year_to_expire int NOT NULL,
                          PRIMARY KEY (id)
);


CREATE TABLE IF NOT EXISTS manufacturing (
                                 id int NOT NULL AUTO_INCREMENT,
                                 makeup_id INT NOT NULL,
                                 ingredients varchar(50) NOT NULL,
                                 productcost int NOT NULL,
                                 manufacturingcost int NOT NULL,
                                 PRIMARY KEY (id),
                                 FOREIGN KEY (makeup_id) REFERENCES (makeup_id),

);


