/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.resources;

/**
 *
 * @author home
 */
public class Empleado {
    
    String cedula;
    String pNombre;
    String sNombre;
    String pApellido;
    String sApellido;
    int nFicha;
    long nCuenta;
    String supervisor;

    public Empleado(String cedula, String pNombre, String sNombre, String pApellido, String sApellido, int nFicha, long nCuenta, String supervisor) {
        this.cedula = cedula;
        this.pNombre = pNombre;
        this.sNombre = sNombre;
        this.pApellido = pApellido;
        this.sApellido = sApellido;
        this.nFicha = nFicha;
        this.nCuenta = nCuenta;
        this.supervisor = supervisor;
    }
    
    public Empleado(int ficha, String cedula, String nombre, String supervisor){
        this.cedula = cedula;
        this.pNombre = nombre;
        //this.sNombre = "";
        //this.pApellido = pApellido;
       // this.sApellido = sApellido;
        this.nFicha = ficha;
        //this.nCuenta = nCuenta;
        this.supervisor = supervisor;
    }

    public String getCedula() {
        return cedula;
    }

    public String getpNombre() {
        return pNombre;
    }

    public String getsNombre() {
        return sNombre;
    }

    public String getpApellido() {
        return pApellido;
    }

    public String getsApellido() {
        return sApellido;
    }

    public int getnFicha() {
        return nFicha;
    }

    public long getnCuenta() {
        return nCuenta;
    }

    public String getSupervisor() {
        return supervisor;
    }
    
    
}
