
drop database if exists test0311;

create database test0311;

use test0311;

drop table if exists classes;
create table classes(
    id int primary key auto_increment,
    name varchar(50),
    `desc` varchar(50)
);
insert into classes(name, `desc`) values
('计算机系2019级1班', '学习了计算机原理、C和Java语言、数据结构和算法'),
('中文系2019级3班','学习了中国传统文学'),
('自动化2019级5班','学习了机械自动化');


drop table if exists student;
create table student(
    id int primary key auto_increment,
    sn int,
    name varchar(30),
    qq_mail varchar(30),
    classes_id int
);

insert into student(sn, name, qq_mail, classes_id) values
('09982','黑旋风李逵','xuanfeng@qq.com',1),
('00835','菩提老祖',null,1),
('00391','白素贞',null,1),
('00031','许仙','xuxian@qq.com',1),
('00054','不想毕业',null,1),
('51234','好好说话','say@qq.com',2),
('83223','tellme',null,2),
('09527','老外学中文','foreigner@qq.com',2);



drop table if exists course;
create table course(
    id int primary key auto_increment,
    name varchar(20)
);


insert into course(name) values
('Java'),('中国传统文化'),('计算机原理'),('语文'),('高阶数学'),('英文');



drop table if exists score;
create table score(
    id int primary key auto_increment,
    score DECIMAL,
    student_id int,
    course_id int
);


insert into score(score, student_id, course_id) values
-- 黑旋风李逵
(70.5, 1, 1),(98.5, 1, 3),(33, 1, 5),(98, 1, 6),
-- 菩提老祖
(60, 2, 1),(59.5, 2, 5),
-- 白素贞
(33, 3, 1),(68, 3, 3),(99, 3, 5),
-- 许仙
(67, 4, 1),(23, 4, 3),(56, 4, 5),(72, 4, 6),
-- 不想毕业
(81, 5, 1),(37, 5, 5),
-- 好好说话
(56, 6, 2),(43, 6, 4),(79, 6, 6),
-- tellme
(80, 7, 2),(92, 7, 6);

select *from student,score where student.id = score.student_id and student.id = 4;
select student.name ,sum(score.score)from score,student  where student.id = score.id group by student.id;
select s2.* from score s1,score s2
where s1.student_id = s2.student_id 
and s1.course_id = 1
and s2.course_id = 3
and s1.score < s2.score 
