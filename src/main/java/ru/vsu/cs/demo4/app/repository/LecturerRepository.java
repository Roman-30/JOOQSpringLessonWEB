package ru.vsu.cs.demo4.app.repository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.jooq.Record;
import org.jooq.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import ru.vsu.cs.demo4.app.exception.EntityNotSavedException;
import ru.vsu.cs.demo4.app.filter.LecturerFilter;
import ru.vsu.cs.demo4.app.model.Lecturer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static jooqdata.Tables.LECTURER;
import static org.jooq.impl.DSL.noCondition;

@Repository
@RequiredArgsConstructor
public class LecturerRepository {
    private final DSLContext dslContext;

    public Lecturer findLecturerById(Long id) {
        return dslContext.selectFrom(LECTURER)
                .where(LECTURER.ID.eq(id))
                .fetchOptionalInto(Lecturer.class)
                .orElseThrow(
                        () -> new EntityNotFoundException(
                                String.format("For id:%s lecturer not found!", id)
                        )
                );
    }

    public List<Lecturer> findAllLecturers() {
        return dslContext.selectFrom(LECTURER)
                .fetchInto(Lecturer.class);
    }

    @SneakyThrows
    public Lecturer saveLecturer(Lecturer lecturer) {
        var record = dslContext.newRecord(LECTURER, lecturer);

        return dslContext.insertInto(LECTURER)
                .set(record)
                .onDuplicateKeyUpdate()
                .set(record)
                .returning()
                .fetchOptionalInto(Lecturer.class)
                .orElseThrow(
                        () -> new EntityNotSavedException(
                                "Lecturer not saved!"
                        )
                );
    }

    public void deleteLecturerById(Long id) {
        dslContext.deleteFrom(LECTURER)
                .where(LECTURER.ID.eq(id))
                .execute();
    }

    public Page<Lecturer> findLecturers(LecturerFilter filter, Pageable pageable) {
        List<SortField<?>> sortFields = createSortCondition(pageable);

        List<Lecturer> templateList = dslContext.fetch(buildInitQuery(
                        filter,
                        pageable,
                        sortFields
                )
        ).into(Lecturer.class);

        return new PageImpl<>(templateList, pageable, templateList.size());
    }

    private List<SortField<?>> createSortCondition(Pageable pageable) {
        List<SortField<?>> sortFields = new ArrayList<>();
        Sort sort = pageable.getSort();
        sort.forEach(order -> {
            String property = order.getProperty();
            Field<?> field = LECTURER.field(property);
            if (field != null) {
                SortOrder sortOrder = order.getDirection() == Sort.Direction.ASC ? SortOrder.ASC : SortOrder.DESC;
                SortField<?> sortField = field.sort(sortOrder);
                sortFields.add(sortField);
            }
        });

        return sortFields;
    }

    private Select<? extends Record> buildInitQuery(LecturerFilter criteria, Pageable pageable, List<SortField<?>> sortFields) {
        int pageNumber = pageable.getPageNumber();
        int pageSize = pageable.getPageSize();
        int offset = (pageNumber - 1) * pageSize;

        return dslContext
                .selectFrom(LECTURER)
                .where(buildInitWhere(criteria))
                .orderBy(sortFields)
                .limit(pageSize)
                .offset(offset);
    }

    private Condition buildInitWhere(LecturerFilter criteria) {
        Condition whereCondition = noCondition();

        if (Objects.isNull(criteria)) {
            return whereCondition;
        }

        whereCondition = whereCondition.and(Optional.ofNullable(criteria.getKeyValue())
                .map(val -> LECTURER.EMAIL.containsIgnoreCase(val)
                        .or(LECTURER.NAME.containsIgnoreCase(val))
                        .or(LECTURER.SURNAME.containsIgnoreCase(val))
                        .or(LECTURER.PHONE.containsIgnoreCase(val)))
                .orElse(noCondition())
        );

        whereCondition = whereCondition.and(Optional.ofNullable(criteria.getName())
                .map(LECTURER.NAME::eq)
                .orElse(noCondition())
        );

        whereCondition = whereCondition.and(Optional.ofNullable(criteria.getSurname())
                .map(LECTURER.SURNAME::eq)
                .orElse(noCondition())
        );

        whereCondition = whereCondition.and(Optional.ofNullable(criteria.getStartWork())
                .map(LECTURER.START_WORK::greaterOrEqual)
                .orElse(noCondition())
        );

        whereCondition = whereCondition.and(Optional.ofNullable(criteria.getStartProfession())
                .map(LECTURER.START_PROFESSION::greaterOrEqual)
                .orElse(noCondition())
        );

        return whereCondition;
    }
}
