package ru.vsu.cs.demo4.app.repository;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class TimetableRepository {
    private final DSLContext dslContext;
}
