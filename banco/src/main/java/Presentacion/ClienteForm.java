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
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
    String cadenaConexion = "jdbc:mysql://localhost:3306/ProyectoBanco";
    String usuario = "root";
    String contra = "78357Cas";
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
        btnAceptar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(672, 560));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 260, 210, 20));

        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 230, 230, 20));
        getContentPane().add(txtFechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 200, 150, -1));
        getContentPane().add(txtApellidoM, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 170, 170, 20));

        txtApellidoP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoPActionPerformed(evt);
            }
        });
        getContentPane().add(txtApellidoP, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, 170, 20));
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, 230, 20));
        getContentPane().add(txtNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 410, 110, 20));
        getContentPane().add(txtColonia, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 380, 110, 20));
        getContentPane().add(txtCalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 350, 130, 20));

        btnCancelar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCancelar.setText("Regresar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 460, 89, 40));

        btnAceptar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAceptar.setText("Guardar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 460, -1, 40));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Nombre:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Apellido Paterno:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Apellido Materno:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Fecha de Nacimiento:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Usuario:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Contraseña:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 260, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Calle:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 350, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Colonia:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 380, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Numero:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 410, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel10.setText("Registrarse");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jLabel11.setText("Domicilio");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 320, -1, -1));

        jLabel12.setText("Datos Personales");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, -1, -1));

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
        DateFormat formatoFecha2 = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date fechaNacimiento2 = new Date(formatoFecha2.parse(fechaTexto2).getTime());
            cliDTO.setFechaNacimiento(fechaNacimiento2);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        
        
        cliDTO.setUsuario(txtUsuario.getText());
         try{
            String contraseñaEncriptada = encriptarContraseña(txtContraseña.getText());
            cliDTO.setContraseña(contraseñaEncriptada);
        }catch(Exception ex){
            LOG.log(Level.SEVERE, "No se pudo encriptar la contraseña", ex);
        }

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
                this.setVisible(false);

        } catch (Exception e) {
            LOG.log(Level.SEVERE, "No se pudo agregar", e);
        }

    }//GEN-LAST:event_btnAceptarActionPerformed

    private void txtApellidoPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoPActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
InicioSesion iniciar = new InicioSesion();
iniciar.setVisible(true);
this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed
public String encriptarContraseña(String contraseña) throws NoSuchAlgorithmException{
           try {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(contraseña.getBytes(StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        for (byte b : hash) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    } catch (NoSuchAlgorithmException ex) {
        LOG.log(Level.SEVERE, "Error al encriptar la contraseña", ex);
        return null;
    }
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
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
