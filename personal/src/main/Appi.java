package main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import main.resources.Alerts;
import main.resources.AportesBonificaciones;
import main.resources.Empleado;
import main.resources.Grupo;
import main.resources.IncapacidadesPermisos;
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
         
        String sql = "INSERT INTO `empleado`('cc','nficha','pnombre','snombre','papellido','sapellido','ncuenta','grupo', 'cargo', 'sexo', 'rh') "
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
    
    public boolean ingresoDeduccionesBonificaciones(String idemp, int idded){
        boolean res ;
        Alerts msj = new Alerts();
        String sql = "INSERT INTO deducidosBonificaciones (cedulaEmp, iddeduccion)"
                + "VALUES ('"+idemp+"', "+idded+")";
        if(db.operacion(sql)){
            //msj.aviso("Ingreso Exitoso");
            res = true;
        }else{
            //msj.errormsj("Error en operacion");
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
    
    public boolean eliminarEmpleado(String dato){
        Alerts msj = new Alerts();
        boolean res;
        Date fechaActual = new Date();
        DateFormat formato = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        String fecha = formato.format(fechaActual);
        System.out.println(fecha);
        String sql = "UPDATE empleado SET cc = '"+dato+" "+fecha+"' WHERE cc = '"+dato+"'";
        if(db.operacion(sql)){
            msj.aviso("empleado eliminado");
            res = true;
        }else{
            msj.errormsj("Error en operacion");
            res = false;
        }
        return res;
    }
    
    public void insertarIncapacidadesPermisos(String cedula, String fechaA, String fechaB, int pagadas, int tipo){
        Alerts msj = new Alerts();
          String sql = "INSERT INTO incapacidadesPermisos (cc_Empleado, fechaA, fechaB, tipoFalta, pagada) "
                  + "VALUES ('"+cedula+"', '"+fechaA+"', '"+fechaB+"', "+tipo+", "+pagadas+")";
        System.out.println(sql);
        if(db.operacion(sql)){
            msj.aviso("Ingreso Exitoso");
        }else{
            msj.errormsj("Error en operacion");
        }
    }
    
    public void updateIncapacidadesPermisos(String cedula, String fechaA, String fechaB, int pagadas, int tipo){
        Alerts msj = new Alerts();
          String sql = "UPDATE incapacidadesPermisos SET fechaB = '"+fechaB+"', "
                  + "tipoFalta = "+tipo+", pagada = "+pagadas+" WHERE cc_Empleado = '"+cedula+"' AND fechaA = '"+fechaA+"'";
        System.out.println(sql);
        if(db.operacion(sql)){
            msj.aviso("Ingreso Exitoso");
        }else{
            msj.errormsj("Error en operacion");
        }
    }
    
    
    //Copnsultas listados
   
    public Empleado[] listado(String dato, int op) {
        String sql = "SELECT  nficha, cc, grupo, (pnombre || ' '|| snombre || ' '|| papellido ||' '||sapellido ) as nombre from empleado WHERE cc NOT LIKE '% %'";
        if(dato.equals("")){//si se envian espacios en blanco
            sql = "SELECT  nficha, cc, grupo, (pnombre || ' '|| snombre || ' '|| papellido ||' '||sapellido ) as nombre from empleado WHERE cc NOT LIKE '% %'";
        }else if(op==1) {//nombre
            String[] nom = dato.split(" ");
            /*if(nom.length == 4) {
                sql = "SELECT  nficha, cc, grupo, (pnombre || ' '|| snombre || ' '|| papellido ||' '||sapellido ) as nombre from empleado "
                        + "WHERE pnombre LIKE '%"+nom[0]+"%' OR  snombre LIKE '%"+nom[1]+"%' OR "
                        + "papellido LIKE '%"+nom[2]+"%' OR sapellido LIKE '%"+nom[3]+"%'";
            }else{*/
                sql = "SELECT  nficha, cc, grupo, (pnombre || ' '|| snombre || ' '|| papellido ||' '||sapellido ) as nombre from empleado "
                        + "WHERE (pnombre LIKE '%"+nom[0]+"%' OR snombre LIKE '%"+nom[0]+"%' OR papellido LIKE '%"+nom[0]+"%' OR sapellido LIKE '%"+nom[0]+"%') AND cc NOT LIKE '% %'";
            //}
        }else if(op==2) {//ficha
            sql = "SELECT  nficha, cc, grupo, (pnombre || ' '|| snombre || ' '|| papellido ||' '||sapellido ) as nombre from empleado WHERE nficha="+dato+" AND cc NOT LIKE '% %'";
        }else if(op==3) {//cedula
            sql = "SELECT  nficha, cc, grupo, (pnombre || ' '|| snombre || ' '|| papellido ||' '||sapellido ) as nombre from empleado WHERE cc="+dato+" AND cc NOT LIKE '% %'";
        }else if(op==4) {//grupo
            sql = "SELECT  nficha, cc, grupo, (pnombre || ' '|| snombre || ' '|| papellido ||' '||sapellido ) as nombre from empleado WHERE grupo='"+dato+"' AND cc NOT LIKE '% %'";
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
        String sql = "SELECT DISTINCT cargo FROM empleado";
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
    
    public AportesBonificaciones aporte(String nom){
        String sql = "SELECT idAporte, nombreAporte, tipoAporte, valorAporte FROM aportesbonificaciones WHERE nombreAporte = '"+nom+"'";
        AportesBonificaciones obj = db.buscarAporte(sql);
        return obj;
    }
    
    public Empleado empleado(String cc){
        String sql = "SELECT cc, nficha, pnombre, snombre, papellido, sapellido, ncuenta, grupo, cargo , sexo, rh "
                + "FROM empleado WHERE cc = '"+cc+"'";
        ArrayList list = db.empleados(sql);
        Empleado emp = null;
        for(Object e :list){
            emp = (Empleado) e;
        }
        return emp;
    }
    
    public Empleado empleadoFicha(String ficha){
        String sql = "SELECT cc, nficha, pnombre, snombre, papellido, sapellido, ncuenta, grupo, cargo , sexo, rh "
                + "FROM empleado WHERE nficha = '"+ficha+"'";
        ArrayList list = db.empleados(sql);
        Empleado emp = null;
        for(Object e :list){
            emp = (Empleado) e;
        }
        return emp;
    }
    
    public IncapacidadesPermisos verificarincapacidadpermiso(String cedula, String fechaA){
        IncapacidadesPermisos res = null;
        String sql = "SELECT cc_Empleado, fechaA, fechaB, tipoFalta, pagada FROM incapacidadesPermisos WHERE cc_empleado = '"+cedula+"' AND fechaA = '"+fechaA+"'";
        IncapacidadesPermisos obj = db.permisoExistente(sql);
            res = obj;
        return res;
    }
    
    //Consulta resta select para llamar asistencia
    //select cc from empleado except select distinct cc_Empleado from  incapacidadesPermisos
}
