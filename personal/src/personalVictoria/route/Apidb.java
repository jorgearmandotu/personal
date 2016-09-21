/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalVictoria.route;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.resources.Alerts;
import main.resources.AportesBonificaciones;
import main.resources.Empleado;
import main.resources.Grupo;
import main.resources.IncapacidadesPermisos;
import main.resources.Supervisor;

/**
 *
 * @author home
 */
public class Apidb {
   
       
    
    private static Connection connect() {
        String separadorOS = System.getProperty("file.separator");
        String url;//+"db";
        File miDir = new File ("db"+separadorOS+"data.db");
                
        url = miDir.getAbsolutePath();
        Connection connect=null;
        File data = new File(url);
        if (data.exists()){
            try{
                connect = DriverManager.getConnection("jdbc:sqlite:"+url);
//                System.out.println("conexionexitosa");
            }catch(SQLException | NullPointerException ex){
                System.err.println("error al conectar a base de datos"+ex.getMessage());
//                System.out.println("conexionexitosa");
            }
        }else{
            System.out.println("Imposible encontrar base de datos");
            Alerts msj = new Alerts();
            msj.errormsj("No se a encontrado la base de datos");
        }
        return connect;
    }
    private boolean close(Connection connect){
        boolean estado;
        try{
            connect.close();
            estado = true;
        }catch(SQLException ex){
            System.err.println("Error cerrando base de datos");
            estado = false;
        }
        return estado;
    }
    
    public boolean operacion(String sql){
        boolean res = false;
        Connection con = connect();
        if(con!=null){
            try {
                try (Statement st = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)) {
                    st.executeUpdate(sql);
                    //st.close(); -> esto iria si no se usara en try with resources ya q siempre debe cerrarse el statement
                }
                res = true;
            } catch (SQLException ex) {
                Logger.getLogger(Apidb.class.getName()).log(Level.SEVERE, null, ex);
                System.err.println(ex.getMessage());
                res = false;
                Alerts msj = new Alerts();
                msj.errormsj(ex.getMessage());
            }
            if(close(con)){
                    System.out.println("Conexion terminada");
                }
        }else{
            System.out.println("imposible encontrar base de datos");
            Alerts msj = new Alerts();
                msj.errormsj("imposible encontrar base de datos");
        }
        return res;
    }
    
    public boolean operacionTransaccion(String sql, String sql2){
        boolean res = false;
        Connection con = connect();
        if(con!=null){
            try {
                con.setAutoCommit(false);
                Statement st2;
                try (Statement st = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)) {
                    st2 = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
                    st.executeUpdate(sql);
                    st2.executeUpdate(sql2);
                }
                st2.close();
                con.commit();
                con.setAutoCommit(true);
                    //st.close(); -> esto iria si no se usara en try with resources ya q siempre debe cerrarse el statement
                
                res = true;
            } catch (SQLException ex) {
                try {
                    con.rollback();
                    con.setAutoCommit(true);
                } catch (SQLException ex1) {
                    Logger.getLogger(Apidb.class.getName()).log(Level.SEVERE, null, ex1);
                }
                Logger.getLogger(Apidb.class.getName()).log(Level.SEVERE, null, ex);
                System.err.println(ex.getMessage());
                res = false;
                Alerts msj = new Alerts();
                msj.errormsj(ex.getMessage());
            }
            
            if(close(con)){
                    System.out.println("Conexion terminada");
                }
        }else{
            System.out.println("imposible encontrar base de datos");
            Alerts msj = new Alerts();
                msj.errormsj("imposible encontrar base de datos");
        }
        return res;
    }
    
    
    
    public boolean consulta(String sql){
        boolean res=false;
        Connection con = connect();
        if(con == null){
            System.out.println("imposible encontrar base de datos");
        }else{
            try{
                try (Statement st = con.createStatement()) {
                    st.executeQuery(sql);
                }
            }catch(SQLException  ex){
                
            }
        }
        
        
        return res;
    }
    
    public ArrayList listar(String sql){// este metodo crea un nombre completo con los registrods de db
        //ResultSet res = null;
        //System.out.println(sql);
        ArrayList<Supervisor> obj= new ArrayList<>();
        Connection con = connect();
        if(con != null){
            try (Statement st = con.createStatement()) {
                ResultSet res = st.executeQuery(sql);
                while(res.next()){
                    //String nombre completo, String cedula, int nFicha, String grupo, long ncuenta, String sexo, String rh, String cargo
                    int ficha = res.getInt("nficha");
                    String cc = res.getString("cc");
                    String nombre = res.getString("nombre");
                    String grupo = res.getString("grupo");
                    long cuenta = res.getInt("ncuenta");
                    String cargo = res.getString("cargo");
                    String sexo = res.getString("sexo");
                    String rh = res.getString("rh");
                    //System.out.println(Integer.toString(ficha)+' '+cc+' '+nombre+' '+grupo);
                    Supervisor sup = new Supervisor(nombre, cc, ficha, grupo, cuenta, sexo, rh, cargo);
                    obj.add(sup);
                }
            }catch(SQLException ex){
                System.err.println(ex.getMessage());
                Alerts msj = new Alerts();
                msj.errormsj("Ocurrio un error al consultar los datos");
            }
            if(close(con)) System.out.println("conexion cerrada");
        }
        return obj;
    }
    
    public ArrayList listarEmpleadosNombre(String sql){// este metodo crea un nombre completo con los registrods de db
        //ResultSet res = null;
        
        ArrayList<Empleado> obj= new ArrayList<>();
        Connection con = connect();
        if(con != null){
            try (Statement st = con.createStatement()) {
                ResultSet res = st.executeQuery(sql);
                while(res.next()){
                    //String nombre completo, String cedula, int nFicha, String grupo, long ncuenta, String sexo, String rh, String cargo
                    int ficha = res.getInt("nficha");
                    String cc = res.getString("cc");
                    String nombre = res.getString("nombre");
                    String grupo = res.getString("grupo");
                    long cuenta = res.getInt("ncuenta");
                    String cargo = res.getString("cargo");
                    String sexo = res.getString("sexo");
                    String rh = res.getString("rh");
                    String photo = res.getString("photo");
                    
                        Empleado sup = new Empleado(ficha, cc, nombre, grupo, cuenta, cargo, sexo, rh, photo);
                    obj.add(sup);
                }
            }catch(SQLException ex){
                System.err.println(ex.getMessage());
                Alerts msj = new Alerts();
                msj.errormsj("Ocurrio un error al consultar los datos");
            }
            if(close(con)) System.out.println("conexion cerrada");
        }
        return obj;
    }
    
    
    
    public ArrayList listarGrupos(String sql){
        ArrayList<Grupo> obj = new ArrayList<>();
        Connection con = connect();
        if(con != null){
            try (Statement st = con.createStatement()){
                ResultSet res = st.executeQuery(sql);
                while(res.next()){
                    String nom = res.getString("nombreGrupo");
                    String sup = res.getString("supervisor");
                    String id = res.getString("idGrupo");
                    Grupo grup= new Grupo(nom, sup, id);
                    obj.add(grup);
                }
            }catch(SQLException ex){
                System.err.println(ex.getMessage());
                Alerts msj = new Alerts();
                msj.errormsj("Ocurrio un error al consultar los datos");
            }
            if(close(con)) System.out.println("conexion cerrada");
        }
        return obj;
    }
    
    public ArrayList listarEmp(String sql){//listar deducciones bonificaciones
        ArrayList<AportesBonificaciones> obj = new ArrayList<>();
        Connection con = connect();
        if(con != null){
            try (Statement st = con.createStatement()){
                ResultSet res = st.executeQuery(sql);
                while(res.next()){
                    int id = res.getInt("idAporte");
                    String nom = res.getString("nombreAporte");
                    String tipo = res.getString("tipoAporte");
                    float val = res.getFloat("valorAporte");
                    AportesBonificaciones emp = new AportesBonificaciones(id, nom, tipo, val);
                    obj.add(emp);
                }
            }catch(SQLException ex){
                System.err.println(ex.getMessage());
                Alerts msj = new Alerts();
                msj.errormsj("Ocurrio un error al consultar los datos");
            }
            if(close(con)) System.out.println("conexion cerrada");
        }
        return obj;
    }
    
    public ArrayList listarCargos(String sql){
        ArrayList<String> obj = new ArrayList<>();
        Connection con = connect();
        if(con != null){
            try (Statement st = con.createStatement()){
                ResultSet res = st.executeQuery(sql);
                while(res.next()){
                    String nom = res.getString("cargo");
                    obj.add(nom);
                }
            }catch(SQLException ex){
                System.err.println(ex.getMessage());
                Alerts msj = new Alerts();
                msj.errormsj("Ocurrio un error al consultar los datos");
            }
            if(close(con)) System.out.println("conexion cerrada");
        }
        return obj;
    }
    
    public AportesBonificaciones buscarAporte(String sql){// busca un deducido o bonid¿ficacion
        AportesBonificaciones obj = null;
        Connection con = connect();
        if(con != null){
            try (Statement st = con.createStatement()){
                ResultSet res = st.executeQuery(sql);
                int id = res.getInt("idAporte");
                String nombre = res.getString("nombreAporte");
                String tipo = res.getString("tipoAporte");
                float valor = res.getFloat("valorAporte");
                obj = new AportesBonificaciones(id, nombre, tipo, valor);
            }catch(SQLException ex){
                System.err.println(ex.getMessage());
                Alerts msj = new Alerts();
                msj.errormsj("Ocurrio un error al consultar los datos");
            }
            if(close(con)) System.out.println("conexion cerrada");
        }
        return obj;
    }
    
    public ArrayList<Empleado> empleados(String sql) {//retorna un listado de empleados
        ArrayList<Empleado> obj = new ArrayList<Empleado>();
        Connection con = connect();
        if(con != null){
            try (Statement st = con.createStatement()){
                ResultSet res = st.executeQuery(sql);
                while(res.next()){
                    String cedula = res.getString("cc");
                    String pNombre = res.getString("pnombre");
                    String sNombre = res.getString("snombre");
                    String pApellido = res.getString("papellido");
                    String sApellido = res.getString("sapellido");
                    int nFicha = res.getInt("nficha");
                    long nCuenta = res.getLong("ncuenta");
                    String grupo = res.getString("grupo");
                    String cargo = res.getString("cargo");
                    String sexo = res.getString("sexo");
                    String rh = res.getString("rh");
                    int supervisor = res.getInt("supervisor");
                    int auxTransporte = res.getInt("auxTransporte");
                    Empleado emp = new Empleado(cedula, pNombre, sNombre, pApellido, sApellido, nFicha, 
                            nCuenta, grupo, cargo, sexo, rh, supervisor, auxTransporte);
                    obj.add(emp);
                }
            }catch(SQLException ex){
                System.err.println(ex.getMessage());
                Alerts msj = new Alerts();
                msj.errormsj("Ocurrio un error al consultar los datos");
            }
            if(close(con)) System.out.println("conexion cerrada");
        }
        return obj;
    }
    
    public IncapacidadesPermisos permisoExistente(String sql) {
        IncapacidadesPermisos obj = null;
        Connection con = connect();
        if(con != null){
            try (Statement st = con.createStatement()) {
                ResultSet res = st.executeQuery(sql);
                while(res.next()){
                    String cc = res.getString("cc_Empleado");
                    String fechaA = res.getString("fechaA");
                    String fechaB = res.getString("fechaB");
                    int tipo = res.getInt("tipoFalta");
                    int pagada = res.getInt("pagada");
                    if (!cc.equals("")) obj = new IncapacidadesPermisos(cc, fechaA, fechaB, tipo, pagada); 
                }
            }catch(SQLException ex){
                System.err.println(ex.getMessage());
                Alerts msj = new Alerts();
                msj.errormsj("Ocurrio un error al consultar los datos");
            }
            if(close(con)) System.out.println("conexion cerrada");
        }
        return obj;
    }
    
    public Grupo maxGrupo(String sql){
        Grupo obj = null;
        Connection con = connect();
        if(con != null){
            try (Statement st = con.createStatement()) {
                ResultSet res = st.executeQuery(sql);
                System.out.println("esta es el row coño  "+res);
                try{
                    while(res.next()){
                        String nombre = res.getString("nombreGrupo");
                        String supervisor = res.getString("supervisor");
                        String id = res.getString("idGrupo");
                        obj = new Grupo(nombre, supervisor, id);
                    }
                }catch(Exception ex){
                    System.err.println(ex);
                    
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(Apidb.class.getName()).log(Level.SEVERE, null, ex);
                obj = null;
            }
                    
        }
        return obj;
    }
    
    public ArrayList faltas(String sql) {
        ArrayList<String> cedulas = new ArrayList<>();
        Connection con = connect();
        if(con != null){
            try (Statement st = con.createStatement()){
                ResultSet res = st.executeQuery(sql);
                while(res.next()){
                    String ced = res.getString("ccEmpleado");
                    cedulas.add(ced);
                }
            }catch(SQLException ex){
                System.err.println(ex.getMessage());
                Alerts msj = new Alerts();
                msj.errormsj("Ocurrio un error al consultar los datos");
            }
            close(con);
        }
        return cedulas;
    }
    
    public Grupo grupo(String sql){
        Grupo grupo = null;
        Connection con = connect();
        if (con != null){
            try (Statement st = con.createStatement()){
                ResultSet res = st.executeQuery(sql);
                while(res.next()){
                    String nombre = res.getString("nombreGrupo");
                    String id = res.getString("idGrupo");
                    String supervisor = res.getString("supervisor");
                    grupo = new Grupo(nombre, supervisor, id);
                }
            }catch(SQLException ex){
                System.err.println(ex.getMessage());
                Alerts msj = new Alerts();
                msj.errormsj("Ocurrio un error al consultar los datos");
            }
            close(con);
        }
        return grupo;
    }
    
    public ArrayList<AportesBonificaciones> entidades(String sql){
        ArrayList<AportesBonificaciones> entidad = new ArrayList<>();
        Connection con = connect();
        if(con!=null) {
            try (Statement st = con.createStatement()){
                ResultSet res = st.executeQuery(sql);
                while(res.next()){
                int idAporte = res.getInt("idAporte");
                String nombre = res.getString("nombreAporte");
                String tipo = res.getString("tipoAporte");
                float valor = res.getFloat("valorAporte");
                AportesBonificaciones ent = new AportesBonificaciones(idAporte, nombre, tipo, valor);
                entidad.add(ent);
            }
            }catch(SQLException ex) {
                System.err.println(ex.getMessage());
                Alerts msj = new Alerts();
                msj.errormsj("Error al consultar DB");
            }
            close(con);
        }
        return entidad;
    }
    
    public AportesBonificaciones entidad(String sql){
        AportesBonificaciones ent = null;
        Connection con = connect();
        if(con!=null) {
            try (Statement st = con.createStatement()){
                ResultSet res = st.executeQuery(sql);
                while(res.next()){
                int idAporte = res.getInt("idAporte");
                String nombre = res.getString("nombreAporte");
                String tipo = res.getString("tipoAporte");
                float valor = res.getFloat("valorAporte");
                ent = new AportesBonificaciones(idAporte, nombre, tipo, valor);                
            }
            }catch(SQLException ex) {
                System.err.println(ex.getMessage());
                Alerts msj = new Alerts();
                msj.errormsj("Error al consultar DB");
            }
            close(con);
        }
        return ent;
    }
    
    public ArrayList<String> prestacionesEmpleado(String sql){
        ArrayList<String> result = new ArrayList<>();
        Connection con = connect();
        if(con != null){
            try (Statement st = con.createStatement()){
                ResultSet res = st.executeQuery(sql);
                while(res.next()){
                    String id = res.getString("iddeduccion");
                    result.add(id);
                }
            }catch(SQLException ex){
                System.err.println(ex.getMessage());
                Alerts msj = new Alerts();
                msj.errormsj("Ocurrio un error al consultar los datos");
            }
            close(con);
        }
        return result;
    }
    
}