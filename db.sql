CREATE TABLE user (
  id int PRIMARY KEY auto_increment not null,
  username VARCHAR(30),
  password VARCHAR(150)
);

INSERT INTO user(username, password) VALUES ("abc","123");
INSERT INTO user(username, password) VALUES ("bcd","123");
