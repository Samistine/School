CREATE TABLE Patients
(
uid int NOT NULL PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(30) NOT NULL,
last_name VARCHAR(30) NOT NULL,
phone_no CHAR(10) NOT NULL,
address VARCHAR(60),
ssn CHAR(9) not null
);

CREATE TABLE Dentists
(
uid int NOT NULL PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(30) NOT NULL,
last_name VARCHAR(30) NOT NULL,
phone_no CHAR(10) NOT NULL,
address VARCHAR(60),
ssn CHAR(9) NOT NULL
);


CREATE TABLE Appointments
(
uid int NOT NULL PRIMARY KEY AUTO_INCREMENT,
dentist int NOT NULL,
patient int NOT NULL,
time TIMESTAMP NOT NULL,
info TEXT,

CONSTRAINT fk_dentist FOREIGN KEY (uid) REFERENCES Dentists(uid),
CONSTRAINT fk_patient FOREIGN KEY (uid) REFERENCES Dentists(uid)
);


CREATE TABLE Visits
(
uid int NOT NULL PRIMARY KEY AUTO_INCREMENT,
appointment int,
arrival_time TIMESTAMP NOT NULL,
finished_time TIMESTAMP NOT NULL,
info TEXT,

CONSTRAINT fk_patient FOREIGN KEY (appointment) REFERENCES Appointments(uid)
);