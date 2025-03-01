/*
 * This file is generated by jOOQ.
 */
package jooqdata.tables.daos;


import java.util.List;

import jooqdata.tables.Lecturer;
import jooqdata.tables.records.LecturerRecord;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class LecturerDao extends DAOImpl<LecturerRecord, jooqdata.tables.pojos.Lecturer, Long> {

    /**
     * Create a new LecturerDao without any configuration
     */
    public LecturerDao() {
        super(Lecturer.LECTURER, jooqdata.tables.pojos.Lecturer.class);
    }

    /**
     * Create a new LecturerDao with an attached configuration
     */
    public LecturerDao(Configuration configuration) {
        super(Lecturer.LECTURER, jooqdata.tables.pojos.Lecturer.class, configuration);
    }

    @Override
    public Long getId(jooqdata.tables.pojos.Lecturer object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<jooqdata.tables.pojos.Lecturer> fetchRangeOfId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(Lecturer.LECTURER.ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<jooqdata.tables.pojos.Lecturer> fetchById(Long... values) {
        return fetch(Lecturer.LECTURER.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public jooqdata.tables.pojos.Lecturer fetchOneById(Long value) {
        return fetchOne(Lecturer.LECTURER.ID, value);
    }

    /**
     * Fetch records that have <code>name BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<jooqdata.tables.pojos.Lecturer> fetchRangeOfName(String lowerInclusive, String upperInclusive) {
        return fetchRange(Lecturer.LECTURER.NAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>name IN (values)</code>
     */
    public List<jooqdata.tables.pojos.Lecturer> fetchByName(String... values) {
        return fetch(Lecturer.LECTURER.NAME, values);
    }

    /**
     * Fetch records that have <code>surname BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<jooqdata.tables.pojos.Lecturer> fetchRangeOfSurname(String lowerInclusive, String upperInclusive) {
        return fetchRange(Lecturer.LECTURER.SURNAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>surname IN (values)</code>
     */
    public List<jooqdata.tables.pojos.Lecturer> fetchBySurname(String... values) {
        return fetch(Lecturer.LECTURER.SURNAME, values);
    }

    /**
     * Fetch records that have <code>email BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<jooqdata.tables.pojos.Lecturer> fetchRangeOfEmail(String lowerInclusive, String upperInclusive) {
        return fetchRange(Lecturer.LECTURER.EMAIL, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>email IN (values)</code>
     */
    public List<jooqdata.tables.pojos.Lecturer> fetchByEmail(String... values) {
        return fetch(Lecturer.LECTURER.EMAIL, values);
    }

    /**
     * Fetch records that have <code>phone BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<jooqdata.tables.pojos.Lecturer> fetchRangeOfPhone(String lowerInclusive, String upperInclusive) {
        return fetchRange(Lecturer.LECTURER.PHONE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>phone IN (values)</code>
     */
    public List<jooqdata.tables.pojos.Lecturer> fetchByPhone(String... values) {
        return fetch(Lecturer.LECTURER.PHONE, values);
    }
}
