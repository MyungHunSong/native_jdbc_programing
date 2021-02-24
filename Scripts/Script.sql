
select user(), database();


select * from Student;

create table Student(
	stdNo int(11) not null primary key,
	stdname varchar(20),
	kor int(8),
	eng int(8),
	math int(8)
);

drop table Student;

insert into Student values
	(1, '머하노', 10, 20, 10),
	(2, '집에가자', 40, 30, 50),
	(3, '못감', 20, 25, 30),
	(4, '븅신', 60, 70, 80);

delete 
