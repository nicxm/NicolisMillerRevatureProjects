DROP TABLE IF EXISTS event_types;

CREATE TABLE IF NOT EXISTS event_types
(
 event_type varchar(50) ,
 et_id      serial ,
 "percent"    numeric(2) ,
 CONSTRAINT PK_event_type PRIMARY KEY ( et_id )
);

insert into event_types ("et_id", "event_type", "percent") values (default , 'Cert', 90);
insert into event_types ("et_id", "event_type", "percent") values (default , 'test', 0);

select * from event_types et ;