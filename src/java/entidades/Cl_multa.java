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
public class Cl_multa {
    
    private int id;
    private String rut;  
    private String desc, es_invalidante;

    public Cl_multa() {
    }

    public Cl_multa(int id, String rut, String desc, String es_invalidante) {
        this.id = id;
        this.rut = rut;
        this.desc = desc;
        this.es_invalidante = es_invalidante;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getEs_invalidante() {
        return es_invalidante;
    }

    public void setEs_invalidante(String es_invalidante) {
        this.es_invalidante = es_invalidante;
    }

    @Override
    public String toString() {
        return "Cl_multa{" + "id=" + id + ", rut=" + rut + ", desc=" + desc + ", es_invalidante=" + es_invalidante + '}';
    }

    
    
    
    
    

 
    
    
    
    
    
    
}
