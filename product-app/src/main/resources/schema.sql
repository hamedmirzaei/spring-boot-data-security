CREATE TABLE USER (
  USER_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
  USERNAME varchar(250) NOT NULL UNIQUE ,
  PASSWORD varchar(250) NOT NULL
);

CREATE TABLE AUTH_USER_GROUP (
  AUTH_USER_GROUP_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
  USERNAME varchar(250),
  AUTH_GROUP varchar(250),
  CONSTRAINT USER_AUTH_USER_GROUP_FK FOREIGN KEY (USERNAME) REFERENCES USER(USERNAME),
  UNIQUE (USERNAME, AUTH_GROUP)
);