DROP TABLE IF EXISTS reimbursements;

CREATE TABLE IF NOT EXISTS reimbursements
(
 r_id              serial ,
 claim             numeric(6,2) ,
 grade             varchar(50) ,
 reason            varchar(240) ,
 s_approved        boolean ,
 dep_head_approved boolean ,
 ben_co_approved   boolean ,
 e_id              integer ,
 ev_id             integer ,
 CONSTRAINT PK_reimbursement PRIMARY KEY ( r_id ),
 CONSTRAINT emp_to_reimbursements FOREIGN KEY ( e_id ) REFERENCES employees ( e_id ),
 CONSTRAINT events_to_reimbursements FOREIGN KEY ( ev_id ) REFERENCES events ( ev_id )
);

CREATE INDEX fk_e_id_reim ON reimbursements
(
 e_id
);

CREATE INDEX fk_ev_id ON reimbursements
(
 ev_id
);

insert into reimbursements ("r_id","claim","grade","reason","s_approved","dep_head_approved","ben_co_approved","e_id","ev_id")
values (default, 10,'A','to learn',true,true,true,1,1);

insert into reimbursements ("r_id","claim","grade","reason","s_approved","dep_head_approved","ben_co_approved","e_id","ev_id")
values (default, 0,'test','test',false,false,false,1,1);

select * from reimbursements r ;

delete from reimbursements where r_id = 2;