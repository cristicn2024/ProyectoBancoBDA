/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia.Conexion.DTO;

import java.sql.Date;

/**
 * Clase DTO de cuentas
 * @author crist
 */
public class CuentaNuevaDTO {
    
    private int noCuenta;
    private double saldo;
    private String estado;
    private Date fechaApertura;
    private int idCliente;

    /**
     * Contructor vacion
     */
    public CuentaNuevaDTO() {
    }

    /**
     * Contructor CON ID
     * @param saldo
     * @param estado
     * @param fechaApertura
     * @param idCliente
     */
    public CuentaNuevaDTO( double saldo, String estado, Date fechaApertura, int idCliente) {
        this.saldo = saldo;
        this.estado = estado;
        this.fechaApertura = fechaApertura;
        this.idCliente = idCliente;
    }

    /**
     * Contructor SIN id
     * @param noCuenta
     * @param saldo
     * @param estado
     * @param fechaApertura
     * @param idCliente
     */
    public CuentaNuevaDTO(int noCuenta, double saldo, String estado, Date fechaApertura, int idCliente) {
        this.noCuenta = noCuenta;
        this.saldo = saldo;
        this.estado = estado;
        this.fechaApertura = fechaApertura;
        this.idCliente = idCliente;
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
     * Regresa el saldo
     * @return
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Establece el saldo
     * @param saldo
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /**
     * Regresa el estado
     * @return
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el estado
     * @param estado
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Regresa la fecha de apertura
     * @return
     */
    public Date getFechaApertura() {
        return fechaApertura;
    }

    /**
     * Establece la fecha de apertura
     * @param fechaApertura
     */
    public void setFechaApertura(Date fechaApertura) {
        this.fechaApertura = fechaApertura;
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
     * Regresa la cadena con trodos los atribut0s
     * @return
     */
    @Override
    public String toString() {
        return "CuentaNuevaDTO{" + "noCuenta=" + noCuenta + ", saldo=" + saldo + ", estado=" + estado + ", fechaApertura=" + fechaApertura + ", idCliente=" + idCliente + '}';
    }

}
