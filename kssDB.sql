-- Creation of Database
CREATE DATABASE knowledge_sharing_system;

USE knowledge_sharing_system;

-- Creation of tables
CREATE TABLE discipline (
  id INTEGER  AUTO_INCREMENT,
	description VARCHAR(40) NOT NULL,
	semester VARCHAR(6),
	PRIMARY KEY (id));

CREATE TABLE student (
  id INTEGER  AUTO_INCREMENT,
	name VARCHAR(60),
	email VARCHAR(60) NOT NULL,
	password VARCHAR(20) NOT NULL,
	course VARCHAR(60),
	semester VARCHAR(6),
	registration INTEGER,
	PRIMARY KEY (id));

CREATE TABLE send (
  id INTEGER  AUTO_INCREMENT,
	shipping_send INTEGER NOT NULL, -- 1: question, 2: reply, 3: comment_question, 4: comment_reply
	send_date DATE,
	shipping_text TEXT,
	sent_by INTEGER,
	PRIMARY KEY (id));	

CREATE TABLE question (
	id_send INTEGER NOT NULL,
	title VARCHAR(60),
	related_to INTEGER,
	PRIMARY KEY (id_send));

CREATE TABLE reply (
	id_send INTEGER NOT NULL,
	PRIMARY KEY (id_send));

CREATE TABLE comment_question (
	id_send INTEGER NOT NULL,
	related_to INTEGER,
	PRIMARY KEY (id_send));
	
CREATE TABLE comment_reply (
	id_send INTEGER NOT NULL,
	related_to INTEGER,
	PRIMARY KEY (id_send));

-- Auxiliary table to represent the student-discipline relationship
CREATE TABLE student_studies_discipline (
    student_id INTEGER NOT NULL,
    discipline_id INTEGER NOT NULL,
    PRIMARY KEY (student_id, discipline_id));


-- Foreign key for relationship between comments and replies
ALTER TABLE comment_reply ADD CONSTRAINT related_by_reply_fk
  FOREIGN KEY (related_to) REFERENCES reply(id_send);  
   
-- Foreign key for relationship between comments and question
ALTER TABLE comment_question ADD CONSTRAINT related_by_question_fk
    FOREIGN KEY (related_to) REFERENCES question(id_send);
    
-- Generalization: one table per entity - send, question, reply, comment_question, comment_reply
ALTER TABLE question ADD CONSTRAINT send_question_fk
    FOREIGN KEY (id_send) REFERENCES send(id);

ALTER TABLE reply ADD CONSTRAINT send_reply_fk
    FOREIGN KEY (id_send) REFERENCES send(id);

ALTER TABLE comment_question ADD CONSTRAINT send_comment_question_fk
    FOREIGN KEY (id_send) REFERENCES send(id);

ALTER TABLE comment_reply ADD CONSTRAINT send_comment_reply_fk
    FOREIGN KEY (id_send) REFERENCES send(id);
    
-- Relationship between student and send
ALTER TABLE send ADD CONSTRAINT sent_by_fk
    FOREIGN KEY (sent_by) REFERENCES student(id);

-- Relationship between question and discipline
ALTER TABLE question ADD CONSTRAINT related_to_fk
    FOREIGN KEY (related_to) REFERENCES discipline(id);

-- Relationship between student and discipline
ALTER TABLE student_studies_discipline ADD CONSTRAINT student_studies_discipline_student_fk
    FOREIGN KEY (student_id) REFERENCES student(id);

ALTER TABLE student_studies_discipline ADD CONSTRAINT student_studies_discipline_discipline_fk
    FOREIGN KEY (discipline_id) REFERENCES discipline(id);
    

-- Creation of unique index in the email field of the student table
CREATE UNIQUE INDEX student_email_uq ON student(email);

-- Creation of grouping index in foreign keys
CREATE INDEX comment_question_related_to_idx ON comment_question(related_to);

CREATE INDEX comment_reply_related_to_idx ON comment_reply(related_to);

CREATE INDEX question_id_send_idx ON question(id_send);

CREATE INDEX reply_id_send_idx ON reply(id_send);

CREATE INDEX comment_question_id_send_idx ON comment_question(id_send);

CREATE INDEX comment_reply_id_send_idx ON comment_reply(id_send);

CREATE INDEX send_sent_by_idx ON send(sent_by);

CREATE INDEX question_related_to_idx ON question(related_to);

CREATE INDEX student_studies_discipline_student_id_idx ON student_studies_discipline(student_id);

CREATE INDEX student_studies_discipline_discipline_id_idx ON student_studies_discipline(discipline_id);

-- Creation of grouping index in most searched columns
CREATE INDEX student_name_idx ON student(name);

CREATE INDEX question_title_idx ON question(title);

-- Creation of composite index
CREATE INDEX student_semester_course_idx ON student(semester, course);
