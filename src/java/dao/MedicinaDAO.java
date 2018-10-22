package dao;

import conexion.Cl_conexion;
import entidades.Cl_medicina;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MedicinaDAO {

    private Connection conexion;

    public MedicinaDAO() {
        conexion = new Cl_conexion().getConexion();
    }

    public String fechaVctoByRut(String rut) {
        String formattedDate = "x";

        try {
            String sql = "SELECT fecha_vcto from medicinas where rut = ?;";
            PreparedStatement pstm = conexion.prepareCall(sql);
            pstm.setString(1, rut);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Cl_medicina aero = new Cl_medicina();
                rs.getString("fecha_vcto");
                formattedDate = rs.getString("fecha_vcto");
            }
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
            return formattedDate;
        }
        return formattedDate;
    }

}
