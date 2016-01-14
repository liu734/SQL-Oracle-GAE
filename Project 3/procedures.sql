set severoutput on size 32000

create or replace pro_department_report as

num_students number;
dept varchar(20);

CURSOR dept_cur is SELECT dept_cur from DEPARTMENT;
CURSOR stu_cur(did IN integer ) is SELECT sname from STUDNET WHERE deptid=did;

dept_rec dept_rec%rowtype;
stu_rec stu_cur%rowtype;

begin 
	for dept_rec in dept_cur loop
		num_students :=0;
		for age_rec in stu_cur (dept_rec.deptid) loop
			num_students:=num_students+1;
		end loop;
		dbms_output.put_line();
		dbms_output.put_line(stu_name);
	end loop;
	

/
begin
	pro_department_report;

end;
/