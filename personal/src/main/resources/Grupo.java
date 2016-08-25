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
public class Grupo {
    private String nombre;
    private String supervisor;
    private String id;

    public Grupo(String nombre, String supervisor, String id) {
        this.nombre = nombre;
        this.supervisor = supervisor;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public String getId() {
        return id;
    }
    
    
}
