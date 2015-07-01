CREATE TABLE Person (
   id INTEGER NOT NULL PRIMARY KEY
  ,fullName VARCHAR(20) NOT NULL
  ,birth DATE
  ,category CHAR(12)
  ,CHECK (category IN ('friend', 'customer', 'colleague'))
);

CREATE TABLE Address (
   person INTEGER NOT NULL PRIMARY KEY REFERENCES Person
     ON DELETE CASCADE
     ON UPDATE CASCADE

  ,street VARCHAR(255) NOT NULL
  ,number VARCHAR(255) NOT NULL
  ,town VARCHAR(255) NOT NULL
  ,zip CHAR(7) NOT NULL
);