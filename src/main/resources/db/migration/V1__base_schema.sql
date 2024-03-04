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

CREATE TABLE public.student (
   id UUID DEFAULT gen_random_uuid() NOT NULL,
   name VARCHAR(255),
   age INTEGER NOT NULL,
   honor HONOR_TYPE,

   CONSTRAINT pk_student PRIMARY KEY (id)
);

ALTER TABLE public.student OWNER TO postgres;

INSERT INTO student(name, age, honor) VALUES('Stephen', 24, 'HM');
INSERT INTO student(name, age, honor) VALUES('Mark', 29, 'SCL');
INSERT INTO student(name, age) VALUES('Ben', 25);