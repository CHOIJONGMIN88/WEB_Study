

/*
 --�Ϸù�ȣ
 
  create sequence seq_comment_idx
  
   ---��� ���̺�
   
   create table comment_tb
  (   
 	idx	 int,				--��� �Ϸù�ȣ
 	id   varchar2(100),		--���̵�
 	name varchar2(100),		--�̸�
 	content varchar2(2000),
 	ip   varchar2(100),		--ip
 	regdate date,			--�������
 	b_idx int				--���� �۹�ȣ
 
	)
	
	--����Ű ����
	alter table comment_tb
		add constraint pk_comment_b_idx 
					
					foreign key(b_idx)
					references board(idx)
					on delete cascade
	
	cf)on delete cascade:idx���� ������ �����Ǵ� ��۵��� ���� ����						
	
	
	--��� ������ ���ϱ� ���� ������
	select * from comment_tb,(select count(*) c_count from comment_tb where b_idx=19) 
	
	
	
	--����� ����¡ ó���� ���� select��
	
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
	
	
	---�Խñۺ� ��۰���
	select from comment_tb where b_idx=#{b_idx}
	
	select * from comment_tb
					
	
*/