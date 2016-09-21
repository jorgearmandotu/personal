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
         
        String sql = "INSERT INTO `empleado`('cc','nficha','pnombre','snombre','papellido','sapellido',"
                + "'ncuenta','grupo', 'cargo', 'sexo', 'rh', 'supervisor', 'auxTransporte') "
                + "VALUES('"+emp.getCedula()+"',"+emp.getnFicha()+",'"+emp.getpNombre()+"','"+emp.getsNombre()+"','"+emp.getpApellido()
                +"','"+emp.getsApellido()+"',"+emp.getnCuenta()+",'"+emp.getGrupo()+"', '"+emp.getCargo()+"', '"+emp.getSexo()+"',"
                + " '"+emp.getRh()+"', "+emp.getSupervisor()+", "+emp.getAuxTransporte()+");";
        if(db.operacion(sql)){
            msj.aviso("Ingreso exitoso");
            res = true;
        }else{
            msj.errormsj("Error en operacion");
            res = false;
        }
        
        return res;
    }
    
    public boolean ingresoGrupo(String nom, String cedsupervisor){
        boolean res;
        Alerts msj = new Alerts();
        Grupo obj = null;
        obj = db.maxGrupo("select  nombreGrupo, supervisor, max(idgrupo) as idGrupo from grupos");
        int idgrupo = 0;
        if(obj.getId() != null){
            
            idgrupo = Integer.parseInt(obj.getId());
            
        }
        
        
        idgrupo++;
        String sql = "UPDATE grupos SET supervisor = 'N' WHERE supervisor ='"+cedsupervisor+"';"
                + "Insert INTO grupos (nombreGrupo, supervisor, idGrupo)"
                + "VALUES ('"+nom+"', '"+cedsupervisor+"', "+idgrupo+")";
        
        String sql2 = "UPDATE empleado SET grupo = '"+idgrupo+"' WHERE cc = '"+cedsupervisor+"'";
       
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
    
    public boolean eliminarFalta(String ficha){
        boolean res = false;
        Alerts msj = new Alerts();
        Date fechaActual = new Date();
        DateFormat formato = new SimpleDateFormat("YYYY-MM-dd");
        String fecha = formato.format(fechaActual);
        Empleado emp = empleadoFicha(ficha);
        if(emp != null){
            String sql = "DELETE FROM asistencia WHERE ccEmpleado = '"+emp.getCedula()+"' AND fechafalta = '"+fecha+"'";
            if(!db.operacion(sql)) msj.errormsj("Error en operacion");
            else res = true;
        }else{
            msj.errormsj("Empleado no existe");
        }
        return res;
    }
    
    public void insertarIncapacidadesPermisos(String cedula, String fechaA, String fechaB, int pagadas, int tipo){
        Alerts msj = new Alerts();
          String sql = "INSERT INTO incapacidadesPermisos (cc_Empleado, fechaA, fechaB, tipoFalta, pagada) "
                  + "VALUES ('"+cedula+"', '"+fechaA+"', '"+fechaB+"', "+tipo+", "+pagadas+")";
        
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
        
        String sql = "INSERT INTO asistencia (ccEmpleado, quincenaFechaA, quincenaFechaB, falta, FechaFalta)"
                + "VALUES ('"+cc+"','"+fechaA+"', '"+fechaB+"', "+2+", '"+fecha+"')";// 2 es falta
       
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
       ;
        String sql = "INSERT INTO asistencia (ccEmpleado, quincenaFechaA, quincenaFechaB, falta, FechaFalta)"
                + "VALUES ('"+cc+"','"+fechaA+"', '"+fechaB+"', "+2+", '"+fecha+"')";// 2 es falta
        
        if(db.operacion(sql)) {
            msj.aviso("Falta Ingresada");
        }else{
            msj.aviso("Error en Operacion");
        }
    }
    
    public void ingresoPhoto(String cc, String ruta){
        Alerts msj = new Alerts();
        String sql = "UPDATE empleado SET photo = '"+ruta+"' WHERE cc = '"+cc+"'";
        if(!db.operacion(sql)){
            msj.errormsj("Error en Ingreso photograpia");
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
        String sql = "SELECT  nficha, cc, grupo, ncuenta, cargo, sexo, rh, photo, (pnombre || ' '|| snombre || ' '|| papellido ||' '||sapellido ) as nombre from empleado WHERE cc NOT LIKE '% %'";
        if(dato.equals("")){//si se envian espacios en blanco
            sql = "SELECT  nficha, cc, grupo, ncuenta, cargo, sexo, rh, photo, (pnombre || ' '|| snombre || ' '|| papellido ||' '||sapellido ) as nombre from empleado WHERE cc NOT LIKE '% %'";
        }else if(op==1) {//nombre
            String[] nom = dato.split(" ");
            if(nom.length == 4) {//inicio loop para nombre completo
                sql = "SELECT  nficha, cc, grupo, ncuenta, cargo, sexo, rh, photo, (pnombre || ' '|| snombre || ' '|| papellido ||' '||sapellido ) as nombre from empleado "
                        + "WHERE pnombre LIKE '%"+nom[0]+"%' OR  snombre LIKE '%"+nom[1]+"%' OR "
                        + "papellido LIKE '%"+nom[2]+"%' OR sapellido LIKE '%"+nom[3]+"%'";
            }else{
                sql = "SELECT  nficha, cc, grupo, ncuenta, cargo, sexo, rh, photo, (pnombre || ' '|| snombre || ' '|| papellido ||' '||sapellido ) as nombre from empleado "
                        + "WHERE (pnombre LIKE '%"+nom[0]+"%' OR snombre LIKE '%"+nom[0]+"%' OR papellido LIKE '%"+nom[0]+"%' OR sapellido LIKE '%"+nom[0]+"%') AND cc NOT LIKE '% %'";
            }//fin condicion
        }else if(op==2) {//ficha
            sql = "SELECT  nficha, cc, grupo, ncuenta, cargo, sexo, rh, photo, (pnombre || ' '|| snombre || ' '|| papellido ||' '||sapellido ) as nombre from empleado WHERE nficha="+dato+" AND cc NOT LIKE '% %'";
        }else if(op==3) {//cedula
            sql = "SELECT  nficha, cc, grupo, ncuenta, cargo, sexo, rh, photo, (pnombre || ' '|| snombre || ' '|| papellido ||' '||sapellido ) as nombre from empleado WHERE cc="+dato+" AND cc NOT LIKE '% %'";
        }else if(op==4) {//grupo
            sql = "SELECT  nficha, cc, grupo, ncuenta, cargo, sexo, rh, photo, (pnombre || ' '|| snombre || ' '|| papellido ||' '||sapellido ) as nombre from empleado WHERE grupo='"+dato+"' AND cc NOT LIKE '% %'";
        }
        ArrayList obj = db.listarEmpleadosNombre(sql);
        
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
        String sql = "SELECT cc, nficha, pnombre, snombre, papellido, sapellido, ncuenta, grupo, cargo , sexo, rh, supervisor, auxTransporte "
                + "FROM empleado WHERE cc = '"+cc+"'";
        ArrayList list = db.empleados(sql);
        Empleado emp = null;
        for(Object e :list){
            emp = (Empleado) e;
        }
        return emp;
    }
    
    public Empleado empleadoFicha(String ficha){
        String sql = "SELECT cc, nficha, pnombre, snombre, papellido, sapellido, ncuenta, grupo, cargo , sexo, rh, supervisor, auxTransporte "
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
    public IncapacidadesPermisos consultaIncPermiso(String cc, String fecha){
        IncapacidadesPermisos res = null;
        String sql = "SELECT * from incapacidadesPermisos where cc_Empleado='"+cc+"' AND fechaA<='"+fecha+"' AND fechaB >= '"+fecha+"';";
        res = db.permisoExistente(sql);
        return res;
    }
    
    //Consulta resta select para llamar asistencia
    //select cc from empleado except select distinct cc_Empleado from  incapacidadesPermisos
    
    public Empleado[] tomarAsistencia(){
        //String nombre completo, String cedula, int nFicha, String grupo, long ncuenta, String sexo, String rh, String cargo
        String sql = "SELECT cc, nficha, grupo, cargo, sexo, ncuenta, rh, photo, (pnombre || ' '|| snombre || ' '|| papellido ||' '||sapellido ) "
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
    
    public ArrayList<Empleado> faltas(String fecha){
        //SELECT cc, nficha, pnombre, papelldo, sapellido, ncuenta, grupo, cargo, sexo, rh, supervisor FROM asistencia 
        //JOIN empleado WHERE fechaFalta = '2016-09-01' AND ccEmpleado = cc  ORDER BY grupo
        //String sql = "SELECT ccEmpleado FROM asistencia where fechafalta= '"+fecha+"';";
        String sql = "SELECT cc, nficha, pnombre, snombre, papellido, sapellido, ncuenta, grupo, cargo, sexo, rh, supervisor, auxTransporte "
                + "FROM asistencia JOIN empleado WHERE fechaFalta = '"+fecha+"' AND ccEmpleado = cc  ORDER BY grupo";
        ArrayList<Empleado> emp = db.empleados(sql);
        
        return emp;
    }
    
    public Empleado faltaEmpleado(String fecha, String cc){
        String sql = "SELECT cc, nficha, pnombre, snombre, papellido, sapellido, ncuenta, grupo, cargo, sexo, rh, supervisor, auxTransporte "
                + "FROM asistencia JOIN empleado WHERE fechaFalta = '"+fecha+"' AND ccEmpleado = cc AND cc='"+cc+"'";
        
        ArrayList<Empleado> emp = db.empleados(sql);
        Empleado empleado = null;
        if(!emp.isEmpty()) empleado = emp.get(0);
        return empleado;
    }
    
    public ArrayList<Empleado> empleadosTotales(){
        String sql = "SELECT * FROM empleado ORDER BY grupo, supervisor DESC, nficha";
        ArrayList<Empleado> emp = db.empleados(sql);
        return emp;
    }
    
    public Grupo grupo(String id){
       
         String sql = "SELECT nombreGrupo, idGrupo, supervisor FROM grupos WHERE idGrupo = "+id;
         Grupo grupo = db.grupo(sql);
         return grupo;
    }
    
    public ArrayList<String> diasAsistencia(String cc){
        Date fecha = new Date();
        DateFormat formato = new SimpleDateFormat("YYYY-MM-dd");
        String fechaActual = formato.format(fecha);
        String[] fechas = definirQuincena(fechaActual);
        ArrayList<String> asist = new ArrayList<>();
        boolean loop = true;
        String fechaAux = fechas[0];
        int dias=0;
        while(loop){
        if(fechaActual.compareTo(fechaAux)>=0){
            //System.out.println(fechaAux);
            String[] fec = fechaAux.split("-");
            int dia = Integer.parseInt(fec[2]);
            dia++;
            Empleado emp = faltaEmpleado(fechaAux, cc);
            if(emp==null){
                IncapacidadesPermisos inc = consultaIncPermiso(cc, fechaAux);
                if(inc != null){
                    switch (inc.getTipo()) {
                        case 0:
                            //0 incaoacidad, 1 permiso,3 permiso medio dia, 2 falta
                            asist.add("I");
                            break;
                        case 1:
                            asist.add("P");
                            break;
                        case 3:
                            asist.add("%");
                            break;
                        default:
                            break;
                    }
                }else{
                    asist.add("X");
                }
                
            }else{
                IncapacidadesPermisos inc = consultaIncPermiso(cc, fechaAux);
                if(inc != null){
                    switch (inc.getTipo()) {
                        case 0:
                            //0 incaoacidad, 1 permiso,2 falta, 3 medio dia permiso
                            asist.add("I");
                            break;
                        case 1:
                            asist.add("P");
                            break;
                        case 3:
                            asist.add("%");
                            break;
                        default:
                            break;
                    }
                }else{
                    asist.add("N");
                }
            }
            
            if(dia<10) fechaAux = fec[0]+"-"+fec[1]+"-0"+dia;
            else fechaAux = fec[0]+"-"+fec[1]+"-"+dia;
            dias++;
        }else{
            loop = false;
        }
        
    }
        return asist;
    }
    
    public ArrayList<AportesBonificaciones> entidades(){
        ArrayList<AportesBonificaciones> entidades = null;
        String sql = "SELECT * FROM aportesbonificaciones";
        entidades = db.entidades(sql);
        return entidades;
    }
    
    public AportesBonificaciones entidad(String nombre){
        String sql = "SELECT * FROM aportesBonificaciones WHERE nombreAporte = '"+nombre+"'";
        AportesBonificaciones ent = db.entidad(sql);
        return ent;
    }
    public AportesBonificaciones entidadID(String id){
        String sql = "SELECT * FROM aportesBonificaciones WHERE idAporte = '"+id+"'";
        AportesBonificaciones ent = db.entidad(sql);
        return ent;
    }
    
    public ArrayList<AportesBonificaciones> deduccionesEmpleado(String cc){
        String sql = "SELECT iddeduccion FROM deducidosBonificaciones WHERE cedulaEmp = '"+cc+"';";
        ArrayList<String> ids = db.prestacionesEmpleado(sql);
        ArrayList<AportesBonificaciones> aportes = new ArrayList<>();
        if(ids != null){
            for(int i=0; i< ids.size(); i++){
                if(ids.get(i) != null) aportes.add(entidadID(ids.get(i)));
            }
        }
        return aportes;
    }
}
