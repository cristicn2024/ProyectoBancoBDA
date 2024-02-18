/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.time.LocalDateTime;

/**
 *
 * @author crist
 */
public class Retiro {
     private int idTransaccion;
  private LocalDateTime fechaHora;
  private double monto;
  private int folio;
  private String contraseña;
  private int idCliente;
  private String cobrado;

    public Retiro() {
    }

    public Retiro(int idTransaccion, LocalDateTime fechaHora, double monto, int folio, String contraseña, int idCliente, String cobrado) {
        this.idTransaccion = idTransaccion;
        this.fechaHora = fechaHora;
        this.monto = monto;
        this.folio = folio;
        this.contraseña = contraseña;
        this.idCliente = idCliente;
        this.cobrado = cobrado;
    }

    public Retiro(LocalDateTime fechaHora, double monto, int folio, String contraseña, int idCliente, String cobrado) {
        this.fechaHora = fechaHora;
        this.monto = monto;
        this.folio = folio;
        this.contraseña = contraseña;
        this.idCliente = idCliente;
        this.cobrado = cobrado;
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

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getCobrado() {
        return cobrado;
    }

    public void setCobrado(String cobrado) {
        this.cobrado = cobrado;
    }

    @Override
    public String toString() {
        return "Retiro{" + "idTransaccion=" + idTransaccion + ", fechaHora=" + fechaHora + ", monto=" + monto + ", folio=" + folio + ", contrase\u00f1a=" + contraseña + ", idCliente=" + idCliente + ", cobrado=" + cobrado + '}';
    }
  
  
}
