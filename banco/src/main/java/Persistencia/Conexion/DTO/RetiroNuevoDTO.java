/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia.Conexion.DTO;

import java.time.LocalDateTime;

/**
 * Clase DTO del retiro sin cuenta
 * @author crist
 */
public class RetiroNuevoDTO {
     private int idTransaccion;
  private LocalDateTime fechaHora;
  private double monto;
  private int folio;
  private String contraseña;
  private int idCuenta;
  private String cobrado;

    /**
     * Contructor vacion
     */
    public RetiroNuevoDTO() {
    }

    /**
     * Constructor que inicializa el retiro CON idTransaccion
     * @param idTransaccion
     * @param fechaHora
     * @param monto
     * @param folio
     * @param contraseña
     * @param idCuenta
     * @param cobrado
     */
    public RetiroNuevoDTO(int idTransaccion, LocalDateTime fechaHora, double monto, int folio, String contraseña, int idCuenta, String cobrado) {
        this.idTransaccion = idTransaccion;
        this.fechaHora = fechaHora;
        this.monto = monto;
        this.folio = folio;
        this.contraseña = contraseña;
        this.idCuenta = idCuenta;
        this.cobrado = cobrado;
    }

    /**
     * Constructor que inicializa el retiro SIN idTransaccion
     * @param fechaHora
     * @param monto
     * @param folio
     * @param contraseña
     * @param idCliente
     * @param cobrado
     */
    public RetiroNuevoDTO(LocalDateTime fechaHora, double monto, int folio, String contraseña, int idCliente, String cobrado) {
        this.fechaHora = fechaHora;
        this.monto = monto;
        this.folio = folio;
        this.contraseña = contraseña;
        this.idCuenta = idCuenta;
        this.cobrado = cobrado;
    }

    /**
     * Regresa el idTransaccion
     * @return
     */
    public int getIdTransaccion() {
        return idTransaccion;
    }

    /**
     * Establece el idTransaccion
     * @param idTransaccion
     */
    public void setIdTransaccion(int idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    /**
     * Regresa la fecha y hora
     * @return
     */
    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    /**
     * Establece la fecha y hora
     * @param fechaHora
     */
    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    /**
     * Regresa el monto
     * @return
     */
    public double getMonto() {
        return monto;
    }

    /**
     * Establece el monto
     * @param monto
     */
    public void setMonto(double monto) {
        this.monto = monto;
    }

    /**
     * Regresa el folio
     * @return
     */
    public int getFolio() {
        return folio;
    }

    /**
     * Establece el folio
     * @param folio
     */
    public void setFolio(int folio) {
        this.folio = folio;
    }

    /**
     * Regresa la contraseña
     * @return
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * Establece la contraseña
     * @param contraseña
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    /**
     * Regresa el id de la cuenta
     * @return
     */
    public int getIdCuenta() {
        return idCuenta;
    }

    /**
     * Establece el id de la cuenta
     * @param idCuenta
     */
    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    /**
     * Regresa el estado
     * @return
     */
    public String getCobrado() {
        return cobrado;
    }

    /**
     * Establece el estado
     * @param cobrado
     */
    public void setCobrado(String cobrado) {
        this.cobrado = cobrado;
    }

    /**
     * Regresa la cadena con todos los atributos
     * @return
     */
    @Override
    public String toString() {
        return "RetiroNuevoDTO{" + "idTransaccion=" + idTransaccion + ", fechaHora=" + fechaHora + ", monto=" + monto + ", folio=" + folio + ", contrase\u00f1a=" + contraseña + ", idCuenta=" + idCuenta + ", cobrado=" + cobrado + '}';
    }
}
