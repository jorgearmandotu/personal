package main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import main.resources.Alerts;
import main.resources.Empleado;
import personalVictoria.route.Apidb;

/**
 *
 * @author home
 */
public class Appi {
    
    Apidb db = new Apidb();
    
   
    public boolean ingresoPersona(Empleado emp){
        boolean res;
        Alerts msj = new Alerts();
         
        String sql = "INSERT INTO `empleado`('cc','nficha','pnombre','snombre','papellido','sapellido','ncuenta','supervisor') "
                + "VALUES('"+emp.getCedula()+"',"+emp.getnFicha()+",'"+emp.getpNombre()+"','"+emp.getsNombre()+"','"+emp.getpApellido()
                +"','"+emp.getsApellido()+"',"+emp.getnCuenta()+",'"+emp.getSupervisor()+"');";
        if(db.operacion(sql)){
            msj.aviso("Ingreso exitoso");
            res = true;
        }else{
            msj.errormsj("Error en operacion");
            res = false;
        }
        System.out.println(sql);
        return res;
    }
   
    public Empleado[] listado(String dato, int op) {
        String sql = "SELECT  nficha, cc, supervisor, (pnombre || ' '|| snombre || ' '|| papellido ||' '||sapellido ) as nombre from empleado";
        if(dato.equals("")){//si se envian espacios en blanco
            sql = "SELECT  nficha, cc, supervisor, (pnombre || ' '|| snombre || ' '|| papellido ||' '||sapellido ) as nombre from empleado";
        }else if(op==1) {//nombre
            String[] nom = dato.split(" ");
            /*if(nom.length == 4) {
                sql = "SELECT  nficha, cc, supervisor, (pnombre || ' '|| snombre || ' '|| papellido ||' '||sapellido ) as nombre from empleado "
                        + "WHERE pnombre LIKE '%"+nom[0]+"%' OR  snombre LIKE '%"+nom[1]+"%' OR "
                        + "papellido LIKE '%"+nom[2]+"%' OR sapellido LIKE '%"+nom[3]+"%'";
            }else{*/
                sql = "SELECT  nficha, cc, supervisor, (pnombre || ' '|| snombre || ' '|| papellido ||' '||sapellido ) as nombre from empleado "
                        + "WHERE pnombre LIKE '%"+nom[0]+"%' OR snombre LIKE '%"+nom[0]+"%' OR papellido LIKE '%"+nom[0]+"%' OR sapellido LIKE '%"+nom[0]+"%'";
            //}
        }else if(op==2) {//ficha
            sql = "SELECT  nficha, cc, supervisor, (pnombre || ' '|| snombre || ' '|| papellido ||' '||sapellido ) as nombre from empleado WHERE nficha="+dato+"";
        }else if(op==3) {//cedula
            sql = "SELECT  nficha, cc, supervisor, (pnombre || ' '|| snombre || ' '|| papellido ||' '||sapellido ) as nombre from empleado WHERE cc="+dato+"";
        }else if(op==4) {//supervisor
            sql = "SELECT  nficha, cc, supervisor, (pnombre || ' '|| snombre || ' '|| papellido ||' '||sapellido ) as nombre from empleado WHERE supervisor='"+dato+"'";
        }
        ArrayList obj = db.listar(sql);
        System.out.println(obj.size());
        Empleado[] datos= new Empleado[obj.size()];
        int i=0;
        for(Object e:obj ){
            datos[i]= (Empleado) e;
            i++;
        }
        return datos;
    }
    
    public Empleado[] cmbsupervisor(){
        String sql = "SELECT nficha, cc, supervisor, (pnombre || ' '|| snombre || ' '|| papellido ||' '||sapellido ) as nombre from empleado WHERE supervisor = 'N'";
        ArrayList obj = db.listar(sql);
        Empleado[] datos = new Empleado[obj.size()];
        int i =0;
        for(Object e : obj){
            datos[i] = (Empleado) e;
            i++;
        }
        return datos;
    }
}
