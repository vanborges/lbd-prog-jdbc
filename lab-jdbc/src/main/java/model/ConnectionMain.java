package model;

import model.bean.Departamento;

import java.sql.*;
import java.util.ArrayList;

public class ConnectionMain {
    private static final String URL="jdbc:postgresql://localhost:5432/pydb";
    private static final String USER="postgres";
    private static final String PASS="postgres";

    public static void main(String[] args) throws SQLException {
        String sqlselectbyid = "SELECT dnome, dnumero FROM empresaschema.departamento WHERE dnumero=?;";

        Connection conn = DriverManager.getConnection(URL, USER, PASS);
        System.out.println("Conectado");

        PreparedStatement ps = ps = conn.prepareStatement(sqlselectbyid);
        ps.setInt(1, 1);

        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            Departamento d = new Departamento();
            d.setDnome(rs.getString(1));
            d.setDnumero(rs.getInt(2));
            System.out.println(d.toString());
        }
        conn.close();
    }
}
