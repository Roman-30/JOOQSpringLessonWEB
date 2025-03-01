package ru.vsu.cs.demo4.app.repository;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class LecturerRepository {
   private final DSLContext dslContext;
}
