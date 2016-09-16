CREATE TABLE Dentists
(
DentID CHAR(4) NOT NULL PRIMARY KEY,
FirstName VARCHAR(30) NOT NULL,
LastName VARCHAR(30) NOT NULL,
Email VARCHAR(30),
Office CHAR(4)
);

CREATE TABLE Patients
(
PatID char(4) NOT NULL PRIMARY KEY,
FirstName VARCHAR(30) NOT NULL,
LastName VARCHAR(30) NOT NULL,
Address VARCHAR(60),
Email VARCHAR(10),
InsCo VARCHAR(30)
);

CREATE TABLE Procedures
(
ProcCode char(4) NOT NULL PRIMARY KEY,
ProcName VARCHAR(30) NOT NULL,
ProcDesc VARCHAR(30),
Cost NUMERIC
);

CREATE TABLE Appointments
(
ApptDateTime DATETIME NOT NULL,
PatID char(4) NOT NULL,
DentID char(4) NOT NULL,
ProcCode char(4) NOT NULL,

CONSTRAINT pk_AppointmentID PRIMARY KEY (ApptDateTime, PatID),

constraint fk_patid foreign KEY (PatID) REFERENCES Patients(PatID),
CONSTRAINT fk_DentID FOREIGN KEY (DentID) REFERENCES Dentists(DentID),
CONSTRAINT fk_ProcCode FOREIGN KEY (ProcCode) REFERENCES Procedures(ProcCode)
);







CREATE TABLE Employees
(
empID CHAR(11) NOT NULL PRIMARY KEY,
firstName VARCHAR(30) NOT NULL,
lastName VARCHAR(30) NOT NULL,
address VARCHAR(30) NOT NULL,
deptCode CHAR(4) NOT NULL,
salary NUMERIC,
email VARCHAR(30)
);
insert into Employees values
('156', 'Tony'  , 'Jenkins' , 'Dallas'      , 'ACCT', null          , 'tj@pacbell.com'),
('207', 'Betty' , 'Jones'   , 'Nashville'   , 'MKTG', 31000.00, 'bjones@yahoo.com'),
('302', 'John'  , 'Carver'  , 'Miama'       , 'ACCT', 29000.00, 'jc@hotmail.com'),
('457', 'Susan' , 'Collins' , 'Houstons'    , 'IT'  , 29000.00, null);


CREATE TABLE Depts
(
DeptId CHAR(4) NOT NULL PRIMARY KEY,
DeptName VARCHAR(30) NOT NULL,
DeptLocation VARCHAR(30) NOT NULL
);
insert into Depts values
('ACCT' , 'Accounting'      , 'Dallas'      ),
('MKTG' , 'Marketing'       , 'Atlanta'     ),
('IT'   , 'Information Tech', 'Houston'     ),
('HR'   , 'Human Resources' , 'Charlotte'   );


CREATE TABLE Accounts
(
acctNo int(5) NOT NULL PRIMARY KEY,
owner VARCHAR(60) NOT NULL,
address VARCHAR(30) NOT NULL,
type CHAR(3) NOT NULL,
balance NUMERIC NOT NULL
);
insert into Accounts values
(44421,'David Smith' ,'Atlanta' ,'SAV', 225.00  ),
(77791,'David Smith' ,'Atlanta' ,'MMA', 4560.00 ),
(32145,'Karen Wilson','Duluth'  ,'CHK', 231.12  ),
(14566,'Karen Wilson','Duluth'  ,'MMA', 3125.00 ),
(78777,'Kyle Miles'  ,'Marietta','SAV', 2000.00 ),
(78900,'Kyle Miles'  ,'Marietta','CHK', 314.90  ),
(75412,'Ben Cole'    ,'Acworth' ,'CHK', 566.87  ),
(75413,'Ben Cole'    ,'Acworth' ,'SAV', 5000.00 ),
(75414,'Ben Cole'    ,'Acworth' ,'MMA', 2900.00 );