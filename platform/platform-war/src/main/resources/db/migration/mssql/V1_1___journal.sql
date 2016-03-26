create sequence JOURNAL_SEQUENCE
	start with 1
	increment by 1;
GO

CREATE TABLE Journal
	(
	id int NOT NULL,
	ts timestamp NOT NULL,
	message varchar(50) NULL
	)
GO

ALTER TABLE Journal ADD CONSTRAINT
	PK_Journal PRIMARY KEY CLUSTERED 
	(
	id
	) WITH( STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) 

GO

ALTER TABLE Journal SET (LOCK_ESCALATION = TABLE)
GO
