/*

----�Ϸù�ȣ ������ü

create sequence seq_visit_idx

---���� ���̺� ���� 
drop table visit --���̺����
create table visit
(
	idx int,			            --�Ϸù�ȣ 
	name varchar2(100) not null,    --�̸�
	content varchar2(2000) not null,--����
	pwd varchar2(100) not null,
	ip varchar2(100) not null,		--�ۼ���IP
	regdate date					--�ۼ�����
)

--�⺻Ű ����
alter table visit
	add constraint pk_visit_idx primary key(idx)
	
---sample data
insert into visit values(seq_visit_idx.nextVal,
						'scp���',
						'�̽��͸����� ������',
						'1234',
						'127.0.0.1',
						sysdate)
						
						insert into visit values(seq_visit_idx.nextVal,
						'scp��ܺ���',
						'��Ŭ����޻��',
						'1234',
						'127.0.0.1',
						sysdate)
						
select * from visit

commit

delete from visit 




*/