/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import static BD.GenericoBD.cerrarConexion;
import UML.Administrador;
import UML.Centro;
import UML.Trabajador;
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
public class TrabajadorBD extends GenericoBD
{
    public static ArrayList visualizarListaDnisTrabajador() 
    {
        GenericoBD.abrirConexion();
        Connection conn = GenericoBD.getCon();
        ArrayList <Trabajador> dnisTrabajador=new ArrayList<>();
        Trabajador t=null;
        try
        {
            CallableStatement cs = conn.prepareCall("{call PAQUETE_TRABAJADOR2.visualizar_lista_dnis(?)}");

            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();
            ResultSet rs = (ResultSet)cs.getObject(1);
            while(rs.next())
            {
                t = new Trabajador(0, rs.getString(1), null, null, null, null, null, 
                        null, null, null, null, 0.0, null, null,null);
                dnisTrabajador.add(t);
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
        return dnisTrabajador;
    }
    
    public static ArrayList visualizar_lista_administradores(Administrador a) 
    {
        GenericoBD.abrirConexion();
        Connection conn = GenericoBD.getCon();
        ArrayList <Trabajador> adminTrabajadores=new ArrayList<>();
        String admin=a.getCategoria();
    
        
        try
        {
            CallableStatement cs = conn.prepareCall("{call PAQUETE_TRABAJADOR2.visualizar_lista_tipoTrabaj(?,?)}");

            cs.setString(1, admin);
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.execute();
            ResultSet rs = (ResultSet)cs.getObject(2);
            while(rs.next())
            {
                a=new Administrador(0, rs.getString(1), 0,null,null,null, null,null, null, 
                 null, null, null, 0.0, null,admin, null);
                adminTrabajadores.add(a); 
                /*a=new Administrador(rs.getInt(1), rs.getString(2), rs.getInt(3),rs.getString(4), rs.getString(5),rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getDouble(13), rs.getDate(14),rs.getString(15), new Centro(rs.getInt(16), null, null, 0, null, null, null, null));*/ 
                
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
        return adminTrabajadores;
    }
    
    public static ArrayList visualizar_lista_logistica(Trabajador t) 
    {
        GenericoBD.abrirConexion();
        Connection conn = GenericoBD.getCon();
        ArrayList <Trabajador> logisticTrabajadores=new ArrayList<>();
        String logistic=t.getCategoria();
    
        
        try
        {
            CallableStatement cs = conn.prepareCall("{call PAQUETE_TRABAJADOR2.visualizar_lista_tipoTrabaj(?,?)}");

            cs.setString(1, logistic);
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.execute();
            ResultSet rs = (ResultSet)cs.getObject(2);
            while(rs.next())
            {
                
                t=new Trabajador(0, rs.getString(1), null, null, null, null, null, null, null, null, 
                null, 0.0, null,logistic, null);
                logisticTrabajadores.add(t);
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
        return logisticTrabajadores;
    }
    
    public static Trabajador visualizar_datos_trabajador(Trabajador t) 
    {
        GenericoBD.abrirConexion();
        Connection conn = GenericoBD.getCon();
        String dni=t.getDni();
    
        
        try
        {
            CallableStatement cs = conn.prepareCall("{call PAQUETE_TRABAJADOR2.visualizar_datos_trabajador(?,?)}");

            cs.setString(1, dni);
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.execute();
            ResultSet rs = (ResultSet)cs.getObject(2);
            while(rs.next())
            {
                t=new Trabajador(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),
                rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), 
                rs.getString(11), rs.getDouble(12), rs.getDate(13),rs.getString(14), new Centro(rs.getInt(15), null, null, 0, null, null, null, null));
                
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
        return t;
    }
    
    public static Trabajador buscarTrabajador(Trabajador t) 
    {
        GenericoBD.abrirConexion();
        Connection conn = GenericoBD.getCon();
        String dni=t.getDni();
    
        
        try
        {
            CallableStatement cs = conn.prepareCall("{call PAQUETE_TRABAJADOR2.buscar_trabajador(?,?)}");

            cs.setString(1, dni);
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.execute();
            ResultSet rs = (ResultSet)cs.getObject(2);
            while(rs.next())
            {
                t=new Trabajador(0, dni, rs.getString(1), null, null, null, null, null, null, null, 
                        null, 0.0, null, null, null);
                
                /*a=new Administrador(rs.getInt(1), rs.getString(2), rs.getInt(3),rs.getString(4), rs.getString(5),rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getDouble(13), rs.getDate(14),rs.getString(15), new Centro(rs.getInt(16), null, null, 0, null, null, null, null));*/ 
                
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
        return t;
    }
    
    public static void actualizarTrabajador(Trabajador t) 
    {
        GenericoBD.abrirConexion();
        Connection conn = GenericoBD.getCon();
        Administrador a =(Administrador)t;
        String dniTrabajadorAdmin = a.getDni();
        String dniTrabajador=t.getDni();
        String plantilla="";
        try
        {
            if(t instanceof Administrador)
            {
                
                
                plantilla = "UPDATE TRABAJADORES NOMBRE="+a.getNombre()
                        +",APELLIDOUNO="+a.getApellidouno()+",APELLIDODOS="+a.getApellidodos()
                        +",CALLE="+a.getCalle()+",PORTAL="+a.getPortal()+",PISO="+a.getPiso()
                        +",MANO="+a.getMano()+",TELEFEMPRE="+a.getTelefempre()+",TELEFPERSO="
                        +a.getTelefperso()+",SALARIO="+a.getSalario()+",FECHA_NAC="+a.getFechaNac()
                        +",CATEGORIA="+a.getCategoria()+"CENTRO="+a.getC().getIdCentro()+"WHERE DNI="+ dniTrabajadorAdmin;
            }
            else
            {
                plantilla = "UPDATE TRABAJADORES SET NOMBRE="+t.getNombre()
                        +",APELLIDOUNO="+t.getApellidouno()+",APELLIDODOS="+t.getApellidodos()
                        +",CALLE="+t.getCalle()+",PORTAL="+t.getPortal()+",PISO="+t.getPiso()
                        +",MANO="+t.getMano()+",TELEFEMPRE="+t.getTelefempre()+",TELEFPERSO="+t.getTelefperso()
                        +",SALARIO="+t.getSalario()+",FECHA_NAC="+t.getFechaNac()
                        +",CATEGORIA="+t.getCategoria()+"CENTRO="+t.getC().getIdCentro()+"WHERE DNI="+dniTrabajador;
            }

        PreparedStatement ps = conn.prepareStatement(plantilla);
        ps.executeUpdate();
        conn.commit();
        }
        catch(Exception e)
        {
           
           e.printStackTrace();
        }
        finally
        {
           cerrarConexion();
        }
    }
    
    public static void insertarTrabajador(Trabajador t) 
    {
        GenericoBD.abrirConexion();
        Connection conn = GenericoBD.getCon();
        Administrador a =(Administrador)t;
        String plantilla="";
        try
        {
            if(t instanceof Administrador)
            {
                
                
                plantilla = "INSERT INTO TRABAJADORES VALUES DNI="+a.getDni()+",NOMBRE="+a.getNombre()
                        +",APELLIDOUNO="+a.getApellidouno()+",APELLIDODOS="+a.getApellidodos()
                        +",CALLE="+a.getCalle()+",PORTAL="+a.getPortal()+",PISO="+a.getPiso()
                        +",MANO="+a.getMano()+",TELEFEMPRE="+a.getTelefempre()+",TELEFPERSO="+a.getTelefperso()
                        +",SALARIO="+a.getSalario()+",FECHA_NAC="+a.getFechaNac()+",CATEGORIA="+a.getCategoria()
                        +",CENTRO="+a.getC().getIdCentro();
            }
            else
            {
                plantilla = "INSERT INTO TRABAJADORES VALUES DNI="+t.getDni()+",NOMBRE="+t.getNombre()
                        +",APELLIDOUNO="+t.getApellidouno()+",APELLIDODOS="+t.getApellidodos()
                        +",CALLE="+t.getCalle()+",PORTAL="+t.getPortal()+",PISO="+t.getPiso()
                        +",MANO="+t.getMano()+",TELEFEMPRE="+t.getTelefempre()+",TELEFPERSO="+t.getTelefperso()
                        +",SALARIO="+t.getSalario()+",FECHA_NAC="+t.getFechaNac()
                        +",CATEGORIA="+t.getCategoria()+",CENTRO="+t.getC().getIdCentro();
            }

        PreparedStatement ps = conn.prepareStatement(plantilla);
        ps.executeUpdate();
        conn.commit();
        }
        catch(Exception e)
        {
           t = null;
           e.printStackTrace();
        }
        finally
        {
           cerrarConexion();
        }
    }
    
    public static void borrarTrabajador(Trabajador t) 
    {
        GenericoBD.abrirConexion();
        Connection conn = GenericoBD.getCon();
        String dni = t.getDni();
        try
        {
        String plantilla = "DELETE FROM TRABAJADORES WHERE dni=" + dni;
        PreparedStatement ps = conn.prepareStatement(plantilla);
        ps.executeUpdate();
        conn.commit();
        }
        catch(Exception e)
        {
           t = null;
           e.printStackTrace();
        }
        finally
        {
           cerrarConexion();
        }
    }
}