package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertData {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost/villes";
        String user = "postgres";
        String password = "dangerous"; // your password

        String name = "Antananarivo";
        String country = "Madagascar";
        int population = 8000000;

        try {
            
            Connection conn = DriverManager.getConnection(url, user, password);

            
            String sql = "INSERT INTO city (name, country, population) VALUES (?, ?, ?)";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, country);
            stmt.setInt(3, population);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Nouvelle ville insérée avec succès !");
            } else {
                System.out.println("Échec de l'insertion de la nouvelle ville !");
            }

            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}