create table board (
	num int not null,
	id varchar(10) not null,
	name varchar(10) not null,
	subject varchar(100) not null,
	content long not null,
	regist_day varchar(30),
	hit int,
	ip varchar(20),
    constraint num_pk primary key (num)
);



create SEQUENCE num_seq start with 1;



create or replace trigger num_trigger
before insert on board
for each row

begin
  select num_seq.nextval, (SELECT DBMS_RANDOM.STRING('X', 10) FROM DUAL)
  into   :new.num, :new.id
  from   dual
end;
/

select * from BOARD;

