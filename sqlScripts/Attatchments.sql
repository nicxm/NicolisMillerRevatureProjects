DROP TABLE IF EXISTS attachments;

CREATE TABLE IF NOT EXISTS attachments
(
 attach_id serial ,
 url       varchar(200) ,
 r_id      integer ,
 CONSTRAINT PK_attatchments PRIMARY KEY ( attach_id ),
 CONSTRAINT reimbursements_to_attachments FOREIGN KEY ( r_id ) REFERENCES reimbursements ( r_id )
);

CREATE INDEX fk_r_id_attach ON attachments
(
 r_id
);

insert into attachments (attach_id, url, r_id) values (default,'imgur link',1);
insert into attachments (attach_id, url, r_id) values (default,'test',1);

select * from attachments;