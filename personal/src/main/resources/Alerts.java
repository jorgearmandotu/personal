/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.resources;

import javax.swing.JOptionPane;

/**
 *
 * @author home
 */
public class Alerts {
    
    public void aviso(String msj){
        JOptionPane.showMessageDialog(null, msj, "Aviso", JOptionPane.INFORMATION_MESSAGE);
        //ERROR_MESSAGE, INFORMATION_MESSAGE, WARNING_MESSAGE, QUESTION_MESSAGE, o PLAIN_MESSAGE...
    }
    
    public void errormsj(String msj){
        JOptionPane.showMessageDialog(null, msj, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    public void dangermsj(String msj){
        JOptionPane.showMessageDialog(null, msj, "Error", JOptionPane.WARNING_MESSAGE);
    }
    
    public void questionmsj(String msj){
        JOptionPane.showMessageDialog(null, msj, "Error", JOptionPane.QUESTION_MESSAGE);
    }
    
}
