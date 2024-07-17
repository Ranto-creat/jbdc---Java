package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class RetrieveData {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost/villes"; // URL de connexion à la base de données
        String user = "postgres"; // Utilisateur de la base de données
        String password = "dangerous"; // Mot de passe de la base de données

        try {
            // Établir la connexion à la base de données
            Connection conn = DriverManager.getConnection(url, user, password);

            // Créer une déclaration
            Statement stmt = conn.createStatement();

            // Exécuter la requête SQL
            String sql = "SELECT * FROM city";
            ResultSet rs = stmt.executeQuery(sql);

            // Parcourir les résultats et afficher les données
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String country = rs.getString("country");
                int population = rs.getInt("population");
                System.out.println("ID: " + id + ", Name: " + name + ", Country: " + country + ", Population: " + population);
            }

            // Fermer les ressources
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}