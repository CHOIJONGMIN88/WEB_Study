/*

---�Ϸù�ȣ ������ü
create sequence seq_photo_idx

--���̺� ����
drop table photo

create table photo 
(
	idx int, 		    	 ---�Ϸù�ȣ
	title    varchar2(100),  	 ---����
	filename varchar2(255),  ---���ϸ�
	pwd      varchar2(100),  ---���� �� ���� ��й�ȣ
	ip       varchar2(100),  ---IP
	regdate  date			 ---��¥
	
)


--�⺻Ű ����

alter table photo
 add constraint pk_photo_idx primary key(idx)
 
 select * from photo
 
 

*/