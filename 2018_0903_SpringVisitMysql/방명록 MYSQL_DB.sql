/*



--방명록 테이블생성
drop table visit  --테입블 삭제

create table visit
(
	idx int auto_increment,						
	name varchar(100) not null,	
	content varchar(2000) not null,
	pwd  varchar(100) not null,	
	ip  varchar(100) not null,		
	regdate datetime,		
	constraint pk_visit_idx primary key(idx)
	)



  
--sample data
insert into visit(name,content,pwd,ip,regdate) values( 
                          '일길동',
                          '내가 1등이닷~~~',
                          '1234',
                          '127.0.0.1',
                           now()
                        );  

insert into visit(name,content,pwd,ip,regdate) values(  
                          '이길동',
                          '아쉽네 내가 1등할수 있었는데...',
                          '1234',
                          '127.0.0.1',
                           now()
                        );
                                                
                        

select * from visit 

delete from visit


---Mysql에서 페이징 처리 하는 방법

select @rank := @rank+1,v.*
from visit,(@rank :=0)r

---- limit 시작위치, 갯수 
select * from visit
order by idx desc
limit 0,2


<insert id="board_insert" parameterType="vo.BoardVo">
	
insert into board(id,name,subject,content,pwd,ip,regdate,readhit,ref,step,depth,use_yn) values(
			#{id},
			#{name},
			#{subject},
			#{content},
			#{pwd},
			#{ip},
			sysdate,
			0,
			0,
			0,
			0,
			'y'
					)
	
	</insert>
	//mySQL에서는 자동 시퀀스가 없기떄문에 최근 입력된 값을 이용하여 구한다.
	select max(idx) from board
	--현재 구해진 idx번호를 ref에 넣어준다
	update board set ref=#{idx} where idx=#{idx}


commit                                              
  
  








*/