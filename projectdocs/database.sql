create sequence studentrollno;
create table student(rollno number primary key,studentname varchar2(20),gender varchar2(6),course varchar2(10), dob varchar2(10), fathername varchar2(20),address varchar2(30),city varchar2(30), state varchar2(20), pincode number, contactno number, emailid varchar2(40), isadmited varchar2(3), isdeleted varchar2(3));
insert into student(rollno,studentname,gender,course,dob,fathername,address,city,state,pincode,contactno,emailid)values(studentrollno.nextval,'Mansi','Female','Btech','23/07/1997','Harish','24 Nai Basti','Sitapur','Uttar Pradesh',261001,7275474859,'mansirastogi1997@gmail.com');
insert into student(rollno,studentname,gender,course,dob,fathername,address,city,state,pincode,contactno,emailid)values(studentrollno.nextval,'Sanjeev','Male','Btech','03/07/1997','harshit',' hargoan Basti','Sitapur','Uttar Pradesh',261001,727777859,'sanjeev34jii@gmail.com');
insert into student(rollno,studentname,gender,course,dob,fathername,address,city,state,pincode,contactno,emailid,isadmited)values(studentrollno.nextval,'Mansi','Female','Btech','23/07/1997','Harish','24 Nai Basti','Sitapur','Uttar Pradesh',261001,7275474859,'mansirastogi1997@gmail.com','Yes');

create table admin_login(login_id varchar2(20), user_name varchar2(20) password varchar2(20), password varchar2(20));
insert into admin_login(login_id,user_name,password values('arpitrastogi27','Arpit Rastogi','sis123'));

create table teacher(teacher_id number, name varchar2(100),dob date, gender varchar2(10),fathername varchar2(100), contactno number, email varchar2(100),address varchar2(100),highestdegree varchar2(100),institute varchar2(150), teachingschedule varchar2(100), ishired varchar2(3), isdeleted varchar2(3));
create sequence teacher_id;

create sequence cv_seq;
create table teachercv(cvid int primary key, teacher_id int, cv blob,uploadTime timestamp, constraint fk_teacher_id foreign key (teacher_id) references teacher(teacher_id) );

create sequence work_seq;
create table teacher_institute_worked(id int primary key, teacher_id int not null, institute varchar2(50),constraint fk_worked_institute foreign key (teacher_id) references teacher(teacher_id ));

create sequence taughtsubject_sequence;
create table teacher_subjects(id number primary key, teacher_id number not null, taughtsubjects varchar2(25), constraint fk_taughtsubjects foreign key (teacher_id) references teacher(teacher_id));  

insert into teacher values(teacher_id.nextval,'Raghav','04/Jul/1970','Male','Satish rastogi',7487489699,'satishssh@gmail.com','nai basti sitapur','Phd','HBTU',5,'Full time','Yes',null);

insert into teacher_institute_worked values(work_seq.nextval,teacher_id.currval,'hbtu');
insert into teacher_institute_worked values(work_seq.nextval,teacher_id.currval,'csa');
insert into teacher_institute_worked values(work_seq.nextval,teacher_id.currval,'NIT allahabad');
insert into teacher_institute_worked values(work_seq.nextval,teacher_id.currval,'IIT kanpur');

insert into teacher values(teacher_id.nextval,'Deepak','24/Jul/1980','female','Suresh kumar rastogi',7485969699,'deepaksingh@gmail.com','sukhumalroad sitapur','Phd','NIT',8,'Full time',null,null);
insert into teacher_institute_worked values(work_seq.nextval,teacher_id.currval,'Rama University');
insert into teacher_institute_worked values(work_seq.nextval,teacher_id.currval,'BITS');
insert into teacher_institute_worked values(work_seq.nextval,teacher_id.currval,'NIT allahabad');
insert into teacher_institute_worked values(work_seq.nextval,teacher_id.currval,'IIT kanpur');

insert into teacher_subjects values(taughtsubject_sequence.nextval,teacher_id.currval,'cryptography');
insert into teacher_subjects values(taughtsubject_sequence.nextval,teacher_id.currval,'Operating System');
insert into teacher_subjects values(taughtsubject_sequence.nextval,teacher_id.currval,'Java Programming');

Create sequence courses_id start with 101 increment by 2;
create table courses(course_id number, course_name varchar2(100));
select * from courses;

Create sequence subject_id start with 101 increment by 2;
create table subjects(subject_id number, subject_name varchar2(100));
alter table subjects add constraint subjects_pk primary key (subject_id);
alter table subjects add constraint subjects_unique unique (subject_name );


create sequence taughtsubject_sequence;
drop sequence taughtsubject_sequence;
create table teacher_subjects(id number primary key, teacher_id number not null, subject_id number);
alter table teacher_subjects add  constraint fk_taughtsubjects foreign key (teacher_id) references teacher(teacher_id);
alter table teacher_subjects add  constraint fk_subjectid      foreign key (subject_id)  references subjects(subject_id);  

create sequence student_enrolled;
create table student_enrolled_batches(enrollid int primary key, rollno int, batch_id int ,isEnrolled varchar2(3)); 
alter table student_enrolled_batches add constraint fk_student_rollno foreign key (rollno) references student (rollno);
alter table student_enrolled_batches add constraint fk_student_batch_id foreign key (batch_id) references batches (batch_id);

create sequence assignment_id;
create table assignment(assignment_id number,batch_id number,
assignment_name varchar2(100), file_name varchar2(100),
assignment_file blob, due_date date, uploadTime timestamp,
constraint fk_batch_id foreign key (batch_id) references batches (batch_id)
);
alter table assignment add constraint pk_group primary key(batch_id, assignment_name);

select assignment_id,batch_id,assignment_name,file_name,due_date, uploadtime from assignment;