/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Cl_conexion;
import entidades.Cl_multa;
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

    public Cl_multa getMultaByRut(String rut) {
        try {
            String sql = "SELECT * FROM MULTAS WHERE rut = ?;";
            PreparedStatement pstm = conexion.prepareCall(sql);
            pstm.setString(1, rut);
            ResultSet rs = pstm.executeQuery();
            Cl_multa multa = new Cl_multa();
            while (rs.next()) {
                multa.setId(rs.getInt("id"));
                multa.setRut(rs.getString("rut"));
                multa.setDesc(rs.getString("descripcion"));
                multa.setEs_invalidante(rs.getString("es_invalidante"));
            }
            return multa;
        } catch (Exception e) {
            System.out.println("error getmultabyid: " + e.getMessage());
            return null;
        }
    }

    public ArrayList<Cl_multa> Listar(String rut) {
        try {
            ArrayList<Cl_multa> lista_multas;
            lista_multas = new ArrayList<Cl_multa>();
            String sql = "SELECT * FROM MULTAS WHERE RUT = ?;";
            PreparedStatement pstm = conexion.prepareCall(sql);
            pstm.setString(1, rut);
            ResultSet rs = pstm.executeQuery();
            Cl_multa multa = new Cl_multa();
            while (rs.next()) {
                multa.setId(rs.getInt("id"));
                multa.setRut(rs.getString("rut"));
                multa.setDesc(rs.getString("descripcion"));
                multa.setEs_invalidante(rs.getString("es_invalidante"));
                lista_multas.add(multa);
            }
            return lista_multas;
        } catch (Exception e) {
            System.out.println("Error listar multas: " + e.getMessage());
            return null;
        }
    }

}
