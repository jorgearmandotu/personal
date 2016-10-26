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

    private String cedula;
    private String pNombre;
    private String sNombre;
    private String pApellido;
    private String sApellido;
    private int nFicha;
    private long nCuenta;
    private String grupo;
    private String cargo;
    private String sexo;
    private String rh;
    private int auxTransporte;
    private int supervisor;
    private String photo;
    private String fechaIngreso;

    public Empleado(String cedula, String pNombre, String sNombre, String pApellido, String sApellido, 
            int nFicha, long nCuenta, String grupo, String cargo, String sexo, String rh, int auxTransporte, 
            int supervisor, String photo, String fechaIngreso) {
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
        this.auxTransporte = auxTransporte;
        this.supervisor = supervisor;
        this.photo = photo;
        this.fechaIngreso = fechaIngreso;
    }

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

    public Empleado(String cedula, String pNombre, String sNombre, String pApellido,
            String sApellido, int nFicha, long nCuenta, String grupo, String cargo,
            String sexo, String rh, int supervisor, int auxTrans, String photo) {
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
        this.auxTransporte = auxTrans;
        this.photo = photo;
    }

    //constructor empleado con nombre completo en pnombre
    public Empleado(int ficha, String cedula, String nombre, String grupo, long cuenta, String cargo, String sexo, String rh) {
        this.cedula = cedula;
        this.pNombre = nombre;
        this.nFicha = ficha;
        this.nCuenta = cuenta;
        this.grupo = grupo;
        this.cargo = cargo;
        this.sexo = sexo;
        this.rh = rh;
    }

    public Empleado(int ficha, String cedula, String nombre, String grupo, long cuenta, String cargo, String sexo, String rh, String photo) {
        this.cedula = cedula;
        this.pNombre = nombre;
        this.nFicha = ficha;
        this.nCuenta = cuenta;
        this.grupo = grupo;
        this.cargo = cargo;
        this.sexo = sexo;
        this.rh = rh;
        this.photo = photo;
    }

    public Empleado(int ficha, String cedula, String nombre, String grupo, long cuenta,
            String cargo, String sexo, String rh, String photo, int auxTransporte) {
        this.cedula = cedula;
        this.pNombre = nombre;
        this.nFicha = ficha;
        this.nCuenta = cuenta;
        this.grupo = grupo;
        this.cargo = cargo;
        this.sexo = sexo;
        this.rh = rh;
        this.photo = photo;
        this.auxTransporte = auxTransporte;
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

    public String getPhoto() {
        return photo;
    }

    public int getAuxTransporte() {
        return auxTransporte;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

}
