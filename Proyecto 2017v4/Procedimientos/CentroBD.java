/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import UML.Centro;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Al
 */
public class CentroBD extends GenericoBD
{
    
    public static ArrayList visualizarListaIdsCentros() 
    {
        GenericoBD.abrirConexion();
        Connection conn = GenericoBD.getCon();
        ArrayList <Centro> idsCentro=new ArrayList<>();
        Centro c = null;
        try
        {
            CallableStatement cs = conn.prepareCall("{call PAQUETE_CENTRO2.visualizar_lista_ids_centro(?)}");

            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();
            ResultSet rs = (ResultSet)cs.getObject(1);
            while(rs.next())
            {
                c = new Centro(rs.getInt(1),null,null,0,null,null,null,null);
                idsCentro.add(c);
            }
        }
        catch(Exception e)
        {
            
            e.printStackTrace();
        }
        finally
        {
           cerrarConexion();
        }
        return idsCentro;
    }
    
    public static ArrayList visualizarListaNombreCentros() 
    {
        GenericoBD.abrirConexion();
        Connection conn = GenericoBD.getCon();
        ArrayList <Centro> nombreCentros=new ArrayList<>();
        Centro c = null;
        try
        {
            CallableStatement cs = conn.prepareCall("{call PAQUETE_CENTRO2.visualizar_lista_nombre_centro(?)}");

            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();
            ResultSet rs = (ResultSet)cs.getObject(1);
            while(rs.next())
            {
                c = new Centro(0,rs.getString(1),null,0,null,null,null,null);
                nombreCentros.add(c);
            }
        }
        catch(Exception e)
        {
            
            e.printStackTrace();
        }
        finally
        {
           cerrarConexion();
        }
        return nombreCentros;
    }
    
    public static Centro visualizarCentroId(Centro c) 
    {
        GenericoBD.abrirConexion();
        Connection conn = GenericoBD.getCon();
        int idCentro =c.getIdCentro();
        try
        {
            CallableStatement cs = conn.prepareCall("{call PAQUETE_CENTRO2.visualizar_datos_centro(?,?)}");
            cs.setInt(1, idCentro);
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.execute();
            ResultSet rs = (ResultSet)cs.getObject(2);
            if(rs.next())
            {
                c = new Centro(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8));
            }
        }
        catch(Exception e)
        {
            c = null;
            e.printStackTrace();
        }
        finally
        {
            cerrarConexion();
        }
        return c;
    }
    
    public static Centro visualizarCentroNombre(Centro c) 
    {
        GenericoBD.abrirConexion();
        Connection conn = GenericoBD.getCon();
        String nombreCentro=c.getNombre();
        try
        {
            CallableStatement cs = conn.prepareCall("{call PAQUETE_CENTRO2.visualizar_datos_centro_nombre(?,?)}");
            cs.setString(1, nombreCentro);
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.execute();
            ResultSet rs = (ResultSet)cs.getObject(2);
            if(rs.next())
            {
                c = new Centro(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8));
            }
        }
        catch(Exception e)
        {
           c = null;
           e.printStackTrace();
        }
        finally
        {
           cerrarConexion();
        }
       return c;
    }
    
    public static Centro BuscarCentroId(Centro c) 
    {
        GenericoBD.abrirConexion();
        Connection conn = GenericoBD.getCon();
        int idCentro=c.getIdCentro();
        try
        {
            CallableStatement cs = conn.prepareCall("{call PAQUETE_CENTRO2.buscar_centro_por_id(?,?)}");
            cs.setInt(1, idCentro);
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.execute();
            ResultSet rs = (ResultSet)cs.getObject(2);
            if(rs.next())
            {
                c = new Centro(idCentro,rs.getString(1),null,0,null,null,null,null);
            }
        }
        catch(Exception e)
        {
            c = null;
            e.printStackTrace();
        }
        finally
        {
            cerrarConexion();
        }
        return c;
    }
    
    public static Centro BuscarCentroNombre(Centro c) 
    {
        GenericoBD.abrirConexion();
        Connection conn = GenericoBD.getCon();
        String nombre =c.getNombre();
        try
        {
            CallableStatement cs = conn.prepareCall("{call PAQUETE_CENTRO2.buscar_centro_por_nombre(?,?)}");
            cs.setString(1, nombre);
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.execute();
            ResultSet rs = (ResultSet)cs.getObject(2);
            if(rs.next())
            {
                c = new Centro(rs.getInt(1),nombre,null,0,null,null,null,null);
            }
        }
        catch(Exception e)
        {
            c = null;
            e.printStackTrace();
        }
        finally
        {
            cerrarConexion();
        }
        return c;
    }
    
    public static void insertarCentro(Centro c)
    {
        GenericoBD.abrirConexion();
        Connection conn = GenericoBD.getCon();
        try
        {
        String plantilla = "INSERT INTO CENTROS (IDCENTRO, NOMBRE, CALLE, NUMERO, CP, CIUDAD, PROVINCIA, TELEFONO) VALUES (?,?,?,?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(plantilla);
        ps.setInt(1,c.getIdCentro());
        ps.setString(2,c.getNombre());
        ps.setString(3,c.getCalle());
        ps.setInt(4,c.getNumero());
        ps.setString(5,c.getCp());
        ps.setString(6,c.getCiudad());
        ps.setString(7,c.getProvincia());
        ps.setString(8,c.getTelefono());
        ps.executeUpdate();
        conn.commit();
        }
        catch(Exception e)
        {
           c = null;
           e.printStackTrace();
        }
        finally
        {
           cerrarConexion();
        }
    }
        
        public static void modificar(Centro c) 
        {
            Connection conn = GenericoBD.getCon();
            int idCentro=c.getIdCentro();
            String plantilla = "UPDATE CENTROS SET(NOMBRE, TELEFONO, CALLE, NUMERO, CP, CIUDAD, PROVINCIA) VALUES (?,?,?,?,?,?,?) WHERE IDCENTRO = "+ idCentro;
            try
            {
            PreparedStatement ps=conn.prepareStatement(plantilla);
            ps.setString(1,c.getNombre());
            ps.setString(3,c.getCalle());
            ps.setInt(4,c.getNumero());
            ps.setString(5,c.getCp());
            ps.setString(6,c.getCiudad());
            ps.setString(7,c.getProvincia());
            ps.setString(8,c.getTelefono());
            ps.executeUpdate();
            conn.commit();
            }
            catch(Exception e)
            {
               c = null;
               e.printStackTrace();
            }
            finally
            {
               cerrarConexion();
            }

            
        }
        
    public static void borrarCentro(Centro c)
    {
        GenericoBD.abrirConexion();
        Connection conn = GenericoBD.getCon();
        int idCentro = c.getIdCentro();
        try
        {
        String plantilla = "DELETE FROM CENTROS WHERE idCentro=" + idCentro;
        PreparedStatement ps = conn.prepareStatement(plantilla);
        ps.executeUpdate();
        conn.commit();
        }
        catch(Exception e)
        {
           c = null;
           e.printStackTrace();
        }
        finally
        {
           cerrarConexion();
        }
    }
}
