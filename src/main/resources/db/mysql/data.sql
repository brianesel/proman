-- INSERT IGNORE INTO user (username, password, email, role) VALUES ('bot1', '123123', 'bot1@gmail.com', 'member');
-- INSERT IGNORE INTO user (username, password, email, role) VALUES ('bot2', '123123', 'bot2@gmail.com', 'member');
-- INSERT IGNORE INTO user (username, password, email, role) VALUES ('bot3', '123123', 'bot3@gmail.com', 'member');
-- INSERT IGNORE INTO user (username, password, email, role) VALUES ('bot4', '123123', 'bot4@gmail.com', 'member');
-- INSERT IGNORE INTO user (username, password, email, role) VALUES ('bot5', '123123', 'bot5@gmail.com', 'member');
-- INSERT IGNORE INTO user (username, password, email, role) VALUES ('bot6', '123123', 'bot6@gmail.com', 'member');
-- INSERT IGNORE INTO user (username, password, email, role) VALUES ('bot7', '123123', 'bot7@gmail.com', 'admin');

INSERT role (id, name) value (1, "ROLE_USER");
INSERT role (id, name) value (9, "ROLE_ADMIN");
INSERT user (id, email, first_name, last_name, password) VALUES (69, "admin@gmail.com", "password", "admin", "$2y$12$VsmLDnqt.oU8n7MKLsc/qeFNxn6jYwEcctw8lJb/YwdLAr7L/f5wm");
INSERT users_roles (user_id, role_id) VALUES (69, 9);
INSERT users_roles (user_id, role_id) VALUES (69, 1);