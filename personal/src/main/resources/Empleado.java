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
    String grupo;
    String cargo;
    String sexo;
    String rh;
    int supervisor;

    public Empleado(String cedula, String pNombre, String sNombre, String pApellido, 
            String sApellido, int nFicha, long nCuenta, String grupo, String cargo, 
            String sexo, String rh, int supervisor) {
        this.cedula = cedula;
        this.pNombre = pNombre;
        this.sNombre = sNombre;
        this.pApellido = pApellido;
        this.sApellido = sApellido;
        this.nFicha = nFicha;
        this.nCuenta = nCuenta;
        this.grupo = grupo;
        this.cargo = cargo;
        this.sexo = sexo;
        this.rh = rh;
        this.supervisor = supervisor;
    }
    
    public Empleado(int ficha, String cedula, String nombre, String grupo, long cuenta, String cargo, String sexo, String rh){
        this.cedula = cedula;
        this.pNombre = nombre;
        this.nFicha = ficha;
        this.nCuenta = cuenta;
        this.grupo = grupo;
        this.cargo = cargo;
        this.sexo = sexo;
        this.rh = rh;
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

    public String getGrupo() {
        return grupo;
    }

    public String getCargo() {
        return cargo;
    }

    public String getSexo() {
        return sexo;
    }

    public String getRh() {
        return rh;
    }

    public int getSupervisor() {
        return supervisor;
    }
    
    
}
