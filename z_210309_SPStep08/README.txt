Spring Oracle DB연동 (SPRING - JDBC 방식)

context, properties 없이 Oracle DB연동

 Table Query
	create table members(
	id number,
	name varchar2(20) ,
	email varchar2(20) ,
	password varchar2(20),
	REGDATE date,	날짜 자동생성
	CONSTRAINT members_PK primary key(id)	id를 기본키로 지정, PK제약조건
	);
	
	select * from members;
	
	create sequence MEMBERS_SEQ
	start with 1000
	INCREMENT BY 1
	MAXVALUE 9999
	NOCYCLE;
	
	select count (*) from members;