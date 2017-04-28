package com.samistine.school.java3.dentistapp.db.data;

import com.samistine.school.java3.dentistapp.data.Procedure;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Samuel Seidel
 */
public final class SQLProcedure implements Procedure {

    private final String code, name, description;
    private final double cost;

    public SQLProcedure(ResultSet rs) throws SQLException {
        this.code = rs.getString("procCode");
        this.name = rs.getString("procName");
        this.description = rs.getString("procDesc");
        this.cost = rs.getDouble("cost");
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double getCost() {
        return cost;
    }

}
