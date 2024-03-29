/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;
import java.sql.Date;
/**
 * Clase POJO de la cuenta
 * @author INEGI
 */
public class Cuenta {
   private int noCuenta;
    private double saldo;
    private Date fechaApertura;
    private int idCliente;
    private String estado;

    public Cuenta() {
    }

    public Cuenta(int noCuenta, double saldo, String estado,Date fechaApertura, int idCliente) {
        this.noCuenta = noCuenta;
        this.saldo = saldo;
        this.estado=estado;
        this.fechaApertura = fechaApertura;
        this.idCliente = idCliente;
    }

    

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Cuenta(int noCuenta, double saldo, Date fechaApertura) {
        this.noCuenta = noCuenta;

        this.saldo = saldo;
        this.fechaApertura = fechaApertura;
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
        return "Cuenta{" + "noCuenta=" + noCuenta + ", saldo=" + saldo + ", fechaApertura=" + fechaApertura + ", idCliente=" + idCliente + ", estado=" + estado + '}';
    }
    
}
