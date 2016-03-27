drop user test cascade;

CREATE USER test IDENTIFIED BY test 
DEFAULT TABLESPACE "USERS"
TEMPORARY TABLESPACE "TEMP";
GRANT "CONNECT" TO test ;
grant dba to test;

