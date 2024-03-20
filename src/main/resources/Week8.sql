CREATE DATABASE IF NOT EXIST week8;

USE week8;
    CREATE TABLE IF NOT EXISTS makeup (
        id INT(11) NOT NULL  AUTO_INCREMENT,
        brand VARCHAR(50) NOT NULL,
        product VARCHAR(50) NOT NULL,
        item_no INT(11) NOT NULL,
        year_to_expire INT NOT NULL,
        PRIMARY KEY(id)
    );
CREATE TABLE IF NOT EXISTS manufacturing (
    id INT(11) NOT NULL  AUTO_INCREMENT,
    ingredients VARCHAR(50)  NOT NULL,
    product_cost INT(50) NOT NULL,
    manufacturingcost INT(50) NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY (makeup_id) PREFERENCES manufacturing(id)
);