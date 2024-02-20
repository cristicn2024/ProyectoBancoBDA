/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia.Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Esta clase crea la conexion a la base de datos e implemanta la interfaz IConexinBD
 * @author INEGI
 */
public class ConexionBD implements IConexionBD {

    final private String cadenaConexion;
    final private String usuario;
    final private String contra;
    private static final Logger LOG = Logger.getLogger(ConexionBD.class.getName());

    /**
     * Contructor que inicializa la clase
     * @param cadenaConexion
     * @param usuario
     * @param contra
     */
    public ConexionBD(String cadenaConexion, String usuario, String contra) {
        this.cadenaConexion = cadenaConexion;
        this.usuario = usuario;
        this.contra = contra;
    }
 @Override
    public Connection crearConexion() throws SQLException {
        Connection conexion = DriverManager.getConnection(cadenaConexion, usuario, contra);
        LOG.log(Level.INFO, "Conexión exitosa ", cadenaConexion);
        return conexion;   
    }
}
