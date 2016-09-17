package com.samistine.school.java2.unit03;

import java.util.List;
import java.util.function.Function;
import javax.swing.table.AbstractTableModel;

/**
 * Class: CIST 2372 Java II
 * Quarter: Fall 2016
 * Instructor: Dave Busse
 * Project: Unit03
 * Date: Created Sep 16, 2016 1:11:50 PM
 *
 * By turning in this code, I Pledge:
 * 1. That I have completed the programming assignment independently.
 * 2. I have not copied the code from a student or any source.
 * 3. I have not given my code to any student.
 *
 * @author Samuel Seidel <samuel@samistine.com>
 * @version 1.0
 */
public class StudentsTable extends AbstractTableModel {
//THIS CLASS IS NOT USED. NOT USED. PLEASE DON'T GRADE THIS
    static enum Column {
        SSN         (String.class, "SSN", Student::getSSN),
        FIRST_NAME  (String.class, "First Name", Student::getFirstName),
        LAST_NAME   (String.class, "Last Name", Student::getLastName),
        MAJOR       (String.class, "Major", Student::getMajor);

        final static int columns = Column.values().length;
        final int columnPos;
        final Class<?> displayType;
        final String columnName;
        final Function<Student, Object> mapper;

        private Column(Class<?> displayType, String columnName, Function<Student, Object> mapper) {
            this.columnPos = ordinal();//http://stackoverflow.com/questions/14319232/get-enum-name-from-enum-value
            this.displayType = displayType;
            this.columnName = columnName;
            this.mapper = mapper;
        }
        
        public int      getColumnPos  () {  return columnPos;    }
        public Class<?> getDisplayType() {  return displayType;  }
        public String   getColumnName () {  return columnName;   }
        public Object   getData(Student student) {   return mapper.apply(student);   };

        public static int columns() {
            return columns;
        }

        public static Column getColumn(int i) {
            return Column.values()[i];
        }

        public static String getColumnName(int i) {
            return Column.getColumn(i).getColumnName();
        }

        public static Object getData(Student student, int columnIndex) {
            Column column = Column.getColumn(columnIndex);
            return column.getData(student);
        }
    }

    List<Student> students;

    @Override
    public String getColumnName(int column) {
        return Column.getColumnName(column);
    }

    @Override
    public int getRowCount() {
        return students.size();
    }

    @Override
    public int getColumnCount() {
        return Column.values().length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Student student = students.get(rowIndex);
        return Column.getData(student, columnIndex);
    }
}
