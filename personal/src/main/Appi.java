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
import main.resources.Supervisor;
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
         
        String sql = "INSERT INTO `empleado`('cc','nficha','pnombre','snombre','papellido','sapellido','ncuenta','grupo', 'cargo', 'sexo', 'rh', 'supervisor') "
                + "VALUES('"+emp.getCedula()+"',"+emp.getnFicha()+",'"+emp.getpNombre()+"','"+emp.getsNombre()+"','"+emp.getpApellido()
                +"','"+emp.getsApellido()+"',"+emp.getnCuenta()+",'"+emp.getGrupo()+"', '"+emp.getCargo()+"', '"+emp.getSexo()+"', '"+emp.getRh()+"', "+emp.getSupervisor()+");";
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
    
    public boolean ingresoGrupo(String nom, String cedsupervisor){
        boolean res;
        Alerts msj = new Alerts();
        Grupo obj = null;
        obj = db.maxGrupo("select  nombreGrupo, supervisor, max(idgrupo) as idGrupo from grupos");
        int idgrupo = 0;
        if(obj.getId() != null){
            System.out.println(obj);
            idgrupo = Integer.parseInt(obj.getId());
            System.out.println("soy nulo coño i el numero es "+idgrupo);
        }
        System.out.println(" el numero es "+idgrupo);
        System.out.println(obj);
        idgrupo++;
        String sql = "UPDATE grupos SET supervisor = 'N' WHERE supervisor ='"+cedsupervisor+"';"
                + "Insert INTO grupos (nombreGrupo, supervisor, idGrupo)"
                + "VALUES ('"+nom+"', '"+cedsupervisor+"', "+idgrupo+")";
        
        String sql2 = "UPDATE empleado SET grupo = '"+idgrupo+"' WHERE cc = '"+cedsupervisor+"'";
        System.out.println(sql+"\n"+sql2);
        if(db.operacionTransaccion(sql,sql2)){
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
    
    public boolean updateSupGrupo(String grupo, String supervisor, String cedula){
        boolean res;
        Alerts msj = new Alerts();
        String sql = "UPDATE grupos SET supervisor = 'N' WHERE supervisor ='"+cedula+"';"
                + "UPDATE grupos SET supervisor = '"+cedula+"' WHERE nombreGrupo = '"+grupo+"'";
        Grupo obj = db.maxGrupo("select  nombreGrupo, supervisor, idgrupo as idGrupo from grupos where nombreGrupo = '"+grupo+"'");
        int idgrupo = Integer.parseInt(obj.getId());
        String cedula2 = obj.getSupervisor();
        //String[] nombre =  
        String sql2 = "UPDATE empleado SET grupo = 'N' WHERE cc = '"+cedula2+"' and grupo = '"+idgrupo+"' ;"
                + "UPDATE empleado SET grupo = '"+idgrupo+"' WHERE cc = '"+cedula+"'";
        System.out.println(sql+"\n"+sql2);
        if(db.operacionTransaccion(sql, sql2)){
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
    
    public void InsertarFalta(String cc){
        Alerts msj = new Alerts();
        Date fechaActual = new Date();
        DateFormat formatFecha = new SimpleDateFormat("YYYY-MM-dd");
        String fecha = formatFecha.format(fechaActual);
        //String[] fechas = fecha.split("-");
        String[] quincena = definirQuincena(fecha);
        String fechaA = quincena[0];
        String fechaB = quincena[1];
        System.out.println(fecha);
        String sql = "INSERT INTO asistencia (ccEmpleado, quincenaFechaA, quincenaFechaB, falta, FechaFalta)"
                + "VALUES ('"+cc+"','"+fechaA+"', '"+fechaB+"', "+2+", '"+fecha+"')";// 2 es falta
        System.out.println(sql);
        if(!db.operacion(sql)) {
            msj.aviso("Error en Operacion");
        }
    }
    
    public void InsertarFaltaFecha(String cc, String fecha){
        Alerts msj = new Alerts();
        Date fechaActual = new Date();
        //DateFormat formatFecha = new SimpleDateFormat("YYYY-MM-dd");
        //String fecha = formatFecha.format(fechaActual);
        //String[] fechas = fecha.split("-");
        String[] quincena = definirQuincena(fecha);
        String fechaA = quincena[0];
        String fechaB = quincena[1];
        System.out.println(fecha);
        String sql = "INSERT INTO asistencia (ccEmpleado, quincenaFechaA, quincenaFechaB, falta, FechaFalta)"
                + "VALUES ('"+cc+"','"+fechaA+"', '"+fechaB+"', "+2+", '"+fecha+"')";// 2 es falta
        System.out.println(sql);
        if(db.operacion(sql)) {
            msj.aviso("Falta Ingresada");
        }else{
            msj.aviso("Error en Operacion");
        }
    }
    
    public String[] definirQuincena(String fecha){
        
        String fechaA;
        String fechaB;
        
        String[] fechas = fecha.split("-");
        int anio = Integer.parseInt(fechas[0]);
        int mes = Integer.parseInt(fechas[1]);
        int dia = Integer.parseInt(fechas[2]);
        if (dia<16){
            fechaA = anio+"-"+fechas[1]+"-01";
            fechaB = anio+"-"+fechas[1]+"-15";
        }else{
            fechaA = anio+"-"+fechas[1]+"-16";
            Calendar calendario = Calendar.getInstance();
            calendario.set(anio, mes-1, 1);
            int diaFinal = calendario.getActualMaximum(Calendar.DAY_OF_MONTH);
            fechaB = anio+"-"+fechas[1]+"-"+diaFinal;
        }
        
        String[] fechaAB = {fechaA, fechaB};
        return fechaAB;
    }
    
    //Copnsultas listados
   
    public Empleado[] listado(String dato, int op) {
        String sql = "SELECT  nficha, cc, grupo, ncuenta, cargo, sexo, rh, (pnombre || ' '|| snombre || ' '|| papellido ||' '||sapellido ) as nombre from empleado WHERE cc NOT LIKE '% %'";
        if(dato.equals("")){//si se envian espacios en blanco
            sql = "SELECT  nficha, cc, grupo, ncuenta, cargo, sexo, rh, (pnombre || ' '|| snombre || ' '|| papellido ||' '||sapellido ) as nombre from empleado WHERE cc NOT LIKE '% %'";
        }else if(op==1) {//nombre
            String[] nom = dato.split(" ");
            if(nom.length == 4) {//inicio loop para nombre completo
                sql = "SELECT  nficha, cc, grupo, ncuenta, cargo, sexo, rh, (pnombre || ' '|| snombre || ' '|| papellido ||' '||sapellido ) as nombre from empleado "
                        + "WHERE pnombre LIKE '%"+nom[0]+"%' OR  snombre LIKE '%"+nom[1]+"%' OR "
                        + "papellido LIKE '%"+nom[2]+"%' OR sapellido LIKE '%"+nom[3]+"%'";
            }else{
                sql = "SELECT  nficha, cc, grupo, ncuenta, cargo, sexo, rh, (pnombre || ' '|| snombre || ' '|| papellido ||' '||sapellido ) as nombre from empleado "
                        + "WHERE (pnombre LIKE '%"+nom[0]+"%' OR snombre LIKE '%"+nom[0]+"%' OR papellido LIKE '%"+nom[0]+"%' OR sapellido LIKE '%"+nom[0]+"%') AND cc NOT LIKE '% %'";
            }//fin condicion
        }else if(op==2) {//ficha
            sql = "SELECT  nficha, cc, grupo, ncuenta, cargo, sexo, rh, (pnombre || ' '|| snombre || ' '|| papellido ||' '||sapellido ) as nombre from empleado WHERE nficha="+dato+" AND cc NOT LIKE '% %'";
        }else if(op==3) {//cedula
            sql = "SELECT  nficha, cc, grupo, ncuenta, cargo, sexo, rh, (pnombre || ' '|| snombre || ' '|| papellido ||' '||sapellido ) as nombre from empleado WHERE cc="+dato+" AND cc NOT LIKE '% %'";
        }else if(op==4) {//grupo
            sql = "SELECT  nficha, cc, grupo, ncuenta, cargo, sexo, rh, (pnombre || ' '|| snombre || ' '|| papellido ||' '||sapellido ) as nombre from empleado WHERE grupo='"+dato+"' AND cc NOT LIKE '% %'";
        }
        ArrayList obj = db.listarEmpleadosNombre(sql);
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
    
    public Supervisor[] supervisores(){
        String sql = "SELECT nficha, cc, grupo, ncuenta, cargo, sexo, rh, (pnombre || ' '|| snombre || ' '|| papellido ||' '||sapellido )"
                + " as nombre from empleado WHERE supervisor = 1";
        ArrayList obj = db.listar(sql);
        System.out.println(obj.size());
        Supervisor[] datos= new Supervisor[obj.size()];
        int i=0;
        for(Object e:obj ){
            datos[i]= (Supervisor) e;
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
        String sql = "SELECT cc, nficha, pnombre, snombre, papellido, sapellido, ncuenta, grupo, cargo , sexo, rh, supervisor "
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
    
    public Empleado[] tomarAsistencia(){
        //String nombre completo, String cedula, int nFicha, String grupo, long ncuenta, String sexo, String rh, String cargo
        String sql = "SELECT cc, nficha, grupo, cargo, sexo, ncuenta, rh, (pnombre || ' '|| snombre || ' '|| papellido ||' '||sapellido ) "
                + "as nombre FROM empleado WHERE nficha > 10 ORDER BY grupo, nficha";
        
        ArrayList obj = db.listarEmpleadosNombre(sql);
        Empleado[] empleados = new Empleado[obj.size()];
        int i=0;
        for(Object e:obj ){
            empleados[i]= (Empleado) e;
            i++;
        }
        return empleados;
    }
    
}
