/*
 * This file is generated by jOOQ.
 */
package jooqdata;


import java.util.Arrays;
import java.util.List;

import jooqdata.tables.Lecturer;
import jooqdata.tables.Subject;
import jooqdata.tables.Timetable;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Public extends SchemaImpl {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public</code>
     */
    public static final Public PUBLIC = new Public();

    /**
     * The table <code>public.lecturer</code>.
     */
    public final Lecturer LECTURER = Lecturer.LECTURER;

    /**
     * The table <code>public.subject</code>.
     */
    public final Subject SUBJECT = Subject.SUBJECT;

    /**
     * The table <code>public.timetable</code>.
     */
    public final Timetable TIMETABLE = Timetable.TIMETABLE;

    /**
     * No further instances allowed
     */
    private Public() {
        super("public", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        return Arrays.asList(
            Lecturer.LECTURER,
            Subject.SUBJECT,
            Timetable.TIMETABLE
        );
    }
}
