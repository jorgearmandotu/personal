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
public class Supervisor {
    private String nombre;
    private String cedula;
    private int nFicha;
    private long nCuenta;
    private String grupo;
    private String cargo;
    private String sexo;
    private String rh;
   // private int supervisor;

    public Supervisor(String nombre, String cedula, int nFicha, String grupo, long ncuenta, String sexo, String rh, String cargo) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.nFicha = nFicha;
        this.grupo = grupo;
        this.nCuenta = ncuenta;
        this.sexo = sexo;
        this.rh = rh;
        this.cargo = cargo;
    }

    public Supervisor() {
    }
    
    

    public String getCedula() {
        return cedula;
    }

    public int getnFicha() {
        return nFicha;
    }

    public String getGrupo() {
        return grupo;
    }
    
    @Override
    public String toString() {
        return nombre;
    }
    ///ficha, cc, grupo, ncuenta, cargo, sexo, rh,
}