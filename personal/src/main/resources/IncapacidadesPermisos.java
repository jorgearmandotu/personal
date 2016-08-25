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
public class IncapacidadesPermisos {
    private String cc;
    private String fechaA;
    private String fechaB;
    private int tipo;
    private int pagada;//boolean 0 no, 1 sí

    public IncapacidadesPermisos(String cc, String fechaA, String fechaB, int tipo, int pagada) {
        this.cc = cc;
        this.fechaA = fechaA;
        this.fechaB = fechaB;
        this.tipo = tipo;
        this.pagada = pagada;
    }

    public String getCc() {
        return cc;
    }

    public String getFechaA() {
        return fechaA;
    }

    public String getFechaB() {
        return fechaB;
    }

    public int getTipo() {
        return tipo;
    }

    public int getPagada() {
        return pagada;
    }
    
    
}
