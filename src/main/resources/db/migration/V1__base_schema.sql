--
-- Name: HONOR_TYPE; Type: TYPE; Schema: public; Owner: postgres
--

CREATE TYPE HONOR_TYPE AS ENUM (
    'NH',
    'HM',
    'CL',
    'MCL',
    'SCL'
);

ALTER TYPE HONOR_TYPE OWNER TO postgres;

-- STUDENT TABLE CREATION
CREATE TABLE public.student (
   id UUID DEFAULT gen_random_uuid() NOT NULL,
   name VARCHAR(255),
   age INTEGER NOT NULL,
   honor HONOR_TYPE,

   CONSTRAINT pk_student PRIMARY KEY (id)
);

ALTER TABLE public.student OWNER TO postgres;

-- STORED PROCEDURES
CREATE PROCEDURE GET_TOTAL_STUDENT_BY_HONOR(IN honor_in VARCHAR(5), OUT num_of_student_out INT)
AS $$
BEGIN
    SELECT COUNT(*) into num_of_student_out FROM student s WHERE s.honor::VARCHAR = honor_in;
END;
$$ LANGUAGE plpgsql;

CREATE PROCEDURE GET_TOTAL_STUDENT_BY_AGE(IN age_in INT, OUT num_of_student_out INT)
AS $$
BEGIN
    SELECT COUNT(*) into num_of_student_out from student s WHERE s.age = age_in;
END
$$ LANGUAGE plpgsql;;

-- STORED DATA
INSERT INTO student(name, age, honor) VALUES('Stephen', 24, 'HM');
INSERT INTO student(name, age, honor) VALUES('Mark', 29, 'SCL');
INSERT INTO student(name, age, honor) VALUES('Sam', 29, 'CL');
INSERT INTO student(name, age, honor) VALUES('Bon', 25, 'MCL');
INSERT INTO student(name, age, honor) VALUES('Paul', 25, 'NH');
INSERT INTO student(name, age) VALUES('Ben', 25);