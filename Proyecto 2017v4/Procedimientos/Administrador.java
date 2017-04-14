/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UML;

import java.sql.Date;

/**
 *
 * @author Al
 */
public class Administrador extends Trabajador
{
    private int idJefe;

    public Administrador(int idTrab, String dni, int idJefe, String nombre, String apellidouno, String apellidodos, String calle, String portal, String piso, String mano, String telefempre, String telefperso, Double salario, Date fechaNac, String categoria, Centro pc) {
        super(idTrab, dni, nombre, apellidouno, apellidodos, calle, portal, piso, mano, telefempre, telefperso, salario, fechaNac, categoria, pc);
        this.idJefe = idJefe;
    }

    

    public int getIdJefe() 
    {
        return idJefe;
    }

    public void setIdJefe(int idJefe) 
    {
        this.idJefe = idJefe;
    }
    
    
    
    
    
    
}
