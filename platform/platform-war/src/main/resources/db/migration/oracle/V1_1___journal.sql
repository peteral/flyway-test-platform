CREATE TABLE JOURNAL 
(
  ID NUMBER(20) NOT NULL 
, TS TIMESTAMP 
, MESSAGE VARCHAR2(1000) 
, CONSTRAINT JOURNAL_PK PRIMARY KEY 
  (
    ID 
  )
  ENABLE 
);

CREATE SEQUENCE JOURNAL_SEQUENCE INCREMENT BY 1 START WITH 1;
