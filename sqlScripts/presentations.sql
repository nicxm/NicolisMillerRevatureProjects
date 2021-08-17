DROP TABLE IF EXISTS presentations;

CREATE TABLE IF NOT EXISTS presentations
(
 pres_id     serial ,
 description varchar(50) ,
 r_id        integer ,
 CONSTRAINT PK_presentation PRIMARY KEY ( pres_id ),
 CONSTRAINT reimbursements_to_presentations FOREIGN KEY ( r_id ) REFERENCES reimbursements ( r_id )
);

CREATE INDEX fk_r_id_pres ON presentations
(
 r_id
);


insert into presentations (pres_id, description , r_id) values (default,'presentation',1);
insert into presentations (pres_id, description , r_id) values (default,'test',1);

select * from presentations;