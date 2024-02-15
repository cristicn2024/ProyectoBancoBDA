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
    private int idCuenta;
    private int noCuenta;
    private double saldo;
    private Date fechaApertura;

    /**
     * Constructor CON id de la cuenta
     * @param idCuenta
     * @param noCuenta
     * @param saldo
     * @param fechaApertura
     */
    public Cuenta(int idCuenta, int noCuenta, double saldo, Date fechaApertura) {
        this.idCuenta = idCuenta;
        this.noCuenta = noCuenta;
        this.saldo = saldo;
        this.fechaApertura = fechaApertura;
    }

    /**
     * Contructor SIN el id de la cuenta
     * @param noCuenta
     * @param saldo
     * @param fechaApertura
     */
    public Cuenta(int noCuenta, double saldo, Date fechaApertura) {
        this.noCuenta = noCuenta;
        this.saldo = saldo;
        this.fechaApertura = fechaApertura;
    }

    /**
     * Regresa el id de la cuenta
     * @return
     */
    public int getIdCuenta() {
        return idCuenta;
    }

    /**
     * Establece le id de la cuenta
     * @param idCuenta
     */
    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
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
     * Establede el Saldo
     * @param saldo
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
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
     *
     * @return
     */
    @Override
    public String toString() {
        return "Cuenta{" + "noCuenta=" + noCuenta + ", saldo=" + saldo + ", fechaApertura=" + fechaApertura + '}';
    }
    
    
}
