DROP TABLE IF EXISTS events;

CREATE TABLE IF NOT EXISTS events
(
 ev_id       serial ,
 start_time  bigint ,
 end_time    bigint ,
 cost        numeric(10,2) ,
 location    varchar(200) ,
 description varchar(240) ,
 gf_id       integer ,
 et_id       integer ,
 CONSTRAINT PK_events PRIMARY KEY ( ev_id ),
 CONSTRAINT et_to_events FOREIGN KEY ( et_id ) REFERENCES event_types ( et_id ),
 CONSTRAINT gf_to_events FOREIGN KEY ( gf_id ) REFERENCES grading_formats ( gf_id )
);

CREATE INDEX fk_et_id ON events
(
 et_id
);

CREATE INDEX fk_gf_id ON events
(
 gf_id
);


INSERT INTO events ("ev_id","start_time","end_time","cost","location","description","gf_id","et_id") 
values (default,0,0,100,'NACC','A college class',1,1);

INSERT INTO events ("ev_id","start_time","end_time","cost","location","description","gf_id","et_id") 
values (default,0,0,100,'test','test',1,1);

select * from events;