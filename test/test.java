
import conexion.Cl_conexion;
import dao.AeronaveDAO;
import dao.MultaDAO;
import entidades.Cl_aeronave;
import entidades.Cl_licencia;
import entidades.Cl_multa;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Basti
 */
public class test {

    public static void main(String[] args) throws ParseException {

        Cl_licencia li1 = new Cl_licencia(1, "19516416-9", 13232, "Helicoptero");
        Cl_licencia li2 = new Cl_licencia(2, "16544449-3", 2222, "Avion");

        DateFormat df = new SimpleDateFormat("dd/MM/yy");
        Date dateobj = new Date();
        Date dateobj2 = new SimpleDateFormat("dd/MM/yyyy").parse("20/08/1996");

        Cl_aeronave a1 = new Cl_aeronave("CC-WBS", dateobj);
        Cl_aeronave a2 = new Cl_aeronave("DD-ABC", dateobj2);

        Cl_multa mu1 = new Cl_multa(1, "19516416-9", "Multa por guapo", "No");
        Cl_multa mu2 = new Cl_multa(2, "16544449-3", "Multa por velocidad", "Si");

        //pruebas tostring   
        System.out.println("******Aeronaves*******");
        System.out.println("a1:" + a1.toString());
        System.out.println("a2:" + a2.toString());

        System.out.println("****Licencias*******");
        System.out.println("li1: " + li1.toString());
        System.out.println("li2: " + li2.toString());

        System.out.println("***Multas**********");
        System.out.println("mu1: " + mu1);
        System.out.println("mu2: " + mu2);

        System.out.println("*********D************");   
        MultaDAO mDAO = new MultaDAO();
        System.out.println("DAO multas/getmultabyrut");
        Cl_multa m1 = mDAO.getMultaByRut("19516416-9");
        System.out.println(m1);

        System.out.println("*****Listar todas las multas de un rut:****");
        try {
            List<Cl_multa> listaMultas = mDAO.Listar("16544449-3");
            for (Cl_multa m : listaMultas) {
                System.out.println(m.getId());
                System.out.println(m.getRut());
                System.out.println(m.getDesc());
                System.out.println(m.getEs_invalidante());
                System.out.println("************");
            }
        } catch (Exception ex) {
            System.out.println("error listar main: " + ex);
        }
        System.out.println("****fin listar todas multas****");

       
        
        System.out.println("****getAeronaveByPatente*****");
        AeronaveDAO aDAO = new AeronaveDAO();
        Cl_aeronave aero1 = aDAO.getAeronaveByPatente("CC-WBS");
        System.out.println(""+aero1);
        
        
        
        
        
        
//fin 
    }
}
