package org.example;

import java.sql.*;

public class AccountManagement {

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost/account_db", "postgres", "dangerous")) {
            // Insertion de 2 comptes
            insertAccount(conn, 16, 220);
            insertAccount(conn, 15, 190);

            // Modification du solde des comptes
            updateAccountBalance(conn, 1, 140);
            updateAccountBalance(conn, 2, 280);

            // Affichage des comptes après modification
            displayAccounts(conn);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertAccount(Connection conn, int id, int solde) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO account (id, solde) VALUES (?, ?)")) {
            stmt.setInt(1, id);
            stmt.setInt(2, solde);
            stmt.executeUpdate();
        }
    }

    private static void updateAccountBalance(Connection conn, int id, int newSolde) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement("UPDATE account SET solde = ? WHERE id = ?")) {
            stmt.setInt(1, newSolde);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        }
    }

    private static void displayAccounts(Connection conn) throws SQLException {
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery("SELECT * FROM account")) {
            System.out.println("Liste des comptes :");
            while (rs.next()) {
                int id = rs.getInt("id");
                int solde = rs.getInt("solde");
                System.out.println("ID: " + id + ", Solde: " + solde);
            }
        }
    }
}