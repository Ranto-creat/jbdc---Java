package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteData {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost/villes"; // URL de connexion à la base de données
        String user = "postgres"; // Utilisateur de la base de données
        String password = "dangerous"; // Mot de passe de la base de données

        int cityIdToDelete = 12; // ID de la ville à supprimer

        try {
            // Établir la connexion à la base de données
            Connection conn = DriverManager.getConnection(url, user, password);

            // Préparer la requête SQL de suppression
            String sql = "DELETE FROM city WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, cityIdToDelete);

            // Exécuter la requête de suppression
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("La ville avec l'ID " + cityIdToDelete + " a été supprimée avec succès !");
            } else {
                System.out.println("Aucune ville n'a été supprimée. Vérifiez l'ID de la ville !");
            }

            // Fermer les ressources
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}