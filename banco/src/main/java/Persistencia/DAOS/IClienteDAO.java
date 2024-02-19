/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia.DAOS;

import Dominio.Cliente;
import Dominio.Cuenta;
import Dominio.Domicilio;
import Dominio.Retiro;
import Dominio.Transferencia;
import Persistencia.Conexion.DTO.ClienteNuevoDTO;
import Persistencia.Conexion.DTO.CuentaNuevaDTO;
import Persistencia.Conexion.DTO.DomicilioNuevoDTO;
import Persistencia.Conexion.DTO.RetiroNuevoDTO;
import Persistencia.Conexion.DTO.TransferenciaNuevaDTO;
import Persistencia.Excepciones.PersistenciaException;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

/**
 * Clase interfaz del DAO de Clientes
 *
 * @author INEGI
 */
public interface IClienteDAO {

    /**
     * Metodo para agregar cliente
     *
     * @param cliente
     * @return
     * @throws PersistenciaException
     */
    public Cliente agregarCliente(ClienteNuevoDTO cliente) throws PersistenciaException;

    /**
     * Metodo para agregar domicilio
     *
     * @param direccion
     * @return
     * @throws PersistenciaException
     */
    public Domicilio agregarDomicilio(DomicilioNuevoDTO direccion) throws PersistenciaException;

    public Cuenta agregarCuenta(CuentaNuevaDTO cuenta) throws PersistenciaException;

    public List<Cuenta> mostrarCuentas(int id) throws PersistenciaException;

    public Retiro RetirarFeria(RetiroNuevoDTO retiro) throws PersistenciaException;

    public int obtenerIdClientePorUsuario(String nombreUsuario) throws PersistenciaException;

    public boolean verificarCredenciales(String usuario, String contraseñaEncriptada) throws PersistenciaException;

    public String obtenerContraseñaEncriptada(String usuario) throws SQLException;

    public Transferencia TransferirFeria(TransferenciaNuevaDTO transferencia) throws PersistenciaException;

    public double obtenerSaldoCuenta(int noCuenta) throws PersistenciaException;

    public void actualizarSaldoCuenta(int noCuenta, double nuevoSaldo) throws PersistenciaException;

    public boolean validarFolioYContraseña(int folio, String contraseña) throws PersistenciaException;

    public void actualizarEstadoTransaccionesRetirosSinCuenta(int folio, String contraseña, String estado) throws PersistenciaException;

    public List<Object[]> movimientosPorFecha(int idCliente, Date fecha);

    public List<Object[]> movimientosPorTipo(int idCliente, String tipo);

    public void cancelarCuenta(int idCuenta) throws PersistenciaException;
}

