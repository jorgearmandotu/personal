package main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import main.resources.Alerts;
import main.resources.AportesBonificaciones;
import main.resources.Empleado;
import main.resources.Grupo;
import personalVictoria.route.Apidb;

/**
 *
 * @author home
 */
public class Appi {
    
    Apidb db = new Apidb();
    
   //Inserciones updates
    
    public boolean ingresoPersona(Empleado emp){
        boolean res;
        Alerts msj = new Alerts();
         
        String sql = "INSERT INTO `empleado`('cc','nficha','pnombre','snombre','papellido','sapellido','ncuenta','grupo, cargo, sexo, rh') "
                + "VALUES('"+emp.getCedula()+"',"+emp.getnFicha()+",'"+emp.getpNombre()+"','"+emp.getsNombre()+"','"+emp.getpApellido()
                +"','"+emp.getsApellido()+"',"+emp.getnCuenta()+",'"+emp.getGrupo()+"', '"+emp.getCargo()+"', '"+emp.getSexo()+"', '"+emp.getRh()+"');";
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
    
    public boolean ingresoGrupo(String nom, String supervisor){
        boolean res;
        Alerts msj = new Alerts();
        String sql = "Insert INTO grupos (nombreGrupo, supervisor)"
                + "VALUES ('"+nom+"', '"+supervisor+"')";
        if(db.operacion(sql)){
            msj.aviso("Ingreso Exitoso");
            res = true;
        }else{
            msj.errormsj("Error en operacion");
            res = false;
        }
        return res;
    }
    
    public boolean ingresoCargo(String nom){
        boolean res;
        Alerts msj = new Alerts();
        String sql = "INSERT INTO cargos (nombreCargo)"
                + "VALUES ('"+nom+"')";
        if(db.operacion(sql)){
            msj.aviso("Ingreso Exitoso");
            res = true;
        }else{
            msj.errormsj("Error en operacion");
            res = false;
        }
        return res;
    }
    
    public boolean ingresoDeduccionesBonificaciones(String idemp, String idded){
        boolean res ;
        Alerts msj = new Alerts();
        String sql = "INSERT INTO deduccionesBonificaciones (cedulaEmp, iddeduccion)"
                + "VALUES ('"+idemp+"', '"+idded+"')";
        if(db.operacion(sql)){
            msj.aviso("Ingreso Exitoso");
            res = true;
        }else{
            msj.errormsj("Error en operacion");
            res = false;
        }
        return res;
    }
    
    public boolean ingresoprestacionesBonificaciones(String nom, String tipo, float val){
        boolean res;
        Alerts msj = new Alerts();
        String sql = "INSERT INTO aportesbonificaciones (nombreAporte, tipoAporte, valorAporte)"
                + "VALUES ('"+nom+"', '"+tipo+"', "+val+")";
        System.out.println(sql);
        if(db.operacion(sql)){
            msj.aviso("Ingreso Exitoso");
            res = true;
        }else{
            msj.errormsj("Error en operacion");
            res = false;
        }
        return res;
    }
    
    public boolean updateSupGrupo(String grupo, String supervisor){
        boolean res;
        Alerts msj = new Alerts();
        String sql = "UPDATE grupos SET supervisor = '"+supervisor+"' WHERE nombreGrupo = '"+grupo+"'";
        if(db.operacion(sql)){
            msj.aviso("Ingreso Exitoso");
            res = true;
        }else{
            msj.errormsj("Error en operacion");
            res = false;
        }
        return res;
    }
    
    //Copnsultas listados
   
    public Empleado[] listado(String dato, int op) {
        String sql = "SELECT  nficha, cc, grupo, (pnombre || ' '|| snombre || ' '|| papellido ||' '||sapellido ) as nombre from empleado";
        if(dato.equals("")){//si se envian espacios en blanco
            sql = "SELECT  nficha, cc, grupo, (pnombre || ' '|| snombre || ' '|| papellido ||' '||sapellido ) as nombre from empleado";
        }else if(op==1) {//nombre
            String[] nom = dato.split(" ");
            /*if(nom.length == 4) {
                sql = "SELECT  nficha, cc, grupo, (pnombre || ' '|| snombre || ' '|| papellido ||' '||sapellido ) as nombre from empleado "
                        + "WHERE pnombre LIKE '%"+nom[0]+"%' OR  snombre LIKE '%"+nom[1]+"%' OR "
                        + "papellido LIKE '%"+nom[2]+"%' OR sapellido LIKE '%"+nom[3]+"%'";
            }else{*/
                sql = "SELECT  nficha, cc, grupo, (pnombre || ' '|| snombre || ' '|| papellido ||' '||sapellido ) as nombre from empleado "
                        + "WHERE pnombre LIKE '%"+nom[0]+"%' OR snombre LIKE '%"+nom[0]+"%' OR papellido LIKE '%"+nom[0]+"%' OR sapellido LIKE '%"+nom[0]+"%'";
            //}
        }else if(op==2) {//ficha
            sql = "SELECT  nficha, cc, grupo, (pnombre || ' '|| snombre || ' '|| papellido ||' '||sapellido ) as nombre from empleado WHERE nficha="+dato+"";
        }else if(op==3) {//cedula
            sql = "SELECT  nficha, cc, grupo, (pnombre || ' '|| snombre || ' '|| papellido ||' '||sapellido ) as nombre from empleado WHERE cc="+dato+"";
        }else if(op==4) {//grupo
            sql = "SELECT  nficha, cc, grupo, (pnombre || ' '|| snombre || ' '|| papellido ||' '||sapellido ) as nombre from empleado WHERE grupo='"+dato+"'";
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
    
    public Grupo[] cmbgrupo(){
        String sql = "SELECT nombreGrupo, supervisor, idGrupo FROM grupos";
        ArrayList obj = db.listarGrupos(sql);
        Grupo[] datos = new Grupo[obj.size()];
        int i =0;
        for(Object e : obj){
            datos[i] = (Grupo) e;
            i++;
        }
        return datos;
    }
    
    public AportesBonificaciones[] listEmp(){
        String sql = "SELECT idAporte, nombreAporte, tipoAporte, valorAporte FROM aportesbonificaciones";
        ArrayList obj = db.listarEmp(sql);
        AportesBonificaciones[] list = new AportesBonificaciones[obj.size()];
        int i = 0;
        for(Object e : obj){
            list[i] = (AportesBonificaciones) e;
            i++;
        }
        return list;
    }
    
    public String[] cmbcargos(){
        String sql = "SELECT nombreCargo FROM cargos";
        ArrayList obj = db.listarCargos(sql);
        String[] datos = new String[obj.size()];
        int i = 0;
        for(Object e : obj){
            datos[i] = e.toString();
            i++;
        }
        return datos;
    }
    
    public Empleado[] supervisores(){
        String sql = "SELECT nficha, cc, grupo, (pnombre || ' '|| snombre || ' '|| papellido ||' '||sapellido ) as nombre from empleado WHERE grupo = 'N'";
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
    
    public String idGrupo(String grupo){
        String sql = "SELECT nombreGrupo, supervisor, idGrupo FROM grupos WHERE nombreGrupo = '"+grupo+"'";
        ArrayList obj = db.listarGrupos(sql);
        Grupo grup = null;
        for(Object e : obj){
            grup = (Grupo) e;
        }
        String id;
        if(grup != null) {
            id = grup.getId();
        }else{
            id = "N";
        }
        return id;
        
    }
}
