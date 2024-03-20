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
                                 makeup_id int NOT NULL,
                                 ingredients varchar(50) NOT NULL,
                                 productcost int NOT NULL,
                                 manufacturingcost int NOT NULL,
                                 id int NOT NULL AUTO_INCREMENT,
                                 PRIMARY KEY (id),
                                 KEY makeup_id (makeup_id),

);


