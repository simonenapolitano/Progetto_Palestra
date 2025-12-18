package database;

import java.sql.*;


public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/gym_app";
    private static final String USER = "root";
    private static final String DB_PASSWORD = "C1L46$_.@$43SLlbc4$_-.-_-?!?";
    public static boolean passwordCheck(String username, String password){
        String sql = "SELECT * FROM users WHERE username = ? AND password_hash = SHA2(?, 256)";
        try(Connection conn = DriverManager.getConnection(URL, USER, DB_PASSWORD); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    
}
