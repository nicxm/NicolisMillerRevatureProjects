DROP TABLE IF EXISTS employees;

CREATE TABLE IF NOT EXISTS employees
(
 e_id          serial ,
 username      varchar(50) ,
 password      varchar(50) ,
 name          varchar(50) ,
 dob           varchar(50) ,
 email         varchar(50) ,
 awarded_r     numeric(6,2) ,
 supervisor_id integer ,
 dept_id       integer ,
 ben_co_id     integer ,
 CONSTRAINT PK_employee PRIMARY KEY ( e_id ),
 CONSTRAINT emp_to_emp_benco_id FOREIGN KEY ( ben_co_id ) REFERENCES employees ( e_id ),
 CONSTRAINT dept_to_emp FOREIGN KEY ( dept_id ) REFERENCES departments ( dept_id ),
 CONSTRAINT emp_to_emp_s_id FOREIGN KEY ( supervisor_id ) REFERENCES employees ( e_id )
);

CREATE INDEX fk_benco_id ON employees
(
 ben_co_id
);

CREATE INDEX fk_dept_id ON employees
(
 dept_id
);

CREATE INDEX fk_supervisor_id ON employees
(
 supervisor_id
);

INSERT INTO "public"."employees" ("e_id","username","password","name","dob","email","awarded_r") VALUES (default,'username1','password1','Bernstein','07/28/90','PabloBugno@excite.it',0);
update employees set e_id = 1, supervisor_id = 1 , dept_id = 1 , ben_co_id = 1 where e_id = 1;

insert into employees ("e_id","username","password","name","dob","email","awarded_r", "supervisor_id","dept_id","ben_co_id") values (8, 'user','password','Nicolis','dob','email',0,6,5,7);
select * from employees e ;
delete from employees where e_id = 8;
