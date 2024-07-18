package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteData {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost/villes";
        String user = "postgres";
        String password = "dangerous"; // your password

        int cityIdToDelete = 12;

        try {
            
            Connection conn = DriverManager.getConnection(url, user, password);

            
            String sql = "DELETE FROM city WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, cityIdToDelete);

            
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("La ville avec l'ID " + cityIdToDelete + " a été supprimée avec succès !");
            } else {
                System.out.println("Aucune ville n'a été supprimée. Vérifiez l'ID de la ville !");
            }

          
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}