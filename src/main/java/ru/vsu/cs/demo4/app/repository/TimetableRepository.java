package ru.vsu.cs.demo4.app.repository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import ru.vsu.cs.demo4.app.exception.EntityNotSavedException;
import ru.vsu.cs.demo4.app.model.Timetable;

import java.util.List;

import static jooqdata.Tables.TIMETABLE;

@Repository
@RequiredArgsConstructor
public class TimetableRepository {
    private final DSLContext dslContext;
    public Timetable findTimetableById(Long id) {
        return dslContext.selectFrom(TIMETABLE)
                .where(TIMETABLE.ID.eq(id))
                .fetchOptionalInto(Timetable.class)
                .orElseThrow(
                        () -> new EntityNotFoundException(
                                String.format("For id:%s timetable not found!", id)
                        )
                );
    }

    public List<Timetable> findAllTimetables() {
        return dslContext.selectFrom(TIMETABLE)
                .fetchInto(Timetable.class);
    }

    @SneakyThrows
    public Timetable saveTimetable(Timetable timetable) {
        var record = dslContext.newRecord(TIMETABLE, timetable);

        return dslContext.insertInto(TIMETABLE)
                .set(record)
                .onDuplicateKeyUpdate()
                .set(record)
                .returning()
                .fetchOptionalInto(Timetable.class)
                .orElseThrow(
                        () -> new EntityNotSavedException(
                                "Timetable not saved!"
                        )
                );
    }

    public void deleteTimetableById(Long id) {
        dslContext.deleteFrom(TIMETABLE)
                .where(TIMETABLE.ID.eq(id))
                .execute();
    }
}
