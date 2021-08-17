DROP TABLE IF EXISTS grading_formats;

CREATE TABLE IF NOT EXISTS grading_formats
(
 grading_format varchar(50) ,
 gf_id          serial ,
 description    varchar(240) ,
 CONSTRAINT PK_grading_format PRIMARY KEY ( gf_id )
);

insert into grading_formats ("gf_id", "grading_format", "description") values (default,'A','the standard letter grade');
insert into grading_formats ("gf_id", "grading_format", "description") values (default,'test','test');

select * from grading_formats gf ;




drop table attachments ;
drop table departments ;
drop table employees ;
drop table event_types ;
drop table events ;
drop table grading_formats ;
drop table presentations ;
drop table reimbursements ;
drop table requests ;