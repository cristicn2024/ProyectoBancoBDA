/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia.Conexion.DTO;

import java.time.LocalDateTime;

/**
 * Clase DTO para la transferencia
 * @author crist
 */
public class TransferenciaNuevaDTO {
       private int idTransaccion;
  private LocalDateTime fechaHora;
  private double monto;
  private int noCuenta, noCuentaDestino;
  private int idCliente;
  
    /**
     * Constructor vacio 
     */
    public TransferenciaNuevaDTO (){
    }

    /**
     * Contructor que inicializa la nueva transferencia CON idTransaccion 
     * @param idTransaccion
     * @param fechaHora
     * @param monto
     * @param noCuenta
     * @param noCuentaDestino
     * @param idCliente
     */
    public TransferenciaNuevaDTO(int idTransaccion, LocalDateTime fechaHora, double monto, int noCuenta, int noCuentaDestino, int idCliente) {
        this.idTransaccion = idTransaccion;
        this.fechaHora = fechaHora;
        this.monto = monto;
        this.noCuenta = noCuenta;
        this.noCuentaDestino = noCuentaDestino;
        this.idCliente = idCliente;
    }

    /**
     * Contructor que inicializa la nueva transferencia SIN idTransaccion 
     * @param fechaHora
     * @param monto
     * @param noCuenta
     * @param noCuentaDestino
     * @param idCliente
     */
    public TransferenciaNuevaDTO(LocalDateTime fechaHora, double monto, int noCuenta, int noCuentaDestino, int idCliente) {
        this.fechaHora = fechaHora;
        this.monto = monto;
        this.noCuenta = noCuenta;
        this.noCuentaDestino = noCuentaDestino;
        this.idCliente = idCliente;
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
     * Regresa el numero de cuenta
     * @return
     */
    public int getNoCuenta() {
        return noCuenta;
    }

    /**
     * Establece el numero de cuenta
     * @param noCuenta
     */
    public void setNoCuenta(int noCuenta) {
        this.noCuenta = noCuenta;
    }

    /**
     * Regresa el numero de cuenta destino
     * @return
     */
    public int getNoCuentaDestino() {
        return noCuentaDestino;
    }

    /**
     * Establece el numero de cuenta destino
     * @param noCuentaDestino
     */
    public void setNoCuentaDestino(int noCuentaDestino) {
        this.noCuentaDestino = noCuentaDestino;
    }

    /**
     * Regresa el id del cliente
     * @return
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * Establece el id del cliente
     * @param idCliente
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * Regresa la cadena con todos los atributos
     * @return
     */
    @Override
    public String toString() {
        return "Transferencia{" + "idTransaccion=" + idTransaccion + ", fechaHora=" + fechaHora + ", monto=" + monto + ", noCuenta=" + noCuenta + ", noCuentaDestino=" + noCuentaDestino + ", idCliente=" + idCliente + '}';
    }

  
}
