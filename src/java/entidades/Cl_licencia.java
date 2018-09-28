/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Basti
 */
public class Cl_licencia {
    
   private int id;
    private String rut;
    private int nro_licencia;
    private String tipo_aeronave;

    public Cl_licencia() {
    }

    public Cl_licencia(int id, String rut, int nro_licencia, String tipo_aeronave) {
        this.id = id;
        this.rut = rut;
        this.nro_licencia = nro_licencia;
        this.tipo_aeronave = tipo_aeronave;
    }   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }  
    
    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }
  
    public int getNro_licencia() {
        return nro_licencia;
    }

    public void setNro_licencia(int nro_licencia) {
      if(nro_licencia>1){
        this.nro_licencia = nro_licencia;
        } else {
        throw new IllegalArgumentException("codigo menor a largo 1");
        }
        
    }

    public String getTipo_aeronave() {
        return tipo_aeronave;
    }

    public void setTipo_aeronave(String tipo_aeronave) {
        this.tipo_aeronave = tipo_aeronave;
    }

    @Override
    public String toString() {
        return "Cl_licencia{" + "id=" + id + ", rut=" + rut + ", nro_licencia=" + nro_licencia + ", tipo_aeronave=" + tipo_aeronave + '}';
    }
     
}
