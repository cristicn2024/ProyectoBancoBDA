/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Presentacion;

import Dominio.Cliente;
import Dominio.Domicilio;
import Persistencia.Conexion.ConexionBD;
import Persistencia.Conexion.DTO.ClienteNuevoDTO;
import Persistencia.Conexion.DTO.DomicilioNuevoDTO;
import Persistencia.Conexion.IConexionBD;
import Persistencia.DAOS.ClienteDAO;
import Persistencia.DAOS.IClienteDAO;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que representa la interfaz de Clientes
 * @author INEGI
 */
public class ClienteForm extends javax.swing.JDialog {

    InicioSesion is = new InicioSesion();
    Cliente cliente;
    Domicilio domicilio;
    IConexionBD conexionBD;
    private static final Logger LOG = Logger.getLogger(ClienteDAO.class.getName());
    String cadenaConexion = "jdbc:mysql://localhost/ProyectoBanco";
    String usuario = "root";
    String contra = "Jorgitoel04.";
    IClienteDAO clienteDAO;

    /**
     * Creates new form ClienteForm
     */
    public ClienteForm(java.awt.Frame parent, boolean modal) {
        
        super(parent, modal);
        cliente = new Cliente();
        domicilio = new Domicilio();
        conexionBD = new ConexionBD(cadenaConexion, usuario, contra);
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

        txtContraseña = new javax.swing.JTextField();
        txtUsuario = new javax.swing.JTextField();
        txtFechaNacimiento = new javax.swing.JTextField();
        txtApellidoM = new javax.swing.JTextField();
        txtApellidoP = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtNumero = new javax.swing.JTextField();
        txtColonia = new javax.swing.JTextField();
        txtCalle = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(650, 470));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 240, 210, 15));

        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, 230, 15));
        getContentPane().add(txtFechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 194, 150, 15));
        getContentPane().add(txtApellidoM, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 170, 170, 15));

        txtApellidoP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoPActionPerformed(evt);
            }
        });
        getContentPane().add(txtApellidoP, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, 170, 15));
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 125, 230, 15));
        getContentPane().add(txtNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 370, 110, 15));
        getContentPane().add(txtColonia, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 342, 110, 15));
        getContentPane().add(txtCalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 320, 130, 15));

        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 410, 89, -1));

        jLabel1.setBackground(new java.awt.Color(255, 153, 204));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 204));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/registrarseClienteBANCOOO.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 650, 470));

        btnAceptar.setContentAreaFilled(false);
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 400, -1, 40));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        cliente.setNombre(txtNombre.getText());
        cliente.setApellidoMaterno(txtApellidoM.getText());
        cliente.setApellidoPaterno(txtApellidoP.getText());

        String fechaTexto = txtFechaNacimiento.getText();
        DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date fechaNacimiento = new Date(formatoFecha.parse(fechaTexto).getTime());
            cliente.setFechaNacimiento(fechaNacimiento);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        cliente.setUsuario(txtUsuario.getText());
        cliente.setContraseña(txtContraseña.getText());

        ClienteNuevoDTO cliDTO = new ClienteNuevoDTO();
        cliDTO.setNombre(txtNombre.getText());
        cliDTO.setApellidoMaterno(txtApellidoM.getText());
        cliDTO.setApellidoPaterno(txtApellidoP.getText());
        String fechaTexto2 = txtFechaNacimiento.getText();
        DateFormat formatoFecha2 = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date fechaNacimiento2 = new Date(formatoFecha2.parse(fechaTexto2).getTime());
            cliDTO.setFechaNacimiento(fechaNacimiento2);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        cliDTO.setUsuario(txtUsuario.getText());
        cliDTO.setContraseña(txtContraseña.getText());

        domicilio.setCalle(txtCalle.getText());
        domicilio.setColonia(txtColonia.getText());
        domicilio.setNumero(txtNumero.getText());

        DomicilioNuevoDTO domiNuevo = new DomicilioNuevoDTO();
        domiNuevo.setCalle(txtCalle.getText());
        domiNuevo.setColonia(txtColonia.getText());
        domiNuevo.setNumero(txtNumero.getText());

        try {
            Cliente clienteAgregado = clienteDAO.agregarCliente(cliDTO);
            Domicilio domicilioAgregado = clienteDAO.agregarDomicilio(domiNuevo);
            LOG.log(Level.INFO, clienteAgregado.toString());
            LOG.log(Level.INFO, domicilioAgregado.toString());

        } catch (Exception e) {
            LOG.log(Level.SEVERE, "No se pudo agregar", e);
        }

    }//GEN-LAST:event_btnAceptarActionPerformed

    private void txtApellidoPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoPActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
System.exit(0);

    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtApellidoM;
    private javax.swing.JTextField txtApellidoP;
    private javax.swing.JTextField txtCalle;
    private javax.swing.JTextField txtColonia;
    private javax.swing.JTextField txtContraseña;
    private javax.swing.JTextField txtFechaNacimiento;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
