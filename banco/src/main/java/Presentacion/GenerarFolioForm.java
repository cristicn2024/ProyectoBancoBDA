/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Presentacion;

import Dominio.Retiro;
import Persistencia.Conexion.ConexionBD;
import Persistencia.Conexion.DTO.RetiroNuevoDTO;
import Persistencia.Conexion.IConexionBD;
import static Persistencia.Controlador.Utilerias.ContraseñaRandom.generarContraseñaAleatoria;
import Persistencia.DAOS.ClienteDAO;
import Persistencia.DAOS.IClienteDAO;
import Persistencia.Excepciones.PersistenciaException;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author crist
 */
public class GenerarFolioForm extends javax.swing.JFrame {

  private int contadorFolio = 1; 

    private static final Logger LOG = Logger.getLogger(ClienteDAO.class.getName());
    String cadenaConexion = "jdbc:mysql://localhost:3306/ProyectoBanco";
    String usuario = "root";
    String contra = "78357Cas";
    IClienteDAO clienteDAO;
    IConexionBD conexionBD;

    
    public GenerarFolioForm() {
        conexionBD = new ConexionBD(cadenaConexion, usuario, contra);
        clienteDAO = new ClienteDAO(conexionBD); // Inicializa clienteDAO aquí

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
        jLabel2 = new javax.swing.JLabel();
        txtMonto = new javax.swing.JTextField();
        aceptarBoton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Generar folio");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Monto:");

        aceptarBoton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        aceptarBoton.setText("Aceptar");
        aceptarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarBotonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Usuario:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(aceptarBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMonto)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addComponent(aceptarBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void aceptarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarBotonActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
         String nombreUsuario = txtUsuario.getText(); // Obtener el nombre de usuario del campo de texto

    try {
        int idCliente = clienteDAO.obtenerIdClientePorUsuario(nombreUsuario);

        RetiroNuevoDTO retiroDTO = new RetiroNuevoDTO();
        retiroDTO.setMonto(Double.parseDouble(txtMonto.getText()));
        retiroDTO.setFolio(contadorFolio++); // Usar el valor actual del contador como folio y luego incrementarlo en uno
        retiroDTO.setContraseña(generarContraseñaAleatoria(8)); // Generar una contraseña aleatoria de 8 caracteres
        retiroDTO.setIdCliente(idCliente); // Establecer el ID del cliente obtenido
        retiroDTO.setCobrado("no cobrado");
retiroDTO.setFechaHora(LocalDateTime.now());

        Retiro retiroAgregado = clienteDAO.RetirarFeria(retiroDTO);

        if (retiroAgregado != null) {
            JOptionPane.showMessageDialog(this, "Retiro realizado con éxito.\nFolio: " + retiroDTO.getFolio() +
                    "\nContraseña: " + retiroDTO.getContraseña()+"\nFecha  y hora: "+retiroDTO.getFechaHora() );
        } else {
            JOptionPane.showMessageDialog(this, "Error al realizar el retiro.", "Error", JOptionPane.ERROR_MESSAGE);
        }
     
    } catch (PersistenciaException e) {
        LOG.log(Level.SEVERE, "No se pudo realizar el retiro sin cuenta", e);
    }
    }//GEN-LAST:event_aceptarBotonActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptarBoton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}