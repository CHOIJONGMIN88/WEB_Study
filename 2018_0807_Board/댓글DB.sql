

/*
 --일련번호
 
  create sequence seq_comment_idx
  
   ---댓글 테이블
   
   create table comment_tb
  (   
 	idx	 int,				--댓글 일련번호
 	id   varchar2(100),		--아이디
 	name varchar2(100),		--이름
 	content varchar2(2000),
 	ip   varchar2(100),		--ip
 	regdate date,			--등록일자
 	b_idx int				--기준 글번호
 
	)
	
	--참조키 설정
	alter table comment_tb
		add constraint pk_comment_b_idx 
					
					foreign key(b_idx)
					references board(idx)
					on delete cascade
	
	cf)on delete cascade:idx글이 삭제시 참조되는 댓글들을 같이 삭제						
	
	
	--댓글 갯수를 구하기 위해 조인함
	select * from comment_tb,(select count(*) c_count from comment_tb where b_idx=19) 
	
	
	
	--댓글의 페이징 처리를 위한 select문
	
	select * from comment_tb where b_idx=53
	
	select * from
	(
		select
			rank() over(order by idx desc)no,
			c.*
		from	
				
		(select * from comment_tb where b_idx = 53) c
	)
	where no between 6 and 10	
	
	
	---게시글별 댓글갯수
	select from comment_tb where b_idx=#{b_idx}
	
	select * from comment_tb
					
	
*/