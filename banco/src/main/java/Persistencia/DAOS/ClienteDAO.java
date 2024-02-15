/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia.DAOS;

import Dominio.Cliente;
import Dominio.Domicilio;
import Persistencia.Conexion.DTO.ClienteNuevoDTO;
import Persistencia.Conexion.DTO.DomicilioNuevoDTO;
import Persistencia.Conexion.IConexionBD;
import Persistencia.Excepciones.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase DAO del cliente que implementa la interfaz IClienteDAO
 * @author INEGI
 */
public class ClienteDAO implements IClienteDAO {

    IConexionBD conexionBD;
    private static final Logger LOG = Logger.getLogger(ClienteDAO.class.getName());

    /**
     * Constructor que inicializa la conexion
     * @param conexionBD
     */
    public ClienteDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
    public Cliente agregarCliente(ClienteNuevoDTO cliente) throws PersistenciaException {
String sentenciaSQL = "INSERT INTO CLIENTE (nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, usuario, contraseña) " +
                      "VALUES (?, ?, ?, ?, ?, ?)";
        try {
            Connection conexion = this.conexionBD.crearConexion();
            PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS);

            comandoSQL.setString(1, cliente.getNombre());
            comandoSQL.setString(2, cliente.getApellidoPaterno());
            comandoSQL.setString(3, cliente.getApellidoMaterno());
            comandoSQL.setDate(4, cliente.getFechaNacimiento());
            comandoSQL.setString(5, cliente.getUsuario());
            comandoSQL.setString(6, cliente.getContraseña());
            int registrosModificados = comandoSQL.executeUpdate();
            LOG.log(Level.INFO, "Se agregaron con éxito {0} ", registrosModificados);
            ResultSet registroGenerado = comandoSQL.getGeneratedKeys();
            registroGenerado.next();

            Cliente clienteNuevo = new Cliente(registroGenerado.getInt(1), cliente.getNombre(), cliente.getApellidoPaterno(), cliente.getApellidoMaterno(),
                    cliente.getFechaNacimiento(),cliente.getUsuario(),cliente.getContraseña());

            return clienteNuevo;
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "No se agregó con éxito el cliente", e);
            throw new PersistenciaException("No se pudo guardar el cliente ", e);
        }

    }

    @Override
    public Domicilio agregarDomicilio(DomicilioNuevoDTO direccion) throws PersistenciaException {
        String sentenciaSQL = "INSERT INTO DOMICILIO (calle, colonia, numero) VALUES (?, ?, ?)";
        try {
            Connection conexion = this.conexionBD.crearConexion();
            PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS);
            comandoSQL.setString(1, direccion.getCalle());
            comandoSQL.setString(2, direccion.getColonia());
            comandoSQL.setString(3, direccion.getNumero());

            int registrosModificados = comandoSQL.executeUpdate();

            LOG.log(Level.INFO, "Se actualizaron con éxito {0} registros", registrosModificados);
            ResultSet registroGenerado = comandoSQL.getGeneratedKeys();

            //nos posicionamos en el primer registro o en el siguiente disponible. 
            registroGenerado.next();

            return new Domicilio(registroGenerado.getInt(1), direccion.getCalle(), direccion.getColonia(), direccion.getNumero(), registroGenerado.getInt(1));
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "No se pudo agregar la direccion", e);
            throw new PersistenciaException("No se pudo actualizar el cliente ", e);
        }
    }

}
