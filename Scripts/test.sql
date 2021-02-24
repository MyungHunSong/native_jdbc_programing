select user(), database();

show tables;

desc title;
desc department;
desc employee;

select tno,tname from title;
select deptNo,deptName,floor from department;
select empno,empname,title,manager,salary,dept from employee;

select tno, tname
	from title
	where tno = 3;

insert into title values(6, '인턴');


delete from title where tno =6;
select * from title;

update title set tname = '계약직' where tno = 6;

select * from employee;



select  deptNo,deptName,floor from department;

select  deptNo,deptName,floor from department where deptNo = 3;

insert into department values (5, '호오', 6);

delete from department where deptNo = 5;

SELECT e.*, t.*, m.EMP_NO , m.EMP_NAME, d.*
FROM EMPLOYEE e JOIN TITLE t ON e.TNO = t.TITLE_NO
LEFT JOIN EMPLOYEE m ON e.MANAGER = m.EMP_NO
JOIN DEPARTMENT d ON e.DNO = d.DEPT_NO ;
CREATE OR REPLACE VIEW VW_EMPLOYEE

(EMP_NO, EMP_NAME, TNO, TITLE_NAME, MANAGER, MGR_NAME, SALARY, DNO, DEPT_NAME, FLOOR)
AS
SELECT e.EMP_NO, e.EMP_NAME, e.TNO, t.TITLE_NAME, m.EMP_NO, m.EMP_NAME, e.SALARY,
d.DEPT_NO, d.DEPT_NAME, d.FLOOR
FROM EMPLOYEE e JOIN TITLE t ON e.TNO = t.TITLE_NO
LEFT JOIN EMPLOYEE m ON e.MANAGER = m.EMP_NO
JOIN DEPARTMENT d ON e.DNO = d.DEPT_NO ;

SELECT EMP_NO, EMP_NAME, MANAGER, SALARY, MGR_NAME, TNO, TITLE_NAME, DNO, DEPT_NAME, FLOOR
FROM VW_EMPLOYEE;

SELECT EMP_NO, EMP_NAME, MANAGER, SALARY, MGR_NAME, TNO, TITLE_NAME, DNO, DEPT_NAME, FLOOR
FROM VW_EMPLOYEE
WHERE EMP_NO = 1003;

select * from employee;

select empno,empname,title,manager,salary,dept from employee;

update employee set empname=?, empname=?, title=?, mamager=?,salary=?,dept=? where empno=?;

insert into employee values(1001, '가자이', 2, 4377, 5000000, 2);
select * from employee;
delete from employee where empno= 1001;


--  키요오오오옷 
create or replace view vw_full_employee
as
select e.empno,
	   e.empname, 
	   t.tno as title_no,
	   t.tname as title_name,
	   e.manager as manager_no,
	   m.empname as manager_name,
	   e.salary,
	   d.deptNo, 
	   d.deptName,
	   floor
	from employee e join title t on e.title = t.tno
		 left join employee m on e.manager  = m.empno 
		join department d on e.dept  = d.deptNo;
	
select empno,
	   empname, 
	   title_no,
	   title_name,
	   manager_no,
	   manager_name,
	   salary,
	   deptNo, 
	   deptName,
	   floor
	   from vw_full_employee;
	   
select empno,empname,title_no,title_name,manager_no,manager_name,salary,deptNo,deptName,floor from vw_full_employee;


select empno, empname, title as title_no, manager as manager_no, salary, dept as deptNo from employee where empno=1003;
-- 
insert into employee values(1004, '찬시쉨', 5, 4377 , 2000000, 1);
-- 
update employee 
	set dept = 3
	where empno = 1004;
-- 
delete from employee where empno = 1004;

select * from employee; 



select e.empno, 
	   e.empname,
	   e.title,
	   ifnull conca 
	from employee e
	left join employee m on e.manger = m.empno
	join department d on e.dept = d.deptNo;


-- title
select tno, tname from title;
select deptNo, deptName, floor from department;

delete from department where deptNo = 5;
delete from title where tno = 6;


-- 부서가 1인 사원정보 출력
select empno, empname, title, manager, salary, dept
	from employee
	where dept = (select deptNo from department where deptNo = 3);


