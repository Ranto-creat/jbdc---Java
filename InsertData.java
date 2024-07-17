package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertData {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost/villes"; // URL de connexion à la base de données
        String user = "postgres"; // Utilisateur de la base de données
        String password = "dangerous"; // Mot de passe de la base de données

        String name = "Exemple";
        String country = "Exemplaire";
        int population = 8000000;

        try {
            // Établir la connexion à la base de données
            Connection conn = DriverManager.getConnection(url, user, password);

            // Préparer la requête SQL d'insertion
            String sql = "INSERT INTO city (name, country, population) VALUES (?, ?, ?)";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, country);
            stmt.setInt(3, population);

            // Exécuter la requête d'insertion
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Nouvelle ville insérée avec succès !");
            } else {
                System.out.println("Échec de l'insertion de la nouvelle ville !");
            }

            // Fermer les ressources
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}