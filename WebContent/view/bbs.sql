﻿1) 2개의 시퀀스 생성
    
    create sequence bbs_seq
    increment by 1
    start with 1;

    create sequence comment_seq
    increment by 1
    start with 1;
	
2) 2개의 테이블 생성

    CREATE TABLE bbs(
	b_idx 	NUMBER(6,0) CONSTRAINT bbs_pk PRIMARY KEY,
	subject VARCHAR2(50),
	writer	 VARCHAR2(20),
	content CLOB,
	file_name VARCHAR2(50),
	pwd	  VARCHAR2(20),
	write_date DATE,
	hit	   NUMBER(4)
     );

    CREATE TABLE comm(
	c_idx 	NUMBER(6,0) CONSTRAINT comm_pk PRIMARY KEY,
	writer	 VARCHAR2(20),
	content  CLOB,
	pwd	  VARCHAR2(20),
	write_date DATE,
	b_idx	   NUMBER(6,0),
	CONSTRAINT comm_fk FOREIGN KEY (b_idx) REFERENCES bbs(b_idx)
     );

     