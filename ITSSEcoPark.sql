DROP TABLE IF EXISTS GeneralBike CASCADE;
DROP TABLE IF EXISTS EBike CASCADE;
DROP TABLE IF EXISTS RentBikeHistory CASCADE;
DROP TABLE IF EXISTS EcoUser CASCADE;
DROP TABLE IF EXISTS Asset CASCADE;
DROP TABLE IF EXISTS BikeDock CASCADE;
DROP TABLE IF EXISTS Account CASCADE;

CREATE TABLE GeneralBike(
 licensePlate varchar(10) primary key,
 name varchar(30),
 weight float,
 manufacturedDate date,
 type varchar(10),
 dockId varchar(10)
);

CREATE TABLE EBike(
 licensePlate varchar(10),
 batteryPercent float,
 loadCycle int,
 estimatedTimeLeft time
);

CREATE TABLE RentBikeHistory(
 historyId serial primary key,
 licensePlate varchar(10),
 userId int,
 status int,
 startTime timestamp
);

CREATE TABLE EcoUser(
 userId serial primary key,
 username varchar(20),
 password varchar(100),
 role int
);

CREATE TABLE Asset(
 type varchar(10) primary key,
 cost int,
 deposit int,
 image varchar(100)
);

CREATE TABLE BikeDock(
 dockId varchar(10) primary key,
 dockName varchar(30),
 description varchar(200),
 distance float
);

CREATE TABLE Account(
 cardId varchar(10) primary key,
 balance int
);

ALTER TABLE GeneralBike ADD CONSTRAINT fk1
FOREIGN KEY (type) REFERENCES Asset(type) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE GeneralBike ADD CONSTRAINT fk2
FOREIGN KEY (dockId) REFERENCES BikeDock(dockId) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE RentBikeHistory ADD CONSTRAINT fk3
FOREIGN KEY (userId) REFERENCES EcoUser(userId) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE RentBikeHistory ADD CONSTRAINT fk4
FOREIGN KEY (licensePlate) REFERENCES GeneralBike(licensePlate) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE EBike ADD CONSTRAINT fk5
FOREIGN KEY (licensePlate) REFERENCES GeneralBike(licensePlate) ON UPDATE CASCADE ON DELETE CASCADE;

INSERT INTO Asset VALUES('Bike',10000,400000,'fxml_view/image/generalBike/Bike.png');
INSERT INTO Asset VALUES('TwinBike',15000,550000,'fxml_view/image/generalBike/TwinBike.jpg');
INSERT INTO Asset VALUES('EBike',15000,700000,'fxml_view/image/generalBike/EBike.jpg');

INSERT INTO BikeDock VALUES('TDD','Truong Dinh Dock','',12.5);
INSERT INTO BikeDock VALUES('MDD','My Dinh Dock','',2.5);
INSERT INTO BikeDock VALUES('HKD','Hoan Kiem Dock','',1.5);

INSERT INTO EcoUser(username,password,role) VALUES ('tuanvu','123456',0);
INSERT INTO EcoUser(username,password,role) VALUES ('ngoc','123456',0);
INSERT INTO EcoUser(username,password,role) VALUES ('hoang','123456',0);
INSERT INTO EcoUser(username,password,role) VALUES ('dinhtuan','123456',1);

INSERT INTO GeneralBike VALUES('AB123','Asama1',8.5,'2020-5-5','Bike','TDD');
INSERT INTO GeneralBike VALUES('AC123','Asama2',8.0,'2020-5-5','TwinBike','MDD');
INSERT INTO GeneralBike VALUES('AE123','Asama3',8.2,'2020-5-5','EBike','TDD');
INSERT INTO EBike VALUES('AE123',65.5,3,'4:56:10');

INSERT INTO GeneralBike VALUES('DE123','Asama4',8.5,'2020-5-5','Bike','MDD');
INSERT INTO GeneralBike VALUES('OP123','Asama5',8.0,'2020-5-5','TwinBike','TDD');
INSERT INTO GeneralBike VALUES('ED128','Asama6',8.2,'2020-5-5','EBike','MDD');
INSERT INTO EBike VALUES('AE123',86.5,5,'10:56:26');

INSERT INTO RentBikeHistory(licensePlate,userId,status,startTime) VALUES('AC123',2,1,now());
INSERT INTO RentBikeHistory(licensePlate,userId,status,startTime) VALUES('AB123',2,0,'2021-12-31 15:00:05');
INSERT INTO RentBikeHistory(licensePlate,userId,status,startTime) VALUES('AC123',2,0,'2021-12-31 15:38:05');
INSERT INTO RentBikeHistory(licensePlate,userId,status,startTime) VALUES('AE123',2,0,'2021-12-31 15:46:05');

INSERT INTO Account VALUES('123456',1500000);
INSERT INTO Account VALUES('123457',1500000);
INSERT INTO Account VALUES('123458',1500000);
INSERT INTO Account VALUES('123459',1500000);

select * from RentBikeHistory;