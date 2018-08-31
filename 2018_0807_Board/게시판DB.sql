

/*
--일련번호관리객체
create sequence seq_board_idx;



---게시판 테이블

select * from board
create table board 
(
		idx int,				--일련번호 
		id varchar2(100),		--작성자 id
		name varchar2(100),		--글쓴이
		subject varchar2(100),	--제목
		content clob,			--내용
		pwd varchar2(100),		--비밀번호
		ip  varchar2(100),      --ip
		regdate date,			--작성일자
		readhit int, 			--조회수 
		---답변형게시판관리 속성
		ref int, 				--주인글번호
		step int,				--수직적순서
		depth int 				--수평적순서 				
)

--기본키 지정 
alter table board 
	add constraint pk_board_idx primary key(idx)
	
--외래키 지정
alter table board
	add constraint fk_board_id foreign key(id)
								references member(id)
								
--sample data 

insert into board values(seq_board_idx.nextVal,
										'hong',
										'홍길동',
										'내가2등이닷',
										'2등이당당',
										'1234',
										'127.0.0.1',
										sysdate,
										0,
										seq_board_idx.currVal,
										0,
										0	
										)
										
										
										insert into board values(seq_board_idx.nextVal,
										'hong',
										'홍길동',
										'제발 가져와라 목록을',
										'새로넣은값이다',
										'1234',
										'127.0.0.1',
										sysdate,
										0,
										seq_board_idx.currVal,
										0,
										0	
										)
										
		
										
																										
---답글쓰기 			

insert into board values(seq_board_idx.nextVal,
										'admin',
										'관리자',
										'1등이닷',
										'1등이당당',
										'1234',
										'127.0.0.1',
										sysdate,
										0,
										1,
										1,
										1	
										)	

insert into board values(seq_board_idx.nextVal,
										'admin',
										'관리자',
										'1등이닷',
										'1등이당당',
										'1234',
										'127.0.0.1',
										sysdate,
										0,
										1,
										2,
										2	
										)											


update board set readhit=0


select count(*) from board

--페이징 처리를 위한 SQL문

--인라인 뷰로 생성한다.

--실행순서 from-> where절->select 순으로 처리되기떄문에 no가 생성되지 않은 상태에서 실행된다. 
--그래서 해결하기위에 view를 생성후에 실행한다.

---b_idx는 테이블의 idx ,b.idx는 인라인 뷰의 idx이다.
select*
	from(
		select 
			rank() over(order by ref desc,step asc) no,
			b.*	,
			(select count(*) from comment_tb where b_idx=b.idx) c_count
			
		from
			(select * from board) b
		)



where no between 1 and 5 
--1번에서 5번까지
where no between 6 and 10
--6번에서 10번까지 

--rank() over(order by ref desc,step asc) no,
--해석:  ref를 내림차순으로 step를 오름차순으로 만든 테이블에 대해 순위를 매긴다.


--게시글 삭제시 사용유무에 대한 flag부여(use_yn) 사용가능할경우y 불가능할 경우 n을 삽입함
---->기존 게시글에 새로운 필드를 추가한다.(이런짓은 권장하지 않는다. 첫 데베 설계시 완벽하게 설계해야한다.)

alter table board
	add use_yn char(1) check(use_yn in('y','n'))
	
	
select * from board 
	
	----모든 use_yn 값을 y로 수정한다.
	update board set use_yn='y' 
	
			
	
페이징 처리를 위한 sql	
	
	


commit
																																																								
																				
					select count(*)
	from(
		select 
			rank() over(order by ref desc,step asc) no,
			b.*	,
			(select count(*) from comment_tb where b_idx=b.idx) c_count
			
		
		select count(*)
		from
			(
			  select * from board
			  
    		where name like '%' || '홍' || '%'

    		    or content like '%' || '홍' || '%'
    
    		    or subject like '%' || '홍'|| '%'
    		
    		order by idx desc	
			  
			)b

			where no between 1 and 5		
								
								




*/