ALTER TABLE lecturer
    ADD COLUMN start_work TIMESTAMP NOT NULL DEFAULT now();
ALTER TABLE lecturer
    ADD COLUMN start_profession TIMESTAMP NOT NULL;

