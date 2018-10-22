
package ws;

import dao.AeronaveDAO;
import dao.LicenciaDAO;
import dao.MultaDAO;
import entidades.Cl_aeronave;
import entidades.Cl_licencia;
import entidades.Cl_multa;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Basti
 */
@WebService(serviceName = "webservice_dgac")
public class webservice_dgac {

    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "MultasByRut")
    public List<Cl_multa> MultasByRut(@WebParam(name = "rut") String rut) {
        List<Cl_multa> lista = new ArrayList<Cl_multa>();
        MultaDAO mDAO = new MultaDAO();
        try {
            lista = mDAO.Listar(rut);
        } catch (Exception ex) {
            System.out.println("error: " + ex);
        }
        return lista;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "LicenciasByRut")
    public List<Cl_licencia> LicenciasByRut(@WebParam(name = "rut") String rut) {
        List<Cl_licencia> lista = new ArrayList<Cl_licencia>();
        LicenciaDAO mDAO = new LicenciaDAO();
        try {
            lista = mDAO.Listar(rut);
        } catch (Exception ex) {
            System.out.println("error: " + ex);
        }
        return lista;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "AeronaveByPatente")
    public List<Cl_aeronave> AeronaveByPatente(@WebParam(name = "patente") String patente) {
        List<Cl_aeronave> lista = new ArrayList<Cl_aeronave>();
        AeronaveDAO mDAO = new AeronaveDAO();
        Cl_aeronave aero = new Cl_aeronave();
        try {
            lista = mDAO.getAeronaveByPatente(patente);
        } catch (Exception ex) {
            System.out.println("error: " + ex);
        }
        return lista;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "AeronavesByFecha")
    public List<Cl_aeronave> AeronavesByFecha(@WebParam(name = "fecha") String fecha) {
        List<Cl_aeronave> lista = new ArrayList<Cl_aeronave>();
        AeronaveDAO mDAO = new AeronaveDAO();
        try {
            lista = mDAO.Listar(fecha);
        } catch (Exception ex) {
            System.out.println("error: " + ex);
        }
        return lista;
    }

    
    @WebMethod(operationName = "AeronavesListar")
    public List<Cl_aeronave> AeronavesListar() {
        List<Cl_aeronave> lista = new ArrayList<Cl_aeronave>();
        AeronaveDAO mDAO = new AeronaveDAO();
        try {
            lista = mDAO.AeronavesListar();
        } catch (Exception ex) {
            System.out.println("error: " + ex);
        }
        return lista;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "validarMultasbyRut")
    public Boolean validarMultasbyRut(@WebParam(name = "rut") String rut) {
        MultaDAO mDAO = new MultaDAO();
         boolean var=false;
       try {
            var = mDAO.validarMultasbyRut(rut);
        } catch (Exception ex) {
            System.out.println("error: " + ex);
        }
        return var;
       
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "validarAeronaveByPatente")
    public Boolean validarAeronaveByPatente(@WebParam(name = "patente") String patente) {
         AeronaveDAO aDAO = new AeronaveDAO();
         boolean var=false;
       try {
            var = aDAO.validarAeronavesByPatente(patente);
        } catch (Exception ex) {            
            System.out.println("error: " + ex);
        }
        return var;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "validarLicenciaAvion")
    public boolean validarLicenciaAvion(@WebParam(name = "rut") String rut) {
         LicenciaDAO lDAO = new LicenciaDAO();
         boolean var=false;
       try {
            var = lDAO.validarLicenciaAvion(rut);
        } catch (Exception ex) {            
            System.out.println("error: " + ex);
        }
        return var;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "validarLicenciaHeli")
    public boolean validarLicenciaHeli(@WebParam(name = "rut") String rut) {
        LicenciaDAO lDAO = new LicenciaDAO();
         boolean var=false;
       try {
            var = lDAO.validarLicenciaHeli(rut);
        } catch (Exception ex) {            
            System.out.println("error: " + ex);
        }
        return var;
    }

   

    /**
     * Web service operation
     */
    @WebMethod(operationName = "existeLicencia")
    public boolean existeLicencia(@WebParam(name = "nro_licencia") int nro_licencia) {
       LicenciaDAO lDAO = new LicenciaDAO();
         boolean var=false;
       try {
            var = lDAO.existeLicencia(nro_licencia);
        } catch (Exception ex) {            
            System.out.println("error: " + ex);
        }
        return var;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "fechaAeronavegabilidad_por_patente")
    public String fechaAeronavegabilidad_por_patente(@WebParam(name = "patente") String patente) {
           AeronaveDAO aDAO = new AeronaveDAO();
         String var="";
       try {
            var = aDAO.fechaAeronavegabilidad_aeronave(patente);
        } catch (Exception ex) {            
            System.out.println("error: " + ex);
        }
        return var;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "operation")
    public Boolean existeLicenciabYrut(@WebParam(name = "rut") String rut) {
        LicenciaDAO lDAO = new LicenciaDAO();
         boolean var=false;
       try {
            var = lDAO.existeLicenciabYrut(rut);
        } catch (Exception ex) {            
            System.out.println("error: " + ex);
        }
        return var;
    }
}
