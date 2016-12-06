package com.samistine.school.java2.project.gui;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

/**
 * A utility class to allow for easy usage of a JTable.
 * This class handles all work for you, all you need to do
 * is create a new instance, then get a copy of the JTable {@link #toJScollableJTable() }.
 * Updating data in the data can be done using the following methods
 * <ul>
 * <li>Clear all rows: {@link #clear() }</li>
 * <li>Add new row: {@link #add(java.lang.Object) }</li>
 * </ul>
 *
 * @author Samuel Seidel
 * @param <E> The Java objects representing data in this table.
 */
public class TableData<E> extends AbstractTableModel {

    final Column columns[];
    final List<E> rows;
    final Optional<Comparator> comparator;

    /**
     * Create a new TableData.
     * <br>Convenience constructor
     *
     * @param columns the columns of the table.
     */
    public TableData(Column[] columns) {
        this(columns, new ArrayList<>(), null);
    }

    /**
     * Create a new TableData.
     * <br>Convenience constructor
     *
     * @param columns the columns of the table.
     * @param comparator an optional comparator for sorting.
     */
    public TableData(Column[] columns, Comparator comparator) {
        this(columns, new ArrayList<>(), comparator);
    }

    /**
     * Create a new TableData.
     * <br>Convenience constructor
     *
     * @param columns the columns of the table.
     * @param rows the data representing rows in this table.
     * @see #TableData(com.samistine.school.java2.unit03.Column[], java.util.Collection, java.util.Comparator)
     */
    public TableData(Column[] columns, Collection<E> rows) {
        this(columns, rows, null);
    }

    /**
     * Create a new TableData.
     * <p>
     * If you provide a comparator then the <code>rows</code> will be sorted in the construction and insertion of new data rows
     *
     * @param rows the data representing rows in this table.
     * @param columns the columns of the table.
     * @param comparator an optional comparator for sorting.
     */
    public TableData(Column[] columns, Collection<E> rows, Comparator comparator) {
        this.columns = columns;
        this.rows = new ArrayList<>(rows);
        this.comparator = Optional.ofNullable(comparator);
        this.comparator.ifPresent(this.rows::sort);
    }

    @Override
    public int getRowCount() {
        return rows.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columns[columnIndex].getColumnName();
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return columns[columnIndex].getDisplayType();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        E fullRowData = rows.get(rowIndex);
        Column column = columns[columnIndex];
        return column.getColumnData(fullRowData);
    }

    /**
     * Add a data row to the table.
     *
     * @param row row to insert
     */
    public void add(E row) {
        /* Add the new row to rows */
        rows.add(row);

        /* sort rows if comparator is present */
        comparator.ifPresent(rows::sort);

        /* notify something(idk what) that the table data has changed */
        fireTableDataChanged();
    }

    /**
     * Add a data row to the table.
     * <br>
     * Convenience method
     *
     * @param row row to insert
     * @see #add(java.lang.Object)
     */
    public void add(E... row) {
        for (E object : row) {
            this.add(object);
        }
    }
    
    /**
     * Add a data row to the table.
     * <br>
     * Convenience method
     *
     * @param row row to insert
     * @see #add(java.lang.Object)
     */
    public void add(Collection<E> row) {
        for (E object : row) {
            this.add(object);
        }
    }

    /**
     * Clear all data rows from the table.
     */
    public void clear() {
        /* Clear rows */
        rows.clear();

        /* notify something(idk what) that the table data has changed */
        fireTableDataChanged();
    }

    /**
     * Create a JTable wrapped in a JScrollPane.
     *
     * @return jScrollableJTable
     */
    public JScrollPane toJScollableJTable() {
        /* create a new JTable using this TabelModel */
        return new JScrollPane(new JTable(this));
    }
}
