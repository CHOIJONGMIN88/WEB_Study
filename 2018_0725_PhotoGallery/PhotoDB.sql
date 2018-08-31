/*

---일련번호 관리객체
create sequence seq_photo_idx

--테이블 생성
drop table photo

create table photo 
(
	idx int, 		    	 ---일련번호
	title    varchar2(100),  	 ---제목
	filename varchar2(255),  ---파일명
	pwd      varchar2(100),  ---수정 및 삭제 비밀번호
	ip       varchar2(100),  ---IP
	regdate  date			 ---날짜
	
)


--기본키 지정

alter table photo
 add constraint pk_photo_idx primary key(idx)
 
 select * from photo
 
 

*/