package BD;

import java.sql.Connection;
import java.sql.DriverManager;

public class GenericoBD {
    private static Connection con;

    public static boolean abrirConexion()
    {
        try
        {
            Class.forName("oracle.jdbc.OracleDriver");
            
            String login="PRUEBASC";
            String password= "soybatman94";
            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            con = DriverManager.getConnection(url,login,password);
            System.out.println("abriendo conexion");
            System.out.println("conexion establecida");
            return true;
            
        
        }
        catch(Exception e){
            System.out.println("No se pudo abrir la conexion");
            return false;
            
        }
        
    }
    
    public static boolean cerrarConexion()
    {
        try
        {
            con.close();
            System.out.println("Conexion cerrada");
            return true;
        }
        catch(Exception e){
            System.out.println("No se pudo cerrar la conexion");
            return false;
        }
    }

    public static Connection getCon() 
    {
        System.out.println("conexion establecida");
        return con;
    }
    
}
