CREATE TABLE user (
  id int PRIMARY KEY auto_increment not null,
  username VARCHAR(30),
  password VARCHAR(150)
);

INSERT INTO user(username, password) VALUES ('ceo','123');
INSERT INTO user(username, password) VALUES ('dto','123');
INSERT INTO user(username, password) VALUES ('mochilas','123');

create table job (
  id int PRIMARY KEY auto_increment not null,
  job VARCHAR(100) not null
);

INSERT INTO job(job) VALUES ('CEO');
INSERT INTO job(job) VALUES ('DTO');
INSERT INTO job(job) VALUES ('mochilas');

create table employee(
  id int PRIMARY KEY auto_increment not null,
  name VARCHAR(150) not null,
  paternalName VARCHAR(150) not null,
  maternalName VARCHAR(150) not null,
  birthday DATE ,
  email VARCHAR(150) not null,
  jobId int REFERENCES job(id),
  userId int REFERENCES user(id)
);

insert into employee(name,paternalName,maternalName,birthday,email, jobId, userId) VALUES ('Mark Anthony','Arreguin','Gonzalez','2008-7-04','ceo@opal.com',1,1);
insert into employee(name,paternalName,maternalName,birthday,email, jobId, userId) VALUES ('Richy','Gallegos','Gallegos','2008-7-04','dto@opal.com',2,2);
insert into employee(name,paternalName,maternalName,birthday,email, jobId, userId) VALUES ('Cristian','Perez',':v','2008-7-04','mochilas@opal.com',3,3);

create TABLE token(
  id int PRIMARY KEY AUTO_INCREMENT not null,
  token VARCHAR(200) not null
);



