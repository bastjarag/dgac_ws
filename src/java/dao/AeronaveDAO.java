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
import java.sql.Timestamp;
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

    public ArrayList<Cl_aeronave> getAeronaveByPatente(String patente) {
        ArrayList<Cl_aeronave> lista_aeros;
        lista_aeros = new ArrayList<Cl_aeronave>();
        try {
            String sql = "SELECT * FROM AERONAVES WHERE patente = ?;";
            PreparedStatement pstm = conexion.prepareCall(sql);
            pstm.setString(1, patente);
            ResultSet rs = pstm.executeQuery();
            Cl_aeronave aero = new Cl_aeronave();
            while (rs.next()) {
                aero.setPatente(rs.getString("patente"));
                aero.setFecha_aeronavegabilidad(rs.getDate("fecha_aeronavegabilidad"));
                lista_aeros.add(aero);
            }
            return lista_aeros;
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
            return lista_aeros;
        }
    }

    public ArrayList<Cl_aeronave> Listar(String fecha) {
        ArrayList<Cl_aeronave> lista_aeros;
        lista_aeros = new ArrayList<Cl_aeronave>();
        try {
            String sql = "SELECT * FROM AERONAVES WHERE fecha_aeronavegabilidad BETWEEN ? AND ?;";
            PreparedStatement pstm = conexion.prepareCall(sql);
            String var = fecha + " 00:00:00";
            String var2 = fecha + " 23:59:59";
            pstm.setString(1, var);
            pstm.setString(2, var2);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                Cl_aeronave aero = new Cl_aeronave();
                aero.setPatente(rs.getString("patente"));
                aero.setFecha_aeronavegabilidad(rs.getDate("fecha_aeronavegabilidad"));
                lista_aeros.add(aero);
            }
            return lista_aeros;
        } catch (Exception e) {
            System.out.println("Error listar: " + e.getMessage());
            return lista_aeros;
        }
    }

    public ArrayList<Cl_aeronave> AeronavesListar() {
        ArrayList<Cl_aeronave> lista_aeros;
        lista_aeros = new ArrayList<Cl_aeronave>();
        try {
            String sql = "SELECT * FROM AERONAVES;";
            PreparedStatement pstm = conexion.prepareCall(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Cl_aeronave aero = new Cl_aeronave();
                aero.setPatente(rs.getString("patente"));
                aero.setFecha_aeronavegabilidad(rs.getDate("fecha_aeronavegabilidad"));
                lista_aeros.add(aero);
            }
            return lista_aeros;
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
            return lista_aeros;
        }
    }

    public boolean validarAeronavesByPatente(String patente) {

        try {
            String sql = "SELECT * FROM AERONAVES WHERE PATENTE = ?;";
            PreparedStatement pstm = conexion.prepareCall(sql);
            pstm.setString(1, patente);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Cl_aeronave aero = new Cl_aeronave();
                aero.setPatente(rs.getString("patente"));
                aero.setFecha_aeronavegabilidad(rs.getDate("fecha_aeronavegabilidad"));
                return true;
            }
            return false;
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
            return false;
        }
    }

    public String fechaAeronavegabilidad_aeronave(String patente) {
       String formattedDate = "x";
         
        try {
            String sql = "SELECT fecha_aeronavegabilidad from aeronaves where patente = ?;";
            PreparedStatement pstm = conexion.prepareCall(sql);
            pstm.setString(1, patente);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Cl_aeronave aero = new Cl_aeronave();
                rs.getString("fecha_aeronavegabilidad");                
           formattedDate = rs.getString("fecha_aeronavegabilidad");                
            }
            
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
            return formattedDate;
        }     
        return formattedDate;
    }

}
