CREATE DATABASE IF NOT EXISTS promanDB;

ALTER DATABASE promanDB
  DEFAULT CHARACTER SET utf8
  DEFAULT COLLATE utf8_general_ci;

USE promanDB;

CREATE TABLE IF NOT EXISTS users (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(30),
  last_name VARCHAR(30),
  email VARCHAR(100),
  username VARCHAR(50),
  password VARCHAR(100),
  role VARCHAR(10)
); 
INSERT IGNORE INTO users (username, password, email, role) VALUES ('bot1', '123123', 'bot1@gmail.com', 'member');
INSERT IGNORE INTO users (username, password, email, role) VALUES ('bot2', '123123', 'bot2@gmail.com', 'member');
INSERT IGNORE INTO users (username, password, email, role) VALUES ('bot3', '123123', 'bot3@gmail.com', 'member');
INSERT IGNORE INTO users (username, password, email, role) VALUES ('bot4', '123123', 'bot4@gmail.com', 'member');
INSERT IGNORE INTO users (username, password, email, role) VALUES ('bot5', '123123', 'bot5@gmail.com', 'member');
INSERT IGNORE INTO users (username, password, email, role) VALUES ('bot6', '123123', 'bot6@gmail.com', 'member');
INSERT IGNORE INTO users (username, password, email, role) VALUES ('bot7', '123123', 'bot7@gmail.com', 'admin');

