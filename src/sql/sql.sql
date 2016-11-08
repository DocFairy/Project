
drop table files cascade constraint;
drop table board cascade constraint;
drop table members cascade constraint;
drop table membergroup cascade constraint;

CREATE TABLE MEMBERGROUP /*그룹핑 Table*/
(
	GROUPNO varchar2(20) NOT NULL, /*기본키, 그룹번호*/
	GROUPNAME varchar2(20) NOT NULL, /*사용자가 지은, 그룹의 이름*/
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
	ACCOUNTANT varchar2(1000), /*회원이 가지고 있는 가계부파일*/
	GROUPNO varchar2(20) references membergroup, /*회원이 소속된 그룹의 번호. 한 회원당 한 그룹만 가입 가능*/
	invite varchar2(1000),
	CONSTRAINT SYS_C0010340 PRIMARY KEY (MEMBERNO)
);

CREATE TABLE FILES /*올라온 파일을 저장하는 Table*/
(
	SAVE_FILENO varchar2(20), /*기본키, 파일 번호*/
	SAVE_FILE varchar2(1000), /*파일 자체*/
	SAVE_FILENAME varchar2(1000) NOT NULL, /*사용자가 보는, 파일의 이름*/
	MEMBERNO varchar2(20)references members, /*글 올린사람, 외부키*/
	filetype varchar2(20), /* 저장된 파일이 가계부 파일인지, 통합문서 파일인지 확인. y: 가계부, n: 통합문서파일, f: 문서양식파일*/
	groupno varchar2(20) references membergroup,
	CONSTRAINT SYS_C0010345 PRIMARY KEY (SAVE_FILENO)
);


alter table membergroup modify (groupname varchar(100));
create sequence files_seq;
create sequence memberno_seq;
create sequence membergroup_seq;
create sequence board_seq;

/* Create Foreign Keys */

