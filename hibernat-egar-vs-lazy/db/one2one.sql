
DROP TABLE IF EXISTS instructor_details;
DROP sequence IF EXISTS seq_instructor_details;
CREATE sequence seq_instructor_details;
CREATE TABLE instructor_details (
  id INTEGER NOT NULL default nextval('seq_instructor_details') , 
  youtube_channel character varying(50),
  hobby character varying(50),
  PRIMARY KEY (id)
);

DROP TABLE IF EXISTS instructor;
DROP sequence IF EXISTS seq_instructor_id;
CREATE sequence seq_instructor_id;
CREATE TABLE instructor (
 id INTEGER NOT NULL default nextval('seq_instructor_id'),
 first_name character varying(15),
 last_name character varying(15) ,
 email character varying(50),
 instructor_details_id INTEGER ,	
 PRIMARY KEY (id) 
);


ALTER TABLE instructor 
   ADD CONSTRAINT fk_instructor_details_id
   FOREIGN KEY (instructor_details_id) 
   REFERENCES instructor_details(id) ON DELETE NO ACTION ON UPDATE NO ACTION ;

===========================

--- kb solution 
DROP TABLE IF EXISTS instructor_details,instructor cascade;

create table instructor_details (
	id SERIAL primary key,
	youtube_channel character varying(15),
	hobby character varying(20)
);

create table instructor (
     id SERIAL primary key,
     instructor_details_id integer,
	 first_name character varying(200),
	 last_name character varying(200),
     email character varying(200),
     CONSTRAINT fk_instructor FOREIGN KEY (instructor_details_id)
     REFERENCES instructor_details(id)
);

DROP TABLE IF EXISTS course;	
create table course	(
id SERIAL primary key,
title character varying(150) unique,
instructor_id INTEGER,
CONSTRAINT fk_instructor FOREIGN KEY (instructor_id)
REFERENCES instructor(id) ON DELETE NO ACTION ON UPDATE NO ACTION 

);

DROP TABLE IF EXISTS review;	

create table review(
id SERIAL primary key,
comment character varying(150) unique,
course_id INTEGER,
CONSTRAINT fk_course FOREIGN KEY (course_id)
REFERENCES course(id) ON DELETE NO ACTION ON UPDATE NO ACTION 
);

