package com.samistine.school.java3.dentistapp.db;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Samuel
 */
public final class DBHandler {

    private static final Logger LOGGER = Logger.getLogger(DBHandler.class.getName());

    private static DBHandler INSTANCE = new DBHandler();

    private Connection conn;
    private DBHandler() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            /* often not required for Java 6 and later (JDBC 4.x) */
        } catch (ClassNotFoundException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }

        LOGGER.info(new File(".").getAbsolutePath());
        try {
            File file = createTempDBFile();
            LOGGER.info(file.toString());
            conn = DriverManager.getConnection("jdbc:ucanaccess://" + file.getAbsolutePath());
        } catch (SQLException | IOException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }

    public static Connection getConnection() {
        return INSTANCE.conn;
    }

    private File createTempDBFile() throws IOException {
        URL resource = getClass().getClassLoader().getResource("DentistOfficeMDB.mdb");
        File tempFile = File.createTempFile("DentistOfficeMDB", null);
        System.out.println(resource.getPath());
        Files.copy(resource.openStream(), tempFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        return tempFile;
    }

}
