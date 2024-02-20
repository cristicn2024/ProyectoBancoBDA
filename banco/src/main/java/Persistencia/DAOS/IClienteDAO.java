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
     * Metodo abstracto para agregar cliente
     *
     * @param cliente
     * @return
     * @throws PersistenciaException
     */
    public Cliente agregarCliente(ClienteNuevoDTO cliente) throws PersistenciaException;

    /**
     * Metodo abstracto para agregar domicilio
     *
     * @param direccion
     * @return
     * @throws PersistenciaException
     */
    public Domicilio agregarDomicilio(DomicilioNuevoDTO direccion) throws PersistenciaException;

    /**
     * Metodo para agregar cuenta
     * @param cuenta
     * @return
     * @throws PersistenciaException
     */
    public Cuenta agregarCuenta(CuentaNuevaDTO cuenta) throws PersistenciaException;

    /**
     *  Metodo para mostrar cuenta
     * @param id
     * @return
     * @throws PersistenciaException
     */
    public List<Cuenta> mostrarCuentas(int id) throws PersistenciaException;

    /**
     *  Metodo abstracto para retirar sin cuenta
     * @param retiro
     * @return
     * @throws PersistenciaException
     */
    public Retiro RetirarFeria(RetiroNuevoDTO retiro) throws PersistenciaException;

    /**
     *  Metodo abstracto para obtener el id del cliente por su usuario
     * @param nombreUsuario
     * @return
     * @throws PersistenciaException
     */
    public int obtenerIdClientePorUsuario(String nombreUsuario) throws PersistenciaException;

    /**
     * Metodo abstracto para verificar el usuaario y contraseña
     * @param usuario
     * @param contraseñaEncriptada
     * @return
     * @throws PersistenciaException
     */
    public boolean verificarCredenciales(String usuario, String contraseñaEncriptada) throws PersistenciaException;

    /**
     * Metodo abstracto para obtener la contraseña encriptada
     * @param usuario
     * @return
     * @throws SQLException
     */
    public String obtenerContraseñaEncriptada(String usuario) throws SQLException;

    /**
     * Metodo abstracto para transferencias
     * @param transferencia
     * @return
     * @throws PersistenciaException
     */
    public Transferencia TransferirFeria(TransferenciaNuevaDTO transferencia) throws PersistenciaException;

    /**
     * Metodo abstracto para validacion del saldo
     * @param idCliente
     * @param noCuenta
     * @param monto
     * @return
     * @throws PersistenciaException
     */
    public boolean saldoSuficienteParaTransferencia(int idCliente, int noCuenta, double monto) throws PersistenciaException;

    /**
     * Metodo abstracto para validar folio y contraseña
     * @param folio
     * @param contraseña
     * @return
     * @throws PersistenciaException
     */
    public boolean validarFolioYContraseña(int folio, String contraseña) throws PersistenciaException;

    /**
     * Metodo abstracto para el historial por fecha
     * @param idCliente
     * @param fecha
     * @return
     */
    public List<Object[]> movimientosPorFecha(int idCliente, Date fecha);

    /**
     * Metodo abstracto para el historial por tipo
     * @param idCliente
     * @param tipo
     * @return
     */
    public List<Object[]> movimientosPorTipo(int idCliente, String tipo);

    /**
     * Metodo abstracto para cancelar una cuenta
     * @param idCuenta
     * @throws PersistenciaException
     */
    public void cancelarCuenta(int idCuenta) throws PersistenciaException;
    
    /**
     * Metodo abstracto para obtener el id de la cuenta por su numero
     * @param noCuenta
     * @return
     * @throws PersistenciaException
     */
    public int obtenerIdCuentaPorNoCuenta(String noCuenta) throws PersistenciaException;
     
    /**
     * Metodo abstracto para realizar un deposito
     * @param idCuenta
     * @param idCuentaDestino
     * @param montoDeposito
     * @throws PersistenciaException
     */
    public void realizarDeposito(int idCuenta, int idCuentaDestino, double montoDeposito) throws PersistenciaException;
     
    /**
     * Metodo abstracto para actualizar el estado de retiros sin cuenta
     * @param folioGenerado
     * @param contraseña
     * @param estado
     * @throws PersistenciaException
     * @throws SQLException
     */
    public void actualizarEstadoTransaccionesRetirosSinCuenta(int folioGenerado, String contraseña, String estado) throws PersistenciaException, SQLException;
     
     
             
}

