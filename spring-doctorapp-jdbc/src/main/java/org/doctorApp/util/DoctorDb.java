package org.doctorApp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DoctorDb {
    static Connection connection;
    public static Connection openConnection(){
        String url = "jdbc:mysql://localhost:3306/voyatraining";
        String username = "root";
        String password = "root";
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("connection to Data Base");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;

    }
}
