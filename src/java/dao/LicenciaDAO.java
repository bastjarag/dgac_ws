/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Cl_conexion;
import entidades.Cl_licencia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Basti
 */
public class LicenciaDAO {
    
    private Connection conexion;

    public LicenciaDAO() {
    conexion = new Cl_conexion().getConexion();
      
    }
    
    public Cl_licencia getLicenciaByRut (String rut){
    try {
            String sql = "SELECT * FROM LICENCIAS WHERE rut = ?;";
            PreparedStatement pstm = conexion.prepareCall(sql);
            pstm.setString(1, rut);
            ResultSet rs = pstm.executeQuery();
           Cl_licencia lic = new Cl_licencia();
            while (rs.next()) {
                lic.setId(rs.getInt("id"));
                lic.setRut(rs.getString("rut"));
                lic.setNro_licencia(rs.getInt("nro_licencia"));
                lic.setTipo_aeronave(rs.getString("tipo_aeronave"));

            }
            return lic;
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
            return null;
        }
    }
    
    public ArrayList<Cl_licencia> Listar(String rut) {
        try {
            ArrayList<Cl_licencia> lista;
            lista = new ArrayList<Cl_licencia>();
            String sql = "SELECT * FROM LICENCIAS WHERE RUT = ?;";
            PreparedStatement pstm = conexion.prepareCall(sql);
            pstm.setString(1, rut);
            ResultSet rs = pstm.executeQuery();
            Cl_licencia l = new Cl_licencia();
            while (rs.next()) {                
                l.setId(rs.getInt("id"));
                l.setNro_licencia(rs.getInt("nro_licencia"));
                l.setRut(rs.getString("rut"));
                l.setTipo_aeronave(rs.getString("tipo_aeronave"));
               // aero.setFecha_aeronavegabilidad(rs.getDate("fecha_aeronavegabilidad"));                
                lista.add(l);
            }
            return lista;
        } catch (Exception e) {
            System.out.println("Error listar aeronaves: " + e.getMessage());
            return null;
        }
    }
    
    
    
}
