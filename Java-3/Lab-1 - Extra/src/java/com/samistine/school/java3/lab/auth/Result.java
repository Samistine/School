package com.samistine.school.java3.lab.auth;

import com.samistine.school.java3.lab.UserAccount;

/**
 *
 * @author Samuel
 */
public interface Result {

    /* Were we able to login? */
    boolean succeeded();
    
    boolean failed();

    /* The account associated with the login */
    UserAccount account();

}
