package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {
    
    private static final String URL="jdbc:postgresql://localhost:5432/pydb";
    private static final String USER="postgres";
    private static final String PASS="postgres";

    public static Connection getConnection(){
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Conexão realizada com sucesso");
            return conn;
        } catch (SQLException e) {
            throw new RuntimeException("Erro na conexão", e);
        } 
    }
    public static void closeConnection(Connection conn){
        if (conn != null){
            try {
                conn.close();
            } catch (SQLException ex) {
                System.err.println("Erro "+ ex);
            }
        }
    }
    public static void closeConnection(Connection conn, PreparedStatement ps){
        if (ps != null){
            try {
                ps.close();
            } catch (SQLException ex) {
               System.err.println("Error "+ex);
            }
        }
        closeConnection(conn);
    }
    public static void closeConnection(Connection conn, PreparedStatement ps, ResultSet rs){
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException ex) {
               System.err.println("Error "+ex);
            }
        }
        closeConnection(conn, ps);
    }

}
