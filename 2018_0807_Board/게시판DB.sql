

/*
--�Ϸù�ȣ������ü
create sequence seq_board_idx;



---�Խ��� ���̺�

select * from board
create table board 
(
		idx int,				--�Ϸù�ȣ 
		id varchar2(100),		--�ۼ��� id
		name varchar2(100),		--�۾���
		subject varchar2(100),	--����
		content clob,			--����
		pwd varchar2(100),		--��й�ȣ
		ip  varchar2(100),      --ip
		regdate date,			--�ۼ�����
		readhit int, 			--��ȸ�� 
		---�亯���Խ��ǰ��� �Ӽ�
		ref int, 				--���α۹�ȣ
		step int,				--����������
		depth int 				--���������� 				
)

--�⺻Ű ���� 
alter table board 
	add constraint pk_board_idx primary key(idx)
	
--�ܷ�Ű ����
alter table board
	add constraint fk_board_id foreign key(id)
								references member(id)
								
--sample data 

insert into board values(seq_board_idx.nextVal,
										'hong',
										'ȫ�浿',
										'����2���̴�',
										'2���̴��',
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
										'ȫ�浿',
										'���� �����Ͷ� �����',
										'���γ������̴�',
										'1234',
										'127.0.0.1',
										sysdate,
										0,
										seq_board_idx.currVal,
										0,
										0	
										)
										
		
										
																										
---��۾��� 			

insert into board values(seq_board_idx.nextVal,
										'admin',
										'������',
										'1���̴�',
										'1���̴��',
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
										'������',
										'1���̴�',
										'1���̴��',
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

--����¡ ó���� ���� SQL��

--�ζ��� ��� �����Ѵ�.

--������� from-> where��->select ������ ó���Ǳ⋚���� no�� �������� ���� ���¿��� ����ȴ�. 
--�׷��� �ذ��ϱ����� view�� �����Ŀ� �����Ѵ�.

---b_idx�� ���̺��� idx ,b.idx�� �ζ��� ���� idx�̴�.
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
--1������ 5������
where no between 6 and 10
--6������ 10������ 

--rank() over(order by ref desc,step asc) no,
--�ؼ�:  ref�� ������������ step�� ������������ ���� ���̺� ���� ������ �ű��.


--�Խñ� ������ ��������� ���� flag�ο�(use_yn) ��밡���Ұ��y �Ұ����� ��� n�� ������
---->���� �Խñۿ� ���ο� �ʵ带 �߰��Ѵ�.(�̷����� �������� �ʴ´�. ù ���� ����� �Ϻ��ϰ� �����ؾ��Ѵ�.)

alter table board
	add use_yn char(1) check(use_yn in('y','n'))
	
	
select * from board 
	
	----��� use_yn ���� y�� �����Ѵ�.
	update board set use_yn='y' 
	
			
	
����¡ ó���� ���� sql	
	
	


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
			  
    		where name like '%' || 'ȫ' || '%'

    		    or content like '%' || 'ȫ' || '%'
    
    		    or subject like '%' || 'ȫ'|| '%'
    		
    		order by idx desc	
			  
			)b

			where no between 1 and 5		
								
								




*/