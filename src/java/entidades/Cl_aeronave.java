/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author Basti
 */
public class Cl_aeronave {

    private String patente;
    private Date fecha_aeronavegabilidad;
   

    public Cl_aeronave() {
    }

    public Cl_aeronave(String patente, Date fecha_aeronavegabilidad, Timestamp fecha_aeronavegabilidad_1) {
        this.patente = patente;
        this.fecha_aeronavegabilidad = fecha_aeronavegabilidad;        
    }        

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public Date getFecha_aeronavegabilidad() {
        return fecha_aeronavegabilidad;
    }

    public void setFecha_aeronavegabilidad(Date fecha_aeronavegabilidad) {
        this.fecha_aeronavegabilidad = fecha_aeronavegabilidad;
    }

    @Override
    public String toString() {
        return "Cl_aeronave{" + "patente=" + patente + ", fecha_aeronavegabilidad=" + fecha_aeronavegabilidad + '}';
    }

}
