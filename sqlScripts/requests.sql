DROP TABLE IF EXISTS requests;

CREATE TABLE IF NOT EXISTS requests
(
 req_id  serial ,
 message varchar(240) ,
 approve boolean ,
 e_id    integer ,
 r_id    integer ,
 CONSTRAINT PK_requests PRIMARY KEY ( req_id ),
 CONSTRAINT emp_to_requests FOREIGN KEY ( e_id ) REFERENCES employees ( e_id ),
 CONSTRAINT reimbursements_to_requests FOREIGN KEY ( r_id ) REFERENCES reimbursements ( r_id )
);

CREATE INDEX fk_e_id_req ON requests
(
 e_id
);

CREATE INDEX fk_r_id_req ON requests
(
 r_id
);

insert into requests (req_id, message, approve, e_id , r_id) values (default,'hello',true, 2,1);
insert into requests (req_id, message, approve, e_id , r_id) values (default,'test',false, 2,1);

select * from requests;
