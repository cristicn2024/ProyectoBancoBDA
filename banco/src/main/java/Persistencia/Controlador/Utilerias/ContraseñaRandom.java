/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia.Controlador.Utilerias;

import java.security.SecureRandom;

/**
 *
 * @author crist
 */
public class ContraseñaRandom {
    // Caracteres que se pueden usar para generar la contraseña aleatoria
    private static final String CARACTERES = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    // Método para generar una contraseña aleatoria de longitud especificada
    public static String generarContraseñaAleatoria(int longitud) {
        StringBuilder contraseña = new StringBuilder();

        // Crear un generador seguro de números aleatorios
        SecureRandom random = new SecureRandom();

        // Generar la contraseña aleatoria
        for (int i = 0; i < longitud; i++) {
            int indice = random.nextInt(CARACTERES.length());
            contraseña.append(CARACTERES.charAt(indice));
        }

        return contraseña.toString();
    }
}
