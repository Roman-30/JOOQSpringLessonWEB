package ru.vsu.cs.demo4.app.repository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import ru.vsu.cs.demo4.app.exception.EntityNotSavedException;
import ru.vsu.cs.demo4.app.model.Subject;

import java.util.List;

import static jooqdata.Tables.SUBJECT;

@Repository
@RequiredArgsConstructor
public class SubjectRepository {
    private final DSLContext dslContext;

    public Subject findSubjectById(Long id) {
        return dslContext.selectFrom(SUBJECT)
                .where(SUBJECT.ID.eq(id))
                .fetchOptionalInto(Subject.class)
                .orElseThrow(
                        () -> new EntityNotFoundException(
                                String.format("For id:%s subject not found!", id)
                        )
                );
    }

    public List<Subject> findAllSubjects() {
        return dslContext.selectFrom(SUBJECT)
                .fetchInto(Subject.class);
    }

    @SneakyThrows
    public Subject saveSubject(Subject subject) {
        var record = dslContext.newRecord(SUBJECT, subject);

        return dslContext.insertInto(SUBJECT)
                .set(record)
                .onDuplicateKeyUpdate()
                .set(record)
                .returning()
                .fetchOptionalInto(Subject.class)
                .orElseThrow(
                        () -> new EntityNotSavedException(
                                "Subject not saved!"
                        )
                );
    }

    public void deleteSubjectById(Long id) {
        dslContext.deleteFrom(SUBJECT)
                .where(SUBJECT.ID.eq(id))
                .execute();
    }
}
