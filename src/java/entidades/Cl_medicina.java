
package entidades;

import java.util.Date;


public class Cl_medicina {
    
    private int id;
    private String desc;
    private Date fecha_vcto;

    public Cl_medicina(int id, String desc, Date fecha_vcto) {
        this.id = id;
        this.desc = desc;
        this.fecha_vcto = fecha_vcto;
    }

    public Cl_medicina() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getFecha_vcto() {
        return fecha_vcto;
    }

    public void setFecha_vcto(Date fecha_vcto) {
        this.fecha_vcto = fecha_vcto;
    }

    @Override
    public String toString() {
        return "Cl_medicina{" + "id=" + id + ", desc=" + desc + ", fecha_vcto=" + fecha_vcto + '}';
    }
    
    
    
}
