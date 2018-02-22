DROP TABLE user;

CREATE TABLE user (
  id int PRIMARY KEY auto_increment not null,
  username VARCHAR(30) UNIQUE ,
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

create table company(
  id int PRIMARY KEY AUTO_INCREMENT not null,
  company VARCHAR(100) not null,
  address VARCHAR(200) not null,
  description varchar(100)
);

insert into company(company, address, description) VALUES ('Ecorp','Calle mala 1','Compania');
insert into company(company, address, description) VALUES ('Ecorp 2','Calle lomas turbas 1','Compania');
insert into company(company, address, description) VALUES ('Ecorp 3','Calle sacarias blanco 1','Compania');
insert into company(company, address, description) VALUES ('Ecorp 4','Calle tejeringo el chico 1','Compania');

create table teacher(
  id int PRIMARY KEY AUTO_INCREMENT not null,
  name VARCHAR(100) not null
);

insert into teacher(name) VALUES ('randall');
insert into teacher(name) VALUES ('ergigi');
insert into teacher(name) VALUES ('celso pina');
insert into teacher(name) VALUES ('luis laredo');
insert into teacher(name) VALUES ('juam pecados');

create table course(
  id int PRIMARY KEY AUTO_INCREMENT not null,
  course VARCHAR(100) not null,
  description VARCHAR(100) not null,
  hours int not null
);

INSERT INTO course(course, description, hours) VALUES ('inglish','nose',20);
INSERT INTO course(course, description, hours) VALUES ('lenguajes de interfaz','nose',20);
INSERT INTO course(course, description, hours) VALUES ('sistemas programables','nose',20);
INSERT INTO course(course, description, hours) VALUES ('topicos de bd','nose',20);
INSERT INTO course(course, description, hours) VALUES ('moviles','nose',20);

create table courseTeacher(
  idCourse int REFERENCES course(id),
  idTeacher int REFERENCES teacher(id),
  startDate date not null,
  endDate date not null,
  PRIMARY KEY (idCourse,idTeacher)
);

INSERT into courseTeacher(idCourse, idTeacher, startDate, endDate) VALUES (1,1,'2018-02-10','2018-03-11');
INSERT into courseTeacher(idCourse, idTeacher, startDate, endDate) VALUES (2,2,'2018-02-10','2018-03-11');
INSERT into courseTeacher(idCourse, idTeacher, startDate, endDate) VALUES (3,3,'2018-02-10','2018-03-11');
INSERT into courseTeacher(idCourse, idTeacher, startDate, endDate) VALUES (4,4,'2018-02-10','2018-03-11');
INSERT into courseTeacher(idCourse, idTeacher, startDate, endDate) VALUES (5,5,'2018-02-10','2018-03-11');

create table history(
  idCourse int REFERENCES course(id),
  idEmpleado int REFERENCES employee(id),
  grade int not null,
  PRIMARY KEY (idCourse, idEmpleado)
);

INSERT into history(idCourse, idEmpleado, grade) VALUES (1,1,100);



