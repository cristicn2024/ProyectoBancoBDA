/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Presentacion;

import Persistencia.Conexion.ConexionBD;
import Persistencia.Conexion.IConexionBD;
import Persistencia.Controlador.Utilerias.Sesion;
import Persistencia.DAOS.ClienteDAO;
import Persistencia.DAOS.IClienteDAO;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Esta clase representa la interfaz de iniciar sesion
 * @author INEGI
 */
public class InicioSesion extends javax.swing.JFrame {

      IConexionBD conexionBD;
int idCliente;
private IClienteDAO clienteDAO;
    private static final Logger LOG = Logger.getLogger(ClienteDAO.class.getName());
  
    /**
     * Creates new form InicioSesion
     */
    public InicioSesion() {
        
        String cadenaConexion = "jdbc:mysql://localhost:3306/ProyectoBanco";
        String usuario = "root";
        String contra = "78357Cas";
        IConexionBD conexionBD = new ConexionBD(cadenaConexion, usuario, contra);
        clienteDAO = new ClienteDAO(conexionBD);
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

        jLabel1 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtContraseña = new javax.swing.JTextField();
        btnRegistrarse = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnRetiroSinCuenta = new javax.swing.JButton();
        aceptarBoton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(615, 494));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Usuario:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 98, 25));

        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, 310, 40));

        txtContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContraseñaActionPerformed(evt);
            }
        });
        getContentPane().add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 310, 40));

        btnRegistrarse.setText("Registrarse");
        btnRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarseActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrarse, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, 110, 40));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Contraseña:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 88, 25));

        btnRetiroSinCuenta.setText("Retirar sin cuenta");
        btnRetiroSinCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetiroSinCuentaActionPerformed(evt);
            }
        });
        getContentPane().add(btnRetiroSinCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 350, 140, 40));

        aceptarBoton.setText("Aceptar");
        aceptarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarBotonActionPerformed(evt);
            }
        });
        getContentPane().add(aceptarBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 270, 100, 30));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void btnRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarseActionPerformed
    ClienteForm clienteForm = new ClienteForm(this, true);
        clienteForm.setVisible(true);

    }//GEN-LAST:event_btnRegistrarseActionPerformed

    private void txtContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContraseñaActionPerformed

    private void aceptarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarBotonActionPerformed
       String usuario = txtUsuario.getText();
    String contraseña = txtContraseña.getText();
   /* ClienteForm clientes = new ClienteForm(null, true);
    
    
        try {
            // Obtener la contraseña encriptada de la base de datos
            String contraseñaEncriptadaDB = clienteDAO.obtenerContraseñaEncriptada(usuario);
            System.out.println("Contraseña encriptada de la base de datos: " + contraseñaEncriptadaDB);


// Verificar las credenciales
            if (contraseñaEncriptadaDB != null && contraseñaEncriptadaDB.equals(contraseña)) {
                System.out.println("Contraseñas encriptadas coinciden. Iniciando sesión...");
                // Código para abrir el siguiente formulario
                CuentasForm cuentas = new CuentasForm(idCliente);
                cuentas.setVisible(true);
                this.dispose();
            } else {
                System.out.println("Contraseñas encriptadas no coinciden. Usuario o contraseña incorrectos.");
                JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos");
            }
    } catch (Exception ex) {
        LOG.log(Level.SEVERE, "Error al verificar las credenciales", ex);
        JOptionPane.showMessageDialog(this, "Error al verificar las credenciales");
    }*/
     Sesion sesion = new Sesion();
     sesion.setUsuario(usuario);
     CuentasForm cuentas = new CuentasForm(idCliente);
                cuentas.setVisible(true);
                this.dispose();
    }//GEN-LAST:event_aceptarBotonActionPerformed

    private void btnRetiroSinCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetiroSinCuentaActionPerformed
        // TODO add your handling code here:
        RetiroSinCuentaForm rscf = new RetiroSinCuentaForm();
        rscf.setVisible(true);
    }//GEN-LAST:event_btnRetiroSinCuentaActionPerformed

   

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
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InicioSesion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptarBoton;
    private javax.swing.JButton btnRegistrarse;
    private javax.swing.JButton btnRetiroSinCuenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtContraseña;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
