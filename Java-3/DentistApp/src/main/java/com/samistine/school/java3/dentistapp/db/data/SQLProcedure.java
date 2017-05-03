package com.samistine.school.java3.dentistapp.db.data;

import com.samistine.school.java3.dentistapp.data.Procedure;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.code);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Procedure)) return false;

        final Procedure other = (Procedure) obj;
        return Objects.equals(this.code, other.getCode());
    }

}
