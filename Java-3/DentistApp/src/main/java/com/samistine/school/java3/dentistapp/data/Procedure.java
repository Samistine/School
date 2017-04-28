package com.samistine.school.java3.dentistapp.data;

/**
 * Represents a procedure.
 *
 * @author Samuel Seidel
 */
public interface Procedure {

    /**
     * The unique code given to this procedure.
     *
     * @return procCode
     */
    String getCode();

    /**
     * The name given to this procedure.
     *
     * @return name
     */
    String getName();

    /**
     * The description given to this procedure.
     *
     * @return description
     */
    String getDescription();

    /**
     * The cost of this procedure.
     *
     * @return cost
     */
    double getCost();

}
