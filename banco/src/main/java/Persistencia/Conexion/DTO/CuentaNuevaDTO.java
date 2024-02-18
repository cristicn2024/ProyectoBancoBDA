/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia.Conexion.DTO;

import java.sql.Date;

/**
 *
 * @author crist
 */
public class CuentaNuevaDTO {
    
    private int noCuenta;
    private double saldo;
    private String estado;
    private Date fechaApertura;
    private int idCliente;

    public CuentaNuevaDTO() {
    }

    public CuentaNuevaDTO( double saldo, String estado, Date fechaApertura, int idCliente) {
        this.saldo = saldo;
        this.estado = estado;
        this.fechaApertura = fechaApertura;
        this.idCliente = idCliente;
    }

    public CuentaNuevaDTO(int noCuenta, double saldo, String estado, Date fechaApertura, int idCliente) {
        this.noCuenta = noCuenta;
        this.saldo = saldo;
        this.estado = estado;
        this.fechaApertura = fechaApertura;
        this.idCliente = idCliente;
    }

  

    public int getNoCuenta() {
        return noCuenta;
    }

    public void setNoCuenta(int noCuenta) {
        this.noCuenta = noCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(Date fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public String toString() {
        return "CuentaNuevaDTO{" + "noCuenta=" + noCuenta + ", saldo=" + saldo + ", estado=" + estado + ", fechaApertura=" + fechaApertura + ", idCliente=" + idCliente + '}';
    }

}
