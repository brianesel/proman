CREATE DATABASE IF NOT EXISTS promanDB;

ALTER DATABASE promanDB
  DEFAULT CHARACTER SET utf8
  DEFAULT COLLATE utf8_general_ci;

USE promanDB;

CREATE TABLE `roles` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `company` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(300) DEFAULT NULL,
  `website` varchar(8000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) unique NULL,
  `name` varchar (50) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar (50) unique NULL,
  `location` varchar (200) DEFAULT NULL,
  `degree` varchar (200) DEFAULT NULL,
  `phone_number` VARCHAR (100) DEFAULT NULL,
  `date_of_birth` DATE DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKob8kqyqqgmefl0aco34akdtpe` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `user_roles` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  KEY `FKt4v0rrweyk393bdgt107vdx0x` (`role_id`),
  KEY `FKgd3iendaoyh04b95ykqise6qh` (`user_id`),
  CONSTRAINT `FKgd3iendaoyh04b95ykqise6qh` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FKt4v0rrweyk393bdgt107vdx0x` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `user_company` (
  `user_id` bigint(20) NOT NULL,
  `company_id` bigint(20) NOT NULL,
  KEY `grBHZaVzKQ569qkyEp5g4MYMMpf` (`company_id`),
  KEY `z72C5GgxvXs5ut4C5eS3j5Gbua7` (`user_id`),
  CONSTRAINT `grBHZaVzKQ569qkyEp5g4MYMMpf` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `z72C5GgxvXs5ut4C5eS3j5Gbua7` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `social_media` (
  `id` bigint(20) NOT NULL,
  `linkedin` varchar(8000) DEFAULT NULL,
  `github` varchar(8000) DEFAULT NULL,
  `twitter` varchar(8000) DEFAULT NULL,
  `facebook` varchar(8000) DEFAULT NULL,
  KEY `g34RGaVzKQ53RFDyEp5g4MYMMpf` (`id`),
  CONSTRAINT `g34RGaVzKQ53RFDyEp5g4MYMMpf` FOREIGN KEY (`id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `skills` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `skill_name` varchar(250) UNIQUE DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `skill_level` (
  `skill_level` INT,
  PRIMARY KEY (`skill_level`)
) ENGINE = InnoDB;

CREATE TABLE `user_skills` (
  `user_id` bigint(20) NOT NULL,
  `skill_id` bigint(20) NOT NULL,
  `level` INT(2) DEFAULT 1,
  KEY `MDWOUIaqj8JVu9oyxnetEe733rF` (`user_id`),
  KEY `8IpvB3Lo1KkUCZ96dLTpJJdl6Eb` (`skill_id`),
  KEY `5ykesldriySyHLohBQeCHtjfv0H` (`level`),
  CONSTRAINT `MDWOUIaqj8JVu9oyxnetEe733rF` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `8IpvB3Lo1KkUCZ96dLTpJJdl6Eb` FOREIGN KEY (`skill_id`) REFERENCES `skills` (`id`),
  CONSTRAINT `5ykesldriySyHLohBQeCHtjfv0H` FOREIGN KEY (`level`) REFERENCES `skill_level` (`skill_level`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO skill_level( `skill_level` ) VALUES(1),(2),(3),(4),(5),(6),(7),(8),(9),(10);
INSERT INTO skills( `skill_name` ) VALUES("Ruby"),("JS"),("Node"),("Express"),("Ember"),("CSS"),("Java"),("NativeSc"),("Vue"),("React");
INSERT IGNORE INTO roles (id, name) VALUES ('1', 'ROLE_USER');
INSERT IGNORE INTO roles (id, name) VALUES ('2', 'ROLE_ADMIN');