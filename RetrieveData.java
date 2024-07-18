package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class RetrieveData {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost/villes"; 
        String user = "postgres";
        String password = "dangerous"; // your password

        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            Statement stmt = conn.createStatement();

            String sql = "SELECT * FROM city";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String country = rs.getString("country");
                int population = rs.getInt("population");
                System.out.println("ID: " + id + ", Name: " + name + ", Country: " + country + ", Population: " + population);
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}