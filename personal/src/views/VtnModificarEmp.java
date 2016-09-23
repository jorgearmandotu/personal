/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.io.File;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import main.Appi;
import main.resources.Alerts;
import main.resources.AportesBonificaciones;
import main.resources.Empleado;
import main.resources.Grupo;

/**
 *
 * @author armando
 */
public class VtnModificarEmp extends javax.swing.JDialog {

    /**
     * Creates new form ModificarEmp
     */
    public VtnModificarEmp(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtModNom = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtModFicha = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtModCedula = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtModRh = new javax.swing.JTextField();
        cmbModArl = new javax.swing.JComboBox<>();
        cmbModPension = new javax.swing.JComboBox<>();
        txtModNcuenta = new javax.swing.JTextField();
        cmbModGrupo = new javax.swing.JComboBox<>();
        cmbModEps = new javax.swing.JComboBox<>();
        cmbModCargo = new javax.swing.JComboBox<>();
        chkModAuxTransporte = new javax.swing.JCheckBox();
        cmbModSexo = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        cmbModBonificacion = new javax.swing.JComboBox<>();
        lblModPhoto = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lblModRutaPhoto = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtModNom.setEditable(false);

        jLabel5.setText("ARL:");

        jLabel6.setText("Pension:");

        txtModCedula.setEditable(false);

        jLabel7.setText("RH:");

        jLabel8.setText("Grupo:");

        jLabel9.setText("Cargo:");

        jLabel10.setText("N° Cuenta:");

        jLabel11.setText("Sexo:");

        jLabel1.setText("Cedula:");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Ficha:");

        jLabel4.setText("EPS:");

        cmbModArl.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbModPension.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbModGrupo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbModEps.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbModCargo.setEditable(true);
        cmbModCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbModCargo.setToolTipText("");

        chkModAuxTransporte.setText("Auxilio Transporte");
        chkModAuxTransporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkModAuxTransporteActionPerformed(evt);
            }
        });

        cmbModSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "F" }));

        jLabel12.setText("Bonificacion:");

        cmbModBonificacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblModPhoto.setBackground(new java.awt.Color(255, 255, 255));
        lblModPhoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblModPhoto.setText("Fotografia");
        lblModPhoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton1.setText("Cambiar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lblModRutaPhoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton2.setText("Modificar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel3))
                                    .addGap(254, 254, 254))
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(12, 12, 12)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtModRh)
                                            .addComponent(txtModNom, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtModCedula, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtModFicha, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(cmbModGrupo, 0, 200, Short.MAX_VALUE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel8))
                                        .addGap(18, 18, 18)
                                        .addComponent(cmbModCargo, 0, 200, Short.MAX_VALUE)))
                                .addGap(30, 30, 30)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbModArl, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbModPension, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbModEps, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtModNcuenta)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(cmbModSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(chkModAuxTransporte)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(cmbModBonificacion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jLabel12)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(lblModPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(lblModRutaPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(237, 237, 237)
                        .addComponent(jButton2)))
                .addContainerGap(94, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(txtModCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(cmbModEps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(cmbModArl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtModNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel6)
                    .addComponent(cmbModPension, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtModFicha, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtModNcuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtModRh, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel8)
                    .addComponent(cmbModGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(cmbModSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkModAuxTransporte))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cmbModCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(cmbModBonificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblModPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(lblModRutaPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chkModAuxTransporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkModAuxTransporteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkModAuxTransporteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        JFileChooser photo = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.jpg", "jpg");
        photo.setFileFilter(filtro);
        ImagePreviewPanel preview = new ImagePreviewPanel();
        photo.setAccessory(preview);
        photo.addPropertyChangeListener(preview);
        int select = photo.showOpenDialog(this);
        File rutaPhoto = null;
        switch (select) {
            case JFileChooser.APPROVE_OPTION:
            rutaPhoto = photo.getSelectedFile();
            lblModRutaPhoto.setText(String.valueOf(rutaPhoto));
            break;
            case JFileChooser.CANCEL_OPTION:
            break;
            case JFileChooser.ERROR_OPTION:
            Alerts msj = new Alerts();
            msj.errormsj("Ocurrio un error en Operación");
            break;
            default:
            break;
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if(verificarCampos()){
            System.out.println("exito");
        }else System.out.println("error en cadenas");
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VtnModificarEmp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VtnModificarEmp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VtnModificarEmp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VtnModificarEmp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VtnModificarEmp dialog = new VtnModificarEmp(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox chkModAuxTransporte;
    private javax.swing.JComboBox<String> cmbModArl;
    private javax.swing.JComboBox<String> cmbModBonificacion;
    private javax.swing.JComboBox<String> cmbModCargo;
    private javax.swing.JComboBox<String> cmbModEps;
    private javax.swing.JComboBox<String> cmbModGrupo;
    private javax.swing.JComboBox<String> cmbModPension;
    private javax.swing.JComboBox<String> cmbModSexo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblModPhoto;
    private javax.swing.JLabel lblModRutaPhoto;
    private javax.swing.JTextField txtModCedula;
    private javax.swing.JTextField txtModFicha;
    private javax.swing.JTextField txtModNcuenta;
    private javax.swing.JTextField txtModNom;
    private javax.swing.JTextField txtModRh;
    // End of variables declaration//GEN-END:variables

public void listarEmpleado(Empleado emp){
    llenarCombos();
    txtModNom.setText(emp.getpNombre()+" "+emp.getsNombre()+" "+emp.getpApellido()+" "+emp.getsApellido());
    txtModCedula.setText(emp.getCedula());
    txtModFicha.setText(String.valueOf(emp.getnFicha()));
    txtModNcuenta.setText(String.valueOf(emp.getnCuenta()));
    txtModRh.setText(emp.getRh());
    if(emp.getAuxTransporte()==1) chkModAuxTransporte.setSelected(true);
    else chkModAuxTransporte.setSelected(false);
    if(emp.getSexo().equals("M")) cmbModSexo.setSelectedItem("M");
    else cmbModSexo.setSelectedItem("F");
    String idgrupo = emp.getGrupo();
    Appi app = new Appi();
    Grupo grp = app.grupo(idgrupo);
    cmbModGrupo.setSelectedItem(grp.getNombre());
    cmbModCargo.setSelectedItem(emp.getCargo());
    
    ArrayList<AportesBonificaciones> aportes = app.deduccionesEmpleado(emp.getCedula());
        String eps="";
        String arl="";
        String pension="";
        String bonificacion="";
        if(aportes != null){
            for (AportesBonificaciones aporte : aportes) {
                switch (aporte.getTipo()) {
                    case "EPS":
                        eps = aporte.getNombre();
                        cmbModEps.setSelectedItem(eps);
                        break;
                    case "PENSIONES":
                        pension = aporte.getNombre();
                        cmbModPension.setSelectedItem(pension);
                        break;
                    case "ARL":
                        arl = aporte.getNombre();
                        cmbModArl.setSelectedItem(arl);
                        break;
                    case "BONIFICACION":
                        bonificacion = String.valueOf(aporte.getNombre());
                        cmbModBonificacion.setSelectedItem(bonificacion);
                        break;
                
                }
            }
        }
    String separadorOS = System.getProperty("file.separator");
    File miDirPhoto = new File ("images"+separadorOS+emp.getPhoto());
    String urlphoto = miDirPhoto.getAbsolutePath();
    ImageIcon photo = new ImageIcon(urlphoto);
    lblModPhoto.setIcon(photo);
}

private void llenarCombos(){
    Grupo[] datos;// = null;
    Appi app = new Appi();
    datos = app.cmbgrupo();
    cmbModGrupo.removeAllItems();
    cmbModGrupo.addItem("N");
    for (Grupo dato : datos) {
        cmbModGrupo.addItem(dato.getNombre());
    }
    
    String[] data;
    data = app.cmbcargos();
    cmbModCargo.removeAllItems();
    for(String cargo : data) {
        cmbModCargo.addItem(cargo);
    }
    
     AportesBonificaciones[] emp;
    emp = app.listEmp();
    cmbModBonificacion.removeAllItems();
    cmbModBonificacion.addItem("N");
    cmbModEps.removeAllItems();
    cmbModEps.addItem("N");
    cmbModArl.removeAllItems();
    cmbModArl.addItem("N");
    cmbModPension.removeAllItems();
    cmbModPension.addItem("N");
    for(AportesBonificaciones empleado : emp){
        switch (empleado.getTipo()) {
            case "BONIFICACION":
                String nombonifi = empleado.getNombre();
                cmbModBonificacion.addItem(nombonifi);
                break;
            case "EPS":
                String nomEps = empleado.getNombre();
                cmbModEps.addItem(nomEps);
                break;
            case "ARL":
                String nomArl = empleado.getNombre();
                cmbModArl.addItem(nomArl);
                break;
            case "PENSIONES":
                String nompension = empleado.getNombre();
                cmbModPension.addItem(nompension);
                break;
        }
    }
    
}
 
private void modificar(){
    int ficha = Integer.parseInt(txtModFicha.getText().trim());
    String cedula = txtModCedula.getText().trim();
    String nombre =txtModNom.getText();
    String grupo = (String) cmbModGrupo.getSelectedItem();
    long nCuenta = Long.parseLong(txtModNcuenta.getText().trim());
    String cargo = (String) cmbModCargo.getSelectedItem();
    String sexo = (String) cmbModSexo.getSelectedItem();
    String rh = txtModRh.getText().trim();
    int auxTransporte = 0;
    
    String eps = (String) cmbModEps.getSelectedItem();
    String arl = (String) cmbModArl.getSelectedItem();
    String pension = (String) cmbModPension.getSelectedItem();
    String bonificacion = (String) cmbModBonificacion.getSelectedItem();
    
    if(chkModAuxTransporte.isSelected()) auxTransporte = 1;
    String photo = lblModRutaPhoto.getText().trim();
    
    //int ficha, String cedula, String nombre, String grupo, long cuenta, String cargo, String sexo, String rh,String photo
    Empleado emp = new Empleado(ficha, cedula, nombre, grupo, nCuenta, cargo, sexo, rh, photo, auxTransporte);
    
    
}

private boolean verificarCampos(){
    boolean res = true;
    if(txtModFicha.getText().isEmpty() || txtModCedula.getText().trim().isEmpty() || txtModCedula.getText().trim().isEmpty()
            || txtModRh.getText().trim().isEmpty() || txtModNcuenta.getText().trim().isEmpty()) res = false;
    if(!isNumeric(txtModNcuenta.getText().trim()) || !isNumeric(txtModFicha.getText().trim())) res = false;
    
    return res;
}

private boolean isNumeric(String str){
    return (str.matches("[+-]?\\d*(\\.\\d+)?") && str.equals("")==false);
}

}
