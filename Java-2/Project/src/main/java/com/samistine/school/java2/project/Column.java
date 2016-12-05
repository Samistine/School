/**
 * Class: CIST 2372 Java II
 * Quarter: Fall 2016
 * Instructor: Dave Busse
 * Project: Unit03
 * Date: Created Sep 13, 2016 7:18:53 PM
 *
 * By turning in this code, I Pledge:
 * 1. That I have completed the programming assignment independently.
 * 2. I have not copied the code from a student or any source.
 * 3. I have not given my code to any student.
 *
 * @author Samuel Seidel <samuel@samistine.com>
 * @version 1.0
 */
package com.samistine.school.java2.project;

import java.util.function.Function;

/**
 * For use in {@link TableData}
 *
 * @author Samuel Seidel
 * @param <E> the Java object representing the data for each row
 * @see TableData
 */
public class Column<E > {
    final Class<?> displayType;
    final String columnName;
    final Function<E, Object> mapper;

    /**
     * Constructs a column for use in {@link TableData}
     *
     * @param displayType The type of data {@link Column this} is.
     * @param columnName the name of {@link Column this}, used for display in tables.
     * @param mapper the mapper to convert a Java Object, of type {@link E}, to the appropriate value for this column.
     */
    public Column(Class<?> displayType, String columnName, Function<E, Object> mapper) {
        this.displayType = displayType;
        this.columnName = columnName;
        this.mapper = mapper;
    }

    /**
     * The title of this column
     *
     * @return columnName
     */
    public String getColumnName() {
        return columnName;
    }

    /**
     * The type of data in rows for this column
     *
     * @return dataType for this column
     */
    public Class<?> getDisplayType() {
        return displayType;
    }

    /**
     * The data that should be displayed off E.
     *
     * @param fullRowData
     * @return data transformed to the current row
     */
    public Object getColumnData(E fullRowData) {
        return mapper.apply(fullRowData);
    }
}
