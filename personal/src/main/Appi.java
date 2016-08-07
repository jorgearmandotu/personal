package main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.resources.Alerts;
import main.resources.Empleado;
import personalVictoria.route.Apidb;

/**
 *
 * @author home
 */
public class Appi {
    
    Apidb db = new Apidb();
    
   
    public void ingresoPersona(Empleado emp){
        Alerts msj = new Alerts();
         
        String sql = "INSERT INTO `empleado`('cc','nficha','pnombre','snombre','papellido','sapellido','ncuenta','supervisor') "
                + "VALUES('"+emp.getCedula()+"',"+emp.getnFicha()+",'"+emp.getpNombre()+"','"+emp.getsNombre()+"','"+emp.getpApellido()
                +"','"+emp.getsApellido()+"',"+emp.getnCuenta()+",'"+emp.getSupervisor()+"');";
        if(db.operacion(sql)){
            msj.aviso("Ingreso exitoso");
        }else{
            msj.errormsj("Error en operacion");
        }
        System.out.println(sql);
    }
   
    public Object[][] listado() {
        Object[][] datos=null;
        String sql = "SELECT  nficha, cc, supervisor, (pnombre || ' '|| snombre || ' '|| papellido ||' '||sapellido ) as nombre from empleado";
        //ResultSet res = db.listar(sql);
        db.listar(sql);
        
        return datos;
    }
}
