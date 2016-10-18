CREATE TABLE BOARD /* 모든 게시판의 글을 담는 Table */
(
	BOARDNO varchar2(20) NOT NULL, /* 기본키, 게시판 글번호*/
	SAVE_FILENO varchar2(20), /*게시판에 올라간, 파일의 번호*/
	TITLE varchar2(40) NOT NULL, /*글 제목*/
	CONTENT varchar2(4000) NOT NULL, /*글 내용*/
	MEMBERNO varchar2(20), /*글쓴이, 외부키*/
	CONSTRAINT SYS_C0010350 PRIMARY KEY (BOARDNO)
);


CREATE TABLE FILES /*올라온 파일을 저장하는 Table*/
(
	SAVE_FILENO varchar2(20) NOT NULL, /*기본키, 파일 번호*/
	SAVE_FILE blob, /*파일 자체*/
	SAVE_FILENAME varchar2(30) NOT NULL, /*사용자가 보는, 파일의 이름*/
	MEMBERNO varchar2(20), /*글 올린사람, 외부키*/
	ISACCOUNTFILE varchar2(1), /* 저장된 파일이 가계부 파일인지, 통합문서 파일인지 확인. y: 가계부, n: 통합문서파일, f: 문서양식파일*/
	CONSTRAINT SYS_C0010345 PRIMARY KEY (SAVE_FILENO)
);


CREATE TABLE MEMBERGROUP /*그룹핑 Table*/
(
	GROUPNO varchar2(20) NOT NULL, /*기본키, 그룹번호*/
	GROUPNAME varchar2(20) NOT NULL, /*사용자가 지은, 그룹의 이름*/
	SAVE_FILENUM varchar2(20) NOT NULL, /*그룹에서 사용하는 파일의 번호*/
	LEADERNO varchar2(20), /*리더 번호*/
	CONSTRAINT SYS_C0010336 PRIMARY KEY (GROUPNO)
);



CREATE TABLE MEMBERS /*회원목록 Table*/
(
	MEMBERNO varchar2(20) NOT NULL, /*내부관리용 회원번호*/
	ID varchar2(60) NOT NULL UNIQUE, /*회원ID, 이메일로 받음*/
	PASSWORD varchar2(20) NOT NULL, /*회원 비밀번호*/
  NAME varchar2(30) NOT NULL,
	ADDRESS varchar2(200), /*회원주소*/
	PHONENUM number(30), /*회원전화번호*/
	DIVISION number(20) NOT NULL, /*회원의 종류. 0:관리자, 1:일반회원*/
	ACCOUNTANT blob, /*회원이 가지고 있는 가계부파일*/
	GROUPNO varchar2(20), /*회원이 소속된 그룹의 번호. 한 회원당 한 그룹만 가입 가능*/
	LEADERNO varchar2(20), /*MEMBERNO를 재귀참조. 어느 회원이 어떤 리더를 가지고 있는지 보여줌*/
	CONSTRAINT SYS_C0010340 PRIMARY KEY (MEMBERNO)
);
create sequence memberno_seq;
select * from members;

/* Create Foreign Keys */

ALTER TABLE BOARD /*BOARD Table의 SAVE_FILENUM은 FILES Table의 SAVE_FILENUM을 참조하는 외래키로 한다*/
	ADD CONSTRAINT SYS_C0010351 FOREIGN KEY (SAVE_FILENO)
	REFERENCES FILES (SAVE_FILENO)
;


ALTER TABLE MEMBERS /*MEMBERS Table의 GROUPNUM은 MEMBERGROUP Table의 GROUPNUM을 참조하는 외래키로 한다*/
	ADD CONSTRAINT SYS_C0010342 FOREIGN KEY (GROUPNO)
	REFERENCES MEMBERGROUP (GROUPNO)
;


ALTER TABLE BOARD
	ADD CONSTRAINT SYS_C0010352 FOREIGN KEY (MEMBERNO)
	REFERENCES MEMBERS (MEMBERNO)
;


ALTER TABLE FILES
	ADD CONSTRAINT SYS_C0010346 FOREIGN KEY (MEMBERNO)
	REFERENCES MEMBERS (MEMBERNO)
;


ALTER TABLE MEMBERGROUP
	ADD CONSTRAINT SYS_C0010353 FOREIGN KEY (LEADERNO)
	REFERENCES MEMBERS (MEMBERNO)
;


ALTER TABLE MEMBERS
	ADD CONSTRAINT SYS_C0010343 FOREIGN KEY (LEADERNO)
	REFERENCES MEMBERS (MEMBERNO)
;