# -------------------------------

CREATE TABLE ACCOUNT(
   ID INT PRIMARY KEY AUTO_INCREMENT,
   NAME VARCHAR(20),
   MONEY DOUBLE
);

SELECT * FROM maven_spring_data.account;

INSERT INTO maven_spring_data.account VALUES (NULL ,'jack','10000');
INSERT INTO maven_spring_data.account VALUES (NULL ,'rose','10000');
INSERT INTO maven_spring_data.account VALUES (NULL ,'tom','10000');