CREATE TABLE MEMBERGROUP
(
	GROUPNUM number(20) primary key ,
	GROUPNAME varchar2(20) NOT NULL,
	save_FILENUM varchar2(20) NOT NULL,
	MEMBERNO varchar2(20) NOT NULL,
	LEADERNO varchar2(20)
);
CREATE TABLE MEMBERS
(
	MEMBERNO varchar2(20) primary key,
	ID varchar2(60) NOT NULL UNIQUE,
	PASSWORD varchar2(20) NOT NULL,
	ADDRESS varchar2(200),
	PHONENUM number(30),
	DIVISION number(20) NOT NULL,
	ACCOUNTANT blob,
	GROUPNUM number(20) references membergroup(groupnum),
	LEADERNO varchar2(20) references members(memberno)
);
CREATE TABLE FILES
(
	save_FILENUM varchar2(20) primary key,
	save_FILE blob,
	save_FILENAME varchar2(30) NOT NULL,
	MEMBERNO varchar2(20) REFERENCES MEMBERS (MEMBERNO),
	ISACCOUNTFILE varchar2(1)
);

CREATE TABLE BOARD
(
	BOARDNUM number(20) NOT NULL,
	save_FILENUM varchar2(20) references files(save_filenum),
	TITLE varchar2(40 char) NOT NULL,
	CONTENT varchar2(4000) NOT NULL,
	MEMBERNO varchar2(20 char) references members(memberno),
	PRIMARY KEY (BOARDNUM)
);

ALTER TABLE MEMBERGROUP add foreign key(leaderno) references members(memberno);

drop table board;