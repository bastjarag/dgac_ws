/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Cl_conexion;
import entidades.Cl_aeronave;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Basti
 */
public class AeronaveDAO {

    private Connection conexion;

    public AeronaveDAO() {
        conexion = new Cl_conexion().getConexion();
    }

    public Cl_aeronave getAeronaveByPatente(String patente) {
        try {
            String sql = "SELECT * FROM AERONAVES WHERE patente = ?;";
            PreparedStatement pstm = conexion.prepareCall(sql);
            pstm.setString(1, patente);
            ResultSet rs = pstm.executeQuery();
            Cl_aeronave aero = new Cl_aeronave();
            while (rs.next()) {
                aero.setPatente(rs.getString("patente"));
                aero.setFecha_aeronavegabilidad(rs.getDate("fecha_aeronavegabilidad"));
            }
            return aero;
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
            return null;
        }
    }
    
     public ArrayList<Cl_aeronave> Listar(String pat) {
        try {
            ArrayList<Cl_aeronave> lista_aeros;
            lista_aeros = new ArrayList<Cl_aeronave>();
            String sql = "SELECT * FROM AERONAVES WHERE PATENTE = ?;";
            PreparedStatement pstm = conexion.prepareCall(sql);
            pstm.setString(1, pat);
            ResultSet rs = pstm.executeQuery();
            Cl_aeronave aero = new Cl_aeronave();
            while (rs.next()) {                
                aero.setPatente(rs.getString("patente"));
                aero.setFecha_aeronavegabilidad(rs.getDate("fecha_aeronavegabilidad"));
                
                lista_aeros.add(aero);
            }
            return lista_aeros;
        } catch (Exception e) {
            System.out.println("Error listar aeronaves: " + e.getMessage());
            return null;
        }
    }
}


