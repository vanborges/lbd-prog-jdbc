package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ConnectionFactory;
import model.bean.Departamento;

public class DepartamentoDAO {
    
    private Connection conn = null;
    
    private final String sqlinsert = "INSERT INTO departamento (dnome, dnumero) VALUES (?, ?);";
    private final String sqlselectbyid = "SELECT dnome, dnumero FROM departamento WHERE dnumero=?;";


    public DepartamentoDAO() {
        conn = ConnectionFactory.getConnection();
    }

    public boolean insert(Departamento d){   
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sqlinsert);
            ps.setString(1, d.getDnome());
            ps.setInt(2, d.getDnumero());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro "+ex);
        } finally {
            ConnectionFactory.closeConnection(conn, ps);
        }
        return false;
    }

    public ArrayList<Departamento> selectbyid(int id){
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sqlselectbyid);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            ArrayList<Departamento>  ld = new ArrayList<Departamento>();
            while(rs.next()) {
                Departamento d = new Departamento();
                d.setDnome(rs.getString(1));
                d.setDnumero(rs.getInt(2));
                ld.add(d);
            }
            return ld;
        } catch (SQLException ex) {
            System.err.println("Departamento Erro "+ex);
        } finally {
            ConnectionFactory.closeConnection(conn, ps);
        }
        return null;
    }
}
