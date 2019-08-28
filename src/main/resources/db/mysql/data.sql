-- INSERT IGNORE INTO user (username, password, email, role) VALUES ('bot1', '123123', 'bot1@gmail.com', 'member');
-- INSERT IGNORE INTO user (username, password, email, role) VALUES ('bot2', '123123', 'bot2@gmail.com', 'member');
-- INSERT IGNORE INTO user (username, password, email, role) VALUES ('bot3', '123123', 'bot3@gmail.com', 'member');
-- INSERT IGNORE INTO user (username, password, email, role) VALUES ('bot4', '123123', 'bot4@gmail.com', 'member');
-- INSERT IGNORE INTO user (username, password, email, role) VALUES ('bot5', '123123', 'bot5@gmail.com', 'member');
-- INSERT IGNORE INTO user (username, password, email, role) VALUES ('bot6', '123123', 'bot6@gmail.com', 'member');
-- INSERT IGNORE INTO user (username, password, email, role) VALUES ('bot7', '123123', 'bot7@gmail.com', 'admin');

-- INSERT INTO skill_level( `skill_level` ) VALUES(1),(2),(3),(4),(5),(6),(7),(8),(9),(10);
INSERT INTO skills( `skill_name` ) VALUES("Ruby"),("JS"),("Node"),("Express"),("Ember"),("CSS"),("Java"),("NativeSc"),("Vue"),("React");
INSERT IGNORE INTO roles (id, name) VALUES ('1', 'ROLE_USER');
INSERT IGNORE INTO roles (id, name) VALUES ('2', 'ROLE_ADMIN');