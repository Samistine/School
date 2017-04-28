package com.samistine.school.java3.dentistapp.data.users;

/**
 * Generic User class which {@link Patient} and {@link Dentist} extend.
 *
 * @author Samuel Seidel
 */
public interface User {

    /**
     * Get the unique ID of the user.
     *
     * @return id
     */
    String getId();

    /**
     * Get the password of the user.
     *
     * @return password
     */
    String getPassword();

    /**
     * Get the user's first name.
     *
     * @return fName
     */
    String getFirstName();

    /**
     * Get the user's last name
     *
     * @return lName
     */
    String getLastName();

    /**
     * Get the user's email
     *
     * @return email
     */
    String getEmail();

}
