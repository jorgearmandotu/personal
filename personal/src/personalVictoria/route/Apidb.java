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

/**
 *
 * @author home
 */
public class Apidb {
    String separadorOS = System.getProperty("file.separator");
    String url="db"+separadorOS+"data.db";
    
    
    
    private Connection connect(){
        Connection connect=null;
        File data = new File(url);
        if (data.exists()){
            try{
                connect=DriverManager.getConnection("jdbc:sqlite:"+url);
                System.out.println("conexionexitosa");
            }catch(SQLException | NullPointerException ex){
                System.err.println("error al conectar a base de datos"+ex.getMessage());
                System.out.println("conexionexitosa");
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
            }
            if(close(con)){
                    System.out.println("Conexion terminada");
                }
        }else{
            System.out.println("imposible encontrar base de datos");
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
    
    public ArrayList listar(String sql){
        //ResultSet res = null;
        ArrayList<Empleado> obj= new ArrayList<>();
        Connection con = connect();
        if(con != null){
            try (Statement st = con.createStatement()) {
                ResultSet res = st.executeQuery(sql);
                while(res.next()){
                    int ficha = res.getInt("nficha");
                    String cc = res.getString("cc");
                    String nombre = res.getString("nombre");
                    String grupo = res.getString("grupo");
                    System.out.println(Integer.toString(ficha)+' '+cc+' '+nombre+' '+grupo);
                    Empleado emp = new Empleado(ficha, cc, nombre, grupo);
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
    
    public ArrayList listarEmp(String sql){
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
                    String nom = res.getString("nombreCargo");
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
    
    public AportesBonificaciones buscarAporte(String sql){
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
    
    
}