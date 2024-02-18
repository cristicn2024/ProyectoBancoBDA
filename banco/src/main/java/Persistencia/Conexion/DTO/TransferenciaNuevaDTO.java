/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia.Conexion.DTO;

import java.time.LocalDateTime;

/**
 *
 * @author crist
 */
public class TransferenciaNuevaDTO {
       private int idTransaccion;
  private LocalDateTime fechaHora;
  private double monto;
  private int noCuenta, noCuentaDestino;
  private int idCliente;
  

    public TransferenciaNuevaDTO (){
    }

    public TransferenciaNuevaDTO(int idTransaccion, LocalDateTime fechaHora, double monto, int noCuenta, int noCuentaDestino, int idCliente) {
        this.idTransaccion = idTransaccion;
        this.fechaHora = fechaHora;
        this.monto = monto;
        this.noCuenta = noCuenta;
        this.noCuentaDestino = noCuentaDestino;
        this.idCliente = idCliente;
    }

    public TransferenciaNuevaDTO(LocalDateTime fechaHora, double monto, int noCuenta, int noCuentaDestino, int idCliente) {
        this.fechaHora = fechaHora;
        this.monto = monto;
        this.noCuenta = noCuenta;
        this.noCuentaDestino = noCuentaDestino;
        this.idCliente = idCliente;
    }

    public int getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(int idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public int getNoCuenta() {
        return noCuenta;
    }

    public void setNoCuenta(int noCuenta) {
        this.noCuenta = noCuenta;
    }

    public int getNoCuentaDestino() {
        return noCuentaDestino;
    }

    public void setNoCuentaDestino(int noCuentaDestino) {
        this.noCuentaDestino = noCuentaDestino;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public String toString() {
        return "Transferencia{" + "idTransaccion=" + idTransaccion + ", fechaHora=" + fechaHora + ", monto=" + monto + ", noCuenta=" + noCuenta + ", noCuentaDestino=" + noCuentaDestino + ", idCliente=" + idCliente + '}';
    }

  
}
