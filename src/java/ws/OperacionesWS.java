/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import entidades.Cl_aeronave;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Basti
 */
@WebService(serviceName = "OperacionesWS")
public class OperacionesWS {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getAeronave")
    public Cl_aeronave getAeronave(@WebParam(name = "patente") String patente) {
     Date fecha = new Date();

        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");

        try {
           fecha = df.parse("13-09-2018");
        } catch (Exception ex) {
            //pendiente
        }
        
        return new Cl_aeronave(patente, fecha);

    }

    
}
