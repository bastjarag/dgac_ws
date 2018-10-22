/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Cl_conexion;
import entidades.Cl_multa;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Basti
 */
public class MultaDAO {

    private Connection conexion;

    public MultaDAO() {
        conexion = new Cl_conexion().getConexion();
    }   

    public ArrayList<Cl_multa> Listar(String rut) {
        ArrayList<Cl_multa> lista_multas;
        lista_multas = new ArrayList<Cl_multa>();
        String sql = "SELECT * FROM MULTAS WHERE RUT = ?;";
        try {
            PreparedStatement pstm = conexion.prepareCall(sql);
            pstm.setString(1, rut);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                Cl_multa multa = new Cl_multa();
                multa.setId(rs.getInt("id"));
                multa.setRut(rs.getString("rut"));
                multa.setDesc(rs.getString("descripcion"));
                multa.setEs_invalidante(rs.getString("es_invalidante"));
                lista_multas.add(multa);
            }
            return lista_multas;
        } catch (Exception e) {
            System.out.println("Error listar multas: " + e.getMessage());
            return lista_multas;
        }
    }
    
    public boolean validarMultasbyRut(String rut){
    ArrayList<Cl_multa> lista_multas;
        lista_multas = new ArrayList<Cl_multa>();
        String sql = "SELECT es_invalidante FROM `MULTAS` WHERE RUT = ? and ES_INVALIDANTE = 'Si';";
        try {
            PreparedStatement pstm = conexion.prepareCall(sql);
            pstm.setString(1, rut);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                Cl_multa multa = new Cl_multa();
                
                multa.setEs_invalidante(rs.getString("es_invalidante")); 
             return true;
            }
           return false;
        } catch (Exception e) {
            System.out.println("Error listar multas: " + e.getMessage());
            return false;
        }
    }
}
