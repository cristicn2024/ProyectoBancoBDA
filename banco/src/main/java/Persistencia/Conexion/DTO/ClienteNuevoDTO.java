/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia.Conexion.DTO;

import java.sql.Date;

/**
 * Clase DTO de cliente
 * @author INEGI
 */
public class ClienteNuevoDTO {
     private int idCliente;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Date fechaNacimiento;
    private String usuario;
    private String contraseña;

    /**
     * Contructor vacio del cliente
     */
    public ClienteNuevoDTO() {
    }

    /**
     * Contructor que inicializa el cliente CON id
     * @param idCliente
     * @param nombre
     * @param apellidoPaterno
     * @param apellidoMaterno
     * @param fechaNacimiento
     * @param usuario
     * @param contraseña
     */
    public ClienteNuevoDTO(int idCliente, String nombre, String apellidoPaterno, String apellidoMaterno, Date fechaNacimiento, String usuario, String contraseña) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    /**
     * Contructor que inicializa el cliente SIN id
     * @param nombre
     * @param apellidoPaterno
     * @param apellidoMaterno
     * @param fechaNacimiento
     * @param usuario
     * @param contraseña
     */
    public ClienteNuevoDTO(String nombre, String apellidoPaterno, String apellidoMaterno, Date fechaNacimiento, String usuario, String contraseña) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    /**
     * Regresa el id del Cliente
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
     * Regresa el nombre
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Regresa el apellido paterno
     * @return
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Establece el apellido paterno
     * @param apellidoPaterno
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * Regresa el apellido materno
     * @return
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Establece el apellido materno
     * @param apellidoMaterno
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * Regresa la fecha de nacimiento
     * @return
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Establece la fecha de nacimiento
     * @param fechaNacimiento
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Regresa el usuario
     * @return
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Establece el usuario
     * @param usuario
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
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
     *
     * @return
     */
    @Override
    public String toString() {
        return "ClienteNuevoDTO{" + "idCliente=" + idCliente + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", fechaNacimiento=" + fechaNacimiento + ", usuario=" + usuario + ", contrase\u00f1a=" + contraseña + '}';
    }

    
}
