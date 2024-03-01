CREATE TABLE student (
   id UUID DEFAULT gen_random_uuid() NOT NULL,
   name VARCHAR(255),
   age INTEGER NOT NULL,
   CONSTRAINT pk_student PRIMARY KEY (id)
);

INSERT INTO student(name, age) VALUES('Stephen', 24);
INSERT INTO student(name, age) VALUES('Mark', 29);
INSERT INTO student(name, age) VALUES('Ben', 25);