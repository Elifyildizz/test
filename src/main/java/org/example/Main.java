package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/denemeDB";
        String user = "root";
        String password = "root";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {

            // SELECT sorgusu ile verileri çekme
            String query = "SELECT * FROM denemeTable";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int userID = rs.getInt("userID");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                int phoneNo = rs.getInt("phoneNo");

                System.out.println("UserID: " + userID + ",\nName: " + name + ",\nSurname: " + surname + ",\nPhone No: " + phoneNo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

