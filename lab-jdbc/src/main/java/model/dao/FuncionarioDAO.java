package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ConnectionFactory;
import model.bean.Departamento;
import model.bean.Funcionario;

/**
 * @author Vanessa Borges
 */
public class FuncionarioDAO {
    
    private Connection conn = null;
    
    private final String sqlinsert = "INSERT INTO funcionario (pnome, minicial, unome, cpf, endereco, sexo, salario, cpf_supervisor, dnr) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private final String sqldeletebyid = "DELETE FROM funcionario WHERE cpf = ?";
    private final String sqlselectbyid = "SELECT pnome, minicial, unome, cpf, endereco, sexo, salario, cpf_supervisor, dnr FROM funcionario WHERE cpf=?";
    
    public FuncionarioDAO() {
        conn = ConnectionFactory.getConnection();
    }
    
    public boolean insert(Funcionario f){   
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sqlinsert);
            ps.setString(1, f.getPnome());
            ps.setString(2, f.getMinicial());
            ps.setString(3, f.getUnome());
            ps.setString(4, f.getCpf());
            ps.setString(5, f.getEndereco());
            ps.setString(6, f.getSexo());
            ps.setDouble(7, f.getSalario());
            ps.setString(8, f.getCpf_supervisor());
            ps.setInt(9, f.getDnr().getDnumero());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro "+ex);
        } finally {
            ConnectionFactory.closeConnection(conn, ps);
        }
        return false;
    }
    
    public boolean delete(Funcionario f){
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sqldeletebyid);
            ps.setString(1, f.getCpf());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro "+ex);
        } finally {
            ConnectionFactory.closeConnection(conn, ps);
        }
        return false;   
    }
    
    public List<Funcionario> selectbyid(int id){
        PreparedStatement ps = null;
        ArrayList<Funcionario> lf = new ArrayList<Funcionario>();
        try {
            ps = conn.prepareStatement(sqlselectbyid);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Funcionario f = new Funcionario();
                f.setPnome(rs.getString(1));
                f.setMinicial(rs.getString(2));
                f.setUnome(rs.getString(3));
                f.setCpf(rs.getString(4));
                f.setEndereco(rs.getString(5));
                f.setSexo(rs.getString(6));
                f.setSalario(rs.getFloat(7));
                f.setCpf_supervisor(rs.getString(8));
                
                Departamento d = new Departamento();
                d.setDnumero(rs.getInt(9));
                f.setDnr(d);
                
                lf.add(f);
            }
            return lf;
        } catch (SQLException ex) {
            System.err.println("Erro "+ex);
        } finally {
            ConnectionFactory.closeConnection(conn, ps);
        }
        return null;
    }
}
