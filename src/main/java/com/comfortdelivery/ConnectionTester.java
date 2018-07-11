package com.comfortdelivery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;

public class ConnectionTester {
    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {

            System.out.println("Where is your MySQL JDBC Driver?");
            e.printStackTrace();
            return;

        }

        System.out.println("MySQL JDBC Driver Registered!");

        Connection connection = null;

        try {
            System.out.println(Locale.getDefault());
            //Locale.setDefault(Locale.ENGLISH);

            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/ComfortDelivery?useLegacyDatetimeCode=false&serverTimezone=GMT", "ComfortDelivery", "12345123");

        } catch (SQLException e) {

            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;

        }

        if (connection != null) {
            System.out.println("You made it, take control your database now!");
        } else {
            System.out.println("Failed to make connection!");
        }
    }
}

