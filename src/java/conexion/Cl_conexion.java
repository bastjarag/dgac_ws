package conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class Cl_conexion {
    
     
   // private Logger log = Logger.getLogger(Cl_Conexion.class);
    private static Connection conexion;
    private String servidor = "jdbc:mysql://localhost/bd_ws";
    private String usuario = "root";
    private String pass ="";

     public Cl_conexion() {
        try {
            if (conexion == null) {
                Class.forName("com.mysql.jdbc.Driver");
                conexion = DriverManager.getConnection(servidor, usuario, pass);
            }
        } catch (Exception e) {
            //log.warn("Error al conectar la bd: " + e.getMessage());
            System.out.println("Error en conexion: " + e.getMessage());
        }
    }

    public Connection getConexion() {
        return conexion;
    }

    
    
}
