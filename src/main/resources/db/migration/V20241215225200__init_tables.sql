CREATE SEQUENCE lecturer_id_seq;

CREATE TABLE lecturer
(
    id      BIGINT PRIMARY KEY DEFAULT nextval('lecturer_id_seq'),
    name    VARCHAR(255) NOT NULL,
    surname VARCHAR(255) NOT NULL,
    email   VARCHAR(255) NOT NULL,
    phone   VARCHAR(20)  NOT NULL
);

CREATE SEQUENCE subject_id_seq;

CREATE TABLE subject
(
    id         BIGINT PRIMARY KEY DEFAULT nextval('subject_id_seq'),
    name       VARCHAR(255) NOT NULL,
    code       VARCHAR(50)  NOT NULL,
    hour_count INT          NOT NULL
);

CREATE SEQUENCE timetable_id_seq;

CREATE TABLE timetable
(
    id          BIGINT PRIMARY KEY DEFAULT nextval('timetable_id_seq'),
    room_number INT NOT NULL,
    pare_number INT NOT NULL,
    lecture_id  BIGINT,
    subject_id  BIGINT
--     FOREIGN KEY (lecture_id) REFERENCES lecturer (id),
--     FOREIGN KEY (subject_id) REFERENCES subject (id)
);