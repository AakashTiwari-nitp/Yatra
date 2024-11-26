CREATE DATABASE yatra_db;

use yatra_db;

CREATE TABLE tours (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    location VARCHAR(255) NOT NULL,
    price DOUBLE NOT NULL,
    available_seats INT NOT NULL
);
