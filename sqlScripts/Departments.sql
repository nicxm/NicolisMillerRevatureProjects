DROP TABLE IF EXISTS departments;

CREATE TABLE IF NOT EXISTS departments
(
 dept_id serial ,
 d_name  varchar(50) ,
 d_head  varchar(50) ,
 CONSTRAINT PK_department PRIMARY KEY ( dept_id )
);

select * from departments d ;
delete from departments ;