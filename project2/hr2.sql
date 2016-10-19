CREATE TABLE BOARD /* ��� �Խ����� ���� ��� Table */
(
	BOARDNO varchar2(20) NOT NULL, /* �⺻Ű, �Խ��� �۹�ȣ*/
	SAVE_FILENO varchar2(20), /*�Խ��ǿ� �ö�, ������ ��ȣ*/
	TITLE varchar2(40) NOT NULL, /*�� ����*/
	CONTENT varchar2(4000) NOT NULL, /*�� ����*/
	MEMBERNO varchar2(20), /*�۾���, �ܺ�Ű*/
	CONSTRAINT SYS_C0010350 PRIMARY KEY (BOARDNO)
);


CREATE TABLE FILES /*�ö�� ������ �����ϴ� Table*/
(
	SAVE_FILENO varchar2(20) NOT NULL, /*�⺻Ű, ���� ��ȣ*/
	SAVE_FILE blob, /*���� ��ü*/
	SAVE_FILENAME varchar2(30) NOT NULL, /*����ڰ� ����, ������ �̸�*/
	MEMBERNO varchar2(20), /*�� �ø����, �ܺ�Ű*/
	ISACCOUNTFILE varchar2(1), /* ����� ������ ����� ��������, ���չ��� �������� Ȯ��. y: �����, n: ���չ�������, f: �����������*/
	CONSTRAINT SYS_C0010345 PRIMARY KEY (SAVE_FILENO)
);


CREATE TABLE MEMBERGROUP /*�׷��� Table*/
(
	GROUPNO varchar2(20) NOT NULL, /*�⺻Ű, �׷��ȣ*/
	GROUPNAME varchar2(20) NOT NULL, /*����ڰ� ����, �׷��� �̸�*/
	SAVE_FILENUM varchar2(20) NOT NULL, /*�׷쿡�� ����ϴ� ������ ��ȣ*/
	LEADERNO varchar2(20), /*���� ��ȣ*/
	CONSTRAINT SYS_C0010336 PRIMARY KEY (GROUPNO)
);



CREATE TABLE MEMBERS /*ȸ����� Table*/
(
	MEMBERNO varchar2(20) NOT NULL, /*���ΰ����� ȸ����ȣ*/
	ID varchar2(60) NOT NULL UNIQUE, /*ȸ��ID, �̸��Ϸ� ����*/
	PASSWORD varchar2(20) NOT NULL, /*ȸ�� ��й�ȣ*/
  NAME varchar2(30) NOT NULL,
	ADDRESS varchar2(200), /*ȸ���ּ�*/
	PHONENUM number(30), /*ȸ����ȭ��ȣ*/
	DIVISION number(20) NOT NULL, /*ȸ���� ����. 0:������, 1:�Ϲ�ȸ��*/
	ACCOUNTANT blob, /*ȸ���� ������ �ִ� ���������*/
	GROUPNO varchar2(20), /*ȸ���� �Ҽӵ� �׷��� ��ȣ. �� ȸ���� �� �׷츸 ���� ����*/
	LEADERNO varchar2(20), /*MEMBERNO�� �������. ��� ȸ���� � ������ ������ �ִ��� ������*/
	CONSTRAINT SYS_C0010340 PRIMARY KEY (MEMBERNO)
);
create sequence memberno_seq;
select * from members;

/* Create Foreign Keys */

ALTER TABLE BOARD /*BOARD Table�� SAVE_FILENUM�� FILES Table�� SAVE_FILENUM�� �����ϴ� �ܷ�Ű�� �Ѵ�*/
	ADD CONSTRAINT SYS_C0010351 FOREIGN KEY (SAVE_FILENO)
	REFERENCES FILES (SAVE_FILENO)
;


ALTER TABLE MEMBERS /*MEMBERS Table�� GROUPNUM�� MEMBERGROUP Table�� GROUPNUM�� �����ϴ� �ܷ�Ű�� �Ѵ�*/
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