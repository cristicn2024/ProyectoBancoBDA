/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia.Controlador.Utilerias;

/**
 * Clase para loggear
 * @author crist
 */
public class Sesion {
    private static String usuario, idCliente;

    /**
     * Contructor vacio
     */
    public Sesion() {
    }
    
    /**
     * Regresa el usuario
     * @return
     */
    public static String getUsuario() {
        return usuario;
    }

    /**
     * Establece el usuario
     * @param usuario
     */
    public static void setUsuario(String usuario) {
        Sesion.usuario = usuario;
    }

    /**
     * Regresa el id del cliente
     * @return
     */
    public static String getIdCliente() {
        return idCliente;
    }

    /**
     * Establece el id del cliente
     * @param idCliente
     */
    public static void setIdCliente(String idCliente) {
        Sesion.idCliente = idCliente;
    }
    
    
}
