/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia.Conexion;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Interfaz de la conexion a la base de datos
 * @author INEGI
 */
public interface IConexionBD {
    
    /**
     * Metodo para crear la conexion
     * @return
     * @throws SQLException
     */
    public Connection crearConexion() throws SQLException;
}
