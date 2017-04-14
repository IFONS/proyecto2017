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
public class Trabajador 
{
    private int idTrab;
    private String dni;
    private String nombre;   
    private String apellidouno;
    private String apellidodos;
    private String calle;
    private String portal;
    private String piso;
    private String mano;
    private String telefempre;
    private String telefperso;
    private Double salario;
    private Date fechaNac;
    private String categoria;
    private Centro  c;

    public Trabajador() 
    {
        
    }

    public Trabajador(int idTrab, String dni, String nombre, String apellidouno,
            String apellidodos, String calle, String portal, String piso, 
            String mano, String telefempre, String telefperso, Double salario,
            Date fechaNac, String categoria, Centro pc) 
    {
        this.idTrab = idTrab;
        this.dni = dni;
        this.nombre = nombre;
        this.apellidouno = apellidouno;
        this.apellidodos = apellidodos;
        this.calle = calle;
        this.portal = portal;
        this.piso = piso;
        this.mano = mano;
        this.telefempre = telefempre;
        this.telefperso = telefperso;
        this.salario = salario;
        this.fechaNac = fechaNac;
        this.categoria=categoria;
        c=pc;
    }

    public int getIdTrab() {
        return idTrab;
    }

    public void setIdTrab(int idTrab) {
        this.idTrab = idTrab;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidouno() {
        return apellidouno;
    }

    public void setApellidouno(String apellidouno) {
        this.apellidouno = apellidouno;
    }

    public String getApellidodos() {
        return apellidodos;
    }

    public void setApellidodos(String apellidodos) {
        this.apellidodos = apellidodos;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getPortal() {
        return portal;
    }

    public void setPortal(String portal) {
        this.portal = portal;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getMano() {
        return mano;
    }

    public void setMano(String mano) {
        this.mano = mano;
    }

    public String getTelefempre() {
        return telefempre;
    }

    public void setTelefempre(String telefempre) {
        this.telefempre = telefempre;
    }

    public String getTelefperso() {
        return telefperso;
    }

    public void setTelefperso(String telefperso) {
        this.telefperso = telefperso;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) 
    {
        this.fechaNac = fechaNac;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    

    public Centro getC() {
        return c;
    }

    public void setC(Centro cent) {
        c=cent;
    }
    
    
    
    
}
