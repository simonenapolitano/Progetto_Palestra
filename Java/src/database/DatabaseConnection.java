package database;

import java.sql.*;


public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/gym_app";
    private static final String USER = "root";
    private static final String DB_PASSWORD = "C1L46$_.@$43SLlbc4$_-.-_-?!?";
    public static boolean login(String email, String password){
        String sql = "SELECT * FROM users WHERE username = ? AND password_hash = SHA2(?, 256)";
        try(Connection conn = DriverManager.getConnection(URL, USER, DB_PASSWORD); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    public static boolean register(String email, String password) {
        String checkSql = "SELECT id FROM users WHERE username = ?";
        String insertSql = "INSERT INTO users (username, password_hash, role) VALUES (?, SHA2(?, 256), ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, DB_PASSWORD)) {

            // 🔍 Controllo esistenza utente
            try (PreparedStatement checkStmt = conn.prepareStatement(checkSql)) {
                checkStmt.setString(1, email);
                ResultSet rs = checkStmt.executeQuery();

                if (rs.next()) {
                    System.out.println("User already exists");
                    return false;
                }
            }

            // 📝 Inserimento nuovo utente
            try (PreparedStatement insertStmt = conn.prepareStatement(insertSql)) {
                insertStmt.setString(1, email);
                insertStmt.setString(2, password);
                insertStmt.setString(3, "USER");

                insertStmt.executeUpdate();
                System.out.println("User registered successfully");
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
