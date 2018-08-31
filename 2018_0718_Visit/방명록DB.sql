/*

----일련번호 관리객체

create sequence seq_visit_idx

---방명록 테이블 생성 
drop table visit --테이블삭제
create table visit
(
	idx int,			            --일련번호 
	name varchar2(100) not null,    --이름
	content varchar2(2000) not null,--내용
	pwd varchar2(100) not null,
	ip varchar2(100) not null,		--작성자IP
	regdate date					--작성일자
)

--기본키 설정
alter table visit
	add constraint pk_visit_idx primary key(idx)
	
---sample data
insert into visit values(seq_visit_idx.nextVal,
						'scp재단',
						'미스터리현상 조사기관',
						'1234',
						'127.0.0.1',
						sysdate)
						
						insert into visit values(seq_visit_idx.nextVal,
						'scp재단본부',
						'유클리드급사건',
						'1234',
						'127.0.0.1',
						sysdate)
						
select * from visit

commit

delete from visit 




*/