/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia.Conexion.DTO;

/**
 * Clase DTO de domicilio
 * @author INEGI
 */
public class DomicilioNuevoDTO {

    String calle, colonia, numero;
    int clienteId, id;

    /**
     * Contructor vacio
     */
    public DomicilioNuevoDTO() {
    }

    /**
     * Constructor para inicializar el domicilio CON id
     * @param id
     * @param calle
     * @param colonia
     * @param numero
     * @param clienteId
     */
    public DomicilioNuevoDTO(int id, String calle, String colonia, String numero, int clienteId) {
        this.id = id;
        this.calle = calle;
        this.colonia = colonia;
        this.numero = numero;
        this.clienteId = clienteId;
    }

    /**
     * Constructor para inicializar el domicilio SIN id
     * @param calle
     * @param colonia
     * @param numero
     */
    public DomicilioNuevoDTO(String calle, String colonia, String numero) {
        this.calle = calle;
        this.colonia = colonia;
        this.numero = numero;
    }

    /**
     * Obtiene la calle
     * @return
     */
    public String getCalle() {
        return calle;
    }

    /**
     * Establece la calle
     * @param calle
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * Obtiene la colonia
     * @return
     */
    public String getColonia() {
        return colonia;
    }

    /**
     * Establece la colonia
     * @param colonia
     */
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    /**
     * Obtiene el numero
     * @return
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Establece el numero
     * @param numero
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * Obtiene el id del cliente
     * @return
     */
    public int getClienteId() {
        return clienteId;
    }

    /**
     * Establece el id del cliente
     * @param clienteId
     */
    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    /**
     * Obtiene el id del domicilio
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el id del domicilio
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

}
