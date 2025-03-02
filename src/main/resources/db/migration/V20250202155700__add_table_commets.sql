COMMENT ON TABLE lecturer IS 'Table to store information about lecturers';
 ON COLUMN lecturer.id IS 'Unique identifier for the lecturer';
 ON COLUMN lecturer.name IS 'First name of the lecturer';
 ON COLUMN lecturer.surname IS 'Last name of the lecturer';
 ON COLUMN lecturer.email IS 'Email address of the lecturer';
 ON COLUMN lecturer.phone IS 'Phone number of the lecturer';
 ON COLUMN lecturer.start_work IS 'Date and time when the lecturer started working';
 ON COLUMN lecturer.start_profession IS 'Date and time when the lecturer started their profession';

COMMENT ON TABLE subject IS 'Table to store information about subjects';
COMMENT ON COLUMN subject.id IS 'Unique identifier for the subject';
COMMENT ON COLUMN subject.name IS 'Name of the subject';
COMMENT ON COLUMN subject.code IS 'Code representing the subject';
COMMENT ON COLUMN subject.hour_count IS 'Total number of hours for the subject';

COMMENT ON TABLE timetable IS 'Table to store timetable information';
COMMENT ON COLUMN timetable.id IS 'Unique identifier for the timetable entry';
COMMENT ON COLUMN timetable.room_number IS 'Room number where the lecture is held';
COMMENT ON COLUMN timetable.pare_number IS 'Pair number representing the lecture slot';
COMMENT ON COLUMN timetable.lecture_id IS 'Identifier for the lecturer';
COMMENT ON COLUMN timetable.subject_id IS 'Identifier for the subject';