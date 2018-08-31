/*
-----회원일련번호 관리객체

create sequence seq_member_idx

create table member(

	idx int, 						  --일련번호
	name 	varchar2(100) not null, 	  ---이름
	id 		varchar2(100) not null unique, ---아이디
	pwd 	varchar2(100) not null, 	  ---비밀번호
	zipcode varchar2(100),
	addr 	varchar2(255),
	ip   	varchar2(100),
	regdate date  						--가입일자
)

---idx 기본키 설정
alter table member
 add constraint pk_member_idx primary key(idx)
 
--sample data
insert into member values(seq_member_idx.nextVal,
										  '관리자',
										  'admin',
										  'admin1234',
										  '12345',
										  '서울 구로구 구로3동',
										  '127.0.0.1',
										  sysdate);


insert into member values(seq_member_idx.nextVal,
										  '홍길동',
										  'hong',
										  '1234',
										  '12345',
										  '서울 구로구 구로3동',
										  '127.0.0.1',
										  sysdate);
 
select * from member where id='hong'

commit

*/