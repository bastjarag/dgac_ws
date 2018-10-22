
import conexion.Cl_conexion;
import dao.AeronaveDAO;
import dao.LicenciaDAO;
import dao.MultaDAO;
import entidades.Cl_aeronave;
import entidades.Cl_licencia;
import entidades.Cl_multa;
import java.sql.Timestamp;
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

        //Cl_aeronave a1 = new Cl_aeronave("CC-WBS", dateobj);
        //Cl_aeronave a2 = new Cl_aeronave("DD-ABC", dateobj2);

        Cl_multa mu1 = new Cl_multa(1, "19516416-9", "Multa por guapo", "No");
        Cl_multa mu2 = new Cl_multa(2, "16544449-3", "Multa por velocidad", "Si");

        //pruebas tostring   
        //System.out.println("******Aeronaves*******");
        //System.out.println("a1:" + a1.toString());
        //System.out.println("a2:" + a2.toString());

        System.out.println("****Licencias*******");
        System.out.println("li1: " + li1.toString());
        System.out.println("li2: " + li2.toString());

        System.out.println("***Multas**********");
        System.out.println("mu1: " + mu1);
        System.out.println("mu2: " + mu2);

      
        MultaDAO mDAO = new MultaDAO();       
        System.out.println("*****Listar todas las multas de un rut:****");
        try {
            List<Cl_multa> listaMultas = mDAO.Listar("16544449-3");
            for (Cl_multa m : listaMultas) {
                System.out.println(m.getId());
                System.out.println(m.getRut());
                System.out.println(m.getDesc());
                System.out.println(m.getEs_invalidante()); 
                
            }
        } catch (Exception ex) {
            System.out.println("error listar: " + ex);
        }
        System.out.println("****fin listar todas multas****");       
        
      
        
          System.out.println("*****Listar licencias de un rut:****");
          LicenciaDAO lDAO = new LicenciaDAO();
        try {
            List<Cl_licencia> lista = lDAO.Listar("19516416-9");
            for (Cl_licencia m : lista) {
                System.out.println(""+m);             
            }
        } catch (Exception ex) {
            System.out.println("error listar: " + ex);
        }
        System.out.println("****fin listar todas licencias****"); 
        
          
          System.out.println("*****Listar aeronaves por fecha aeronavegabliidad:****");
          AeronaveDAO aeDAO = new AeronaveDAO();
        try {
            List<Cl_aeronave> listaAero = aeDAO.Listar("2018-09-25");
            for (Cl_aeronave m : listaAero) {
                System.out.println(""+m);             
            }
        } catch (Exception ex) {
            System.out.println("error listar: " + ex);
        }
        System.out.println("****fin listar aeronaves****"); 
        
        System.out.println("**********Prueba");
       /*
        try {
            String y = "CC-IIII";
            //Timestamp x = aeDAO.fechaAeronavegabilidad_aeronave(y);
            //System.out.println("La fecha de aeronavegabilidad de la aeronave condsw patente "+y+" es: "+x);
        } catch (Exception ex) {
            System.out.println("error listar: " + ex);
        }
        */
        System.out.println("**********Prueba fecha aero x patente");
       
        try {
            String xy = "CC-WBS";
            String x = aeDAO.fechaAeronavegabilidad_aeronave(xy);
            System.out.println("La fecha de aeronavegabilidad de la aeronave con patente "+xy+" es: "+x);
        } catch (Exception ex) {
            System.out.println("error listar: " + ex);
        }
        
        
        
        
        
        
        
        
        
        
//fin 
    }
}
