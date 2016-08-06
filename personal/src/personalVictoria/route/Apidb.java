/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalVictoria.route;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author home
 */
public class Apidb {
    String separadorOS = System.getProperty("file.separator");
    String url="db"+separadorOS+"data.db";
    
    
    
    public Connection connect(){
        Connection connect=null;
        try{
            connect=DriverManager.getConnection("jdbc:sqlite:"+url);
            System.out.println("conexionexitosa");
        }catch(SQLException | NullPointerException ex){
            System.err.println("error al conectar a base de datos"+ex.getMessage());
            System.out.println("conexionexitosa");
        }
        return connect;
    }
    public boolean close(Connection connect){
        boolean estado = false;
        try{
            connect.close();
            estado = true;
        }catch(SQLException ex){
            System.err.println("Error cerrando base de datos");
            estado = false;
        }
        return estado;
    }
    
    public boolean operacion(String sql, Connection con){
        boolean res = false;
        try {
            Statement st = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            st.executeUpdate(sql);
            st.close();
            res = true;
        } catch (SQLException ex) {
            Logger.getLogger(Apidb.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex.getMessage());
            res = false;
        }
        
        return res;
    }
}
