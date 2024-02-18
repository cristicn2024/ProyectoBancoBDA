/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia.Controlador.Utilerias;

/**
 *
 * @author crist
 */
public class Sesion {
    private static String usuario, idCliente;

    public Sesion() {
    }
    
    

    public static String getUsuario() {
        return usuario;
    }

    public static void setUsuario(String usuario) {
        Sesion.usuario = usuario;
    }

    public static String getIdCliente() {
        return idCliente;
    }

    public static void setIdCliente(String idCliente) {
        Sesion.idCliente = idCliente;
    }
    
    
}
