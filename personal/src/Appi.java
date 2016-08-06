/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import personalVictoria.route.Apidb;

/**
 *
 * @author home
 */
public class Appi {
    
    Apidb db = new Apidb();
    
    public void conexiondb(){
        Connection con = db.connect();
        String sql = "INSERT INTO `empleado`('cc','nficha','1ernombre','2donombre','1erapellido','2doapellido','#cuenta',"
                + "'supervisor') VALUES ('123',1,'andres','steven','narvaez','gomez',33,'juan');";
        if(db.operacion(sql, con)){
            System.out.println("ingreso exitoso");
        }else{
            System.out.println("error en ingreso");
        }
        if(db.close(con)){
            System.out.println("conexion terminada");
        }
    }
   
}
