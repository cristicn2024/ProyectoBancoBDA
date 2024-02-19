/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
import Persistencia.Conexion.IConexionBD;
import Persistencia.Excepciones.PersistenciaException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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
     *
     * @param conexionBD
     */
    public ClienteDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
    public Cliente agregarCliente(ClienteNuevoDTO cliente) throws PersistenciaException {
        String sentenciaSQL = "INSERT INTO CLIENTES (nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, usuario, contraseña) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
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
                    cliente.getFechaNacimiento(), cliente.getUsuario(), cliente.getContraseña());

            return clienteNuevo;
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "No se agregó con éxito el cliente", e);
            throw new PersistenciaException("No se pudo guardar el cliente ", e);
        }

    }

    @Override
    public Domicilio agregarDomicilio(DomicilioNuevoDTO direccion) throws PersistenciaException {
        String sentenciaSQL = "INSERT INTO DOMICILIOS (calle, colonia, numero) VALUES (?, ?, ?)";
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

    @Override
    public Cuenta agregarCuenta(CuentaNuevaDTO cuenta) throws PersistenciaException {
        String sentenciaSQL = "INSERT INTO cuentas (Saldo, estado, FechaApertura, IdCliente) "
                + "VALUES (?, ?, ?, ?)";
        try {
            Connection conexion = this.conexionBD.crearConexion();
            PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS);

            comandoSQL.setDouble(1, cuenta.getSaldo());
            comandoSQL.setString(2, cuenta.getEstado());
            comandoSQL.setDate(3, cuenta.getFechaApertura());
            comandoSQL.setInt(4, cuenta.getIdCliente());

            int registrosModificados = comandoSQL.executeUpdate();
            LOG.log(Level.INFO, "Se agregó con éxito {0} cuenta(s)", registrosModificados);

            ResultSet registroGenerado = comandoSQL.getGeneratedKeys();
            registroGenerado.next();

            Cuenta cuentaNueva = new Cuenta(registroGenerado.getInt(1), cuenta.getSaldo(), cuenta.getEstado(), cuenta.getFechaApertura(), cuenta.getIdCliente());

            return cuentaNueva;
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "No se pudo agregar la cuenta", e);
            throw new PersistenciaException("No se pudo guardar la cuenta", e);
        }
    }

    @Override
    public List<Cuenta> mostrarCuentas(int id) throws PersistenciaException {
        List<Cuenta> cuentas = new ArrayList<>(); // Lista para almacenar las cuentas encontradas

        // Realizar la consulta
        String consulta = "SELECT * FROM cuentas WHERE idCliente = (?)";

        try ( Connection conexion = this.conexionBD.crearConexion();  PreparedStatement comandoSQL = conexion.prepareStatement(consulta)) {

            comandoSQL.setInt(1, id);
            ResultSet resultado = comandoSQL.executeQuery();

            // Iterar sobre todos los resultados y crear un objeto Cuenta para cada uno
            while (resultado.next()) {
                Cuenta cuentaConsultada = new Cuenta(
                        resultado.getInt(1),
                        resultado.getDouble(2),
                        resultado.getString(3),
                        resultado.getDate(4),
                        resultado.getInt(5));

                cuentas.add(cuentaConsultada); // Agregar la cuenta a la lista
            }

        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Error al buscar cuentas", e);
            throw new PersistenciaException("Error al buscar cuentas", e);
        }

        return cuentas;
    }

    @Override
    public Retiro RetirarFeria(RetiroNuevoDTO retiro) throws PersistenciaException {
        String sentenciaSQL = "INSERT INTO transaccionRetirosSinCuenta (FechaHora, monto, folio, contraseña, IdCliente, estado) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        try ( Connection conexion = this.conexionBD.crearConexion();  PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS)) {

            comandoSQL.setObject(1, LocalDateTime.now());
            comandoSQL.setDouble(2, retiro.getMonto());
            comandoSQL.setInt(3, retiro.getFolio());
            comandoSQL.setString(4, retiro.getContraseña());
            comandoSQL.setInt(5, retiro.getIdCliente());
            comandoSQL.setString(6, retiro.getCobrado());

            int registrosModificados = comandoSQL.executeUpdate();
            LOG.log(Level.INFO, "Se agregó con éxito {0} retiro(s) sin cuenta", registrosModificados);

            ResultSet registroGenerado = comandoSQL.getGeneratedKeys();
            int idTransaccion;
            if (registroGenerado.next()) {
                idTransaccion = registroGenerado.getInt(1);
                LOG.log(Level.INFO, "ID de la transacción generada: {0}", idTransaccion);
            } else {
                LOG.log(Level.WARNING, "No se pudo obtener el ID de la transacción generada");
                throw new PersistenciaException("No se pudo obtener el ID de la transacción generada");
            }

            // Crear un objeto Retiro con la información obtenida
            Retiro retiroGenerado = new Retiro(idTransaccion, LocalDateTime.now(), retiro.getMonto(), retiro.getFolio(), retiro.getContraseña(), retiro.getIdCliente(), retiro.getCobrado());

            return retiroGenerado;
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "No se pudo agregar el retiro sin cuenta", e);
            throw new PersistenciaException("No se pudo guardar el retiro sin cuenta", e);
        }
    }

    @Override
    public int obtenerIdClientePorUsuario(String nombreUsuario) throws PersistenciaException {
        String CONSULTA_OBTENER_ID_POR_USUARIO = "SELECT IdCliente FROM clientes WHERE usuario = ?";
        try ( Connection conexion = this.conexionBD.crearConexion();  PreparedStatement comandoSQL = conexion.prepareStatement(CONSULTA_OBTENER_ID_POR_USUARIO)) {

            comandoSQL.setString(1, nombreUsuario);

            try ( ResultSet resultado = comandoSQL.executeQuery()) {
                if (resultado.next()) {
                    return resultado.getInt(1);
                } else {
                    throw new PersistenciaException("No se encontró ningún cliente con el nombre de usuario proporcionado: " + nombreUsuario);
                }
            }
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "Error al obtener el ID del cliente por nombre de usuario", e);
            throw new PersistenciaException("Error al obtener el ID del cliente por nombre de usuario", e);
        }

    }

    @Override
    public boolean verificarCredenciales(String usuario, String contraseñaEncriptada) {
        try {
            Connection conexion = conexionBD.crearConexion();
            String query = "SELECT COUNT(*) FROM Clientes WHERE usuario = ? AND contraseña = ?";
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setString(1, usuario);
            ps.setString(2, contraseñaEncriptada); // La contraseña ya está encriptada con SHA-1
            ResultSet rs = ps.executeQuery();
            rs.next();
            int count = rs.getInt(1);
            return count == 1;
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "Error al verificar las credenciales", ex);
            return false;
        }
    }

    @Override
    public String obtenerContraseñaEncriptada(String usuario) throws SQLException {
         String contraseñaEncriptada = null;

        try (Connection conexion = this.conexionBD.crearConexion(); PreparedStatement statement = conexion.prepareStatement("SELECT contraseña FROM Clientes WHERE usuario = ?")) {
            statement.setString(1, usuario);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    contraseñaEncriptada = resultSet.getString("contraseña");
                }
            }
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "Error al obtener la contraseña encriptada del usuario", e);
            throw e;
        }

        return contraseñaEncriptada;
    }

    @Override
    public Transferencia TransferirFeria(TransferenciaNuevaDTO transferencia) throws PersistenciaException {
        String sentenciaSQL = "INSERT INTO transaccionTransferencias (FechaHora, monto, noCuentaDestino, IdCliente, noCuenta) "
                + "VALUES (?, ?, ?, ?, ?)";
        try ( Connection conexion = this.conexionBD.crearConexion();  PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS)) {

            comandoSQL.setObject(1, LocalDateTime.now());
            comandoSQL.setDouble(2, transferencia.getMonto());
            comandoSQL.setInt(3, transferencia.getNoCuentaDestino());
            comandoSQL.setInt(4, transferencia.getIdCliente());
            comandoSQL.setInt(5, transferencia.getNoCuenta());

            int registrosModificados = comandoSQL.executeUpdate();
            LOG.log(Level.INFO, "Se agregó con éxito {0} transferencia(s) ", registrosModificados);

            ResultSet registroGenerado = comandoSQL.getGeneratedKeys();
            int idTransaccion;
            if (registroGenerado.next()) {
                idTransaccion = registroGenerado.getInt(1);
                LOG.log(Level.INFO, "ID de la transacción generada: {0}", idTransaccion);
            } else {
                LOG.log(Level.WARNING, "No se pudo obtener el ID de la transacción generada");
                throw new PersistenciaException("No se pudo obtener el ID de la transacción generada");
            }

            Transferencia transferenciaGenerada = new Transferencia(idTransaccion, LocalDateTime.now(), transferencia.getMonto(), transferencia.getNoCuentaDestino(), transferencia.getIdCliente(), transferencia.getNoCuenta());

            return transferenciaGenerada;
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "No se pudo agregar la transferencia", e);
            throw new PersistenciaException("No se pudo guardar la transferenia", e);
        }
    }

    @Override
    public double obtenerSaldoCuenta(int noCuenta) throws PersistenciaException {
        try ( Connection connection = this.conexionBD.crearConexion();  PreparedStatement statement = connection.prepareStatement("SELECT saldo FROM cuentas WHERE idCuenta = ?")) {
            statement.setInt(1, noCuenta);
            try ( ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getDouble("saldo");
                } else {
                    throw new PersistenciaException("No se encontró la cuenta con el número especificado");
                }
            }
        } catch (SQLException e) {
            throw new PersistenciaException("Error al obtener el saldo de la cuenta", e);
        }
    }

    @Override
    public void actualizarSaldoCuenta(int noCuenta, double nuevoSaldo) throws PersistenciaException {
        try ( Connection connection = this.conexionBD.crearConexion();  PreparedStatement statement = connection.prepareStatement("UPDATE cuentas SET saldo = ? WHERE idCuenta = ?")) {
            statement.setDouble(1, nuevoSaldo);
            statement.setInt(2, noCuenta);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected != 1) {
                throw new PersistenciaException("No se pudo actualizar el saldo de la cuenta");
            }
        } catch (SQLException e) {
            throw new PersistenciaException("Error al actualizar el saldo de la cuenta", e);
        }
    }

    @Override
    public boolean validarFolioYContraseña(int folio, String contraseña) throws PersistenciaException {
        try ( Connection connection = this.conexionBD.crearConexion();  PreparedStatement statement = connection.prepareStatement("SELECT * FROM transaccionRetirosSinCuenta WHERE folio = ? AND contraseña = ?")) {
            statement.setInt(1, folio);
            statement.setString(2, contraseña);
            try ( ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next();
            }
        } catch (SQLException e) {
            throw new PersistenciaException("Error al validar el folio y la contraseña", e);
        }
    }

    @Override
    public void actualizarEstadoTransaccionesRetirosSinCuenta(int folio, String contraseña, String estado) throws PersistenciaException {
        System.out.print("Actualizando estado de transaaciion con folio: " + folio + "contraseña:" + contraseña + "estado:" + estado);
        try ( Connection connection = this.conexionBD.crearConexion();  PreparedStatement statement = connection.prepareStatement("UPDATE transaccionRetirosSinCuenta SET estado = ? WHERE folio = ? AND contraseña = ?")) {
            statement.setString(1, estado);
            statement.setInt(2, folio);
            statement.setString(3, contraseña);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected != 1) {
                throw new PersistenciaException("No se pudo actualizar el estado de la transacción");
            }
            System.out.print("Actualizacion exitosa. Filas Afectadas:" + rowsAffected);
        } catch (SQLException e) {
            throw new PersistenciaException("Error al actualizar el estado de la transacción", e);
        }
    }

    @Override
    public List<Object[]> movimientosPorFecha(int idCliente, Date fecha) {
        List<Object[]> movimientos = new ArrayList<>();

        String consultaTransferencias = "SELECT IdTransaccion, FechaHora, monto, 'transferencia', noCuentaDestino "
                + "FROM transaccionTransferencias "
                + "WHERE IdCliente = ? AND DATE(FechaHora) = ?";

        String consultaRetiros = "SELECT IdTransaccion, FechaHora, monto, 'retiro', NULL "
                + "FROM transaccionRetirosSinCuenta "
                + "WHERE IdCliente = ? AND DATE(FechaHora) = ?";

        try ( Connection conexion = this.conexionBD.crearConexion();  PreparedStatement comandoTransferencias = conexion.prepareStatement(consultaTransferencias);  PreparedStatement comandoRetiros = conexion.prepareStatement(consultaRetiros)) {

            comandoTransferencias.setInt(1, idCliente);
            comandoTransferencias.setDate(2, fecha);
            comandoRetiros.setInt(1, idCliente);
            comandoRetiros.setDate(2, fecha);

            ResultSet resultadoTransferencias = comandoTransferencias.executeQuery();
            ResultSet resultadoRetiros = comandoRetiros.executeQuery();

            while (resultadoTransferencias.next()) {
                Object[] movimiento = {
                    resultadoTransferencias.getInt("IdTransaccion"),
                    resultadoTransferencias.getTimestamp("FechaHora").toLocalDateTime(),
                    resultadoTransferencias.getDouble("monto"),
                    resultadoTransferencias.getString(4),
                    resultadoTransferencias.getInt("noCuentaDestino")
                };
                movimientos.add(movimiento);
            }

            while (resultadoRetiros.next()) {
                Object[] movimiento = {
                    resultadoRetiros.getInt("IdTransaccion"),
                    resultadoRetiros.getTimestamp("FechaHora").toLocalDateTime(),
                    resultadoRetiros.getDouble("monto"),
                    resultadoRetiros.getString(4),
                    null
                };
                movimientos.add(movimiento);
            }

        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Error al buscar movimientos por fecha", e);
        }

        return movimientos;
    }

    @Override
    public List<Object[]> movimientosPorTipo(int idCliente, String tipo) {
        List<Object[]> movimientos = new ArrayList<>();

        String consulta = null;

        // Dependiendo del tipo de movimiento, se construye la consulta SQL adecuada
        switch (tipo) {
            case "transferencia":
                consulta = "SELECT IdTransaccion, FechaHora, monto, 'transferencia', noCuentaDestino "
                        + "FROM transaccionTransferencias "
                        + "WHERE IdCliente = ?";
                break;
            case "retiro":
                consulta = "SELECT IdTransaccion, FechaHora, monto, 'retiro', NULL "
                        + "FROM transaccionRetirosSinCuenta "
                        + "WHERE IdCliente = ? AND DATE(FechaHora) = ?";
                break;
            // Agrega más casos según los tipos de movimiento que necesites manejar
            default:
                // Tipo de movimiento no reconocido
                throw new IllegalArgumentException("Tipo de movimiento no válido: " + tipo);
        }

        try ( Connection conexion = this.conexionBD.crearConexion();  PreparedStatement comando = conexion.prepareStatement(consulta)) {

            // Configurar parámetros para la consulta
            comando.setInt(1, idCliente);

            // Ejecutar la consulta y procesar los resultados
            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {
                Object[] movimiento = {
                    resultado.getInt("IdTransaccion"),
                    resultado.getTimestamp("FechaHora").toLocalDateTime(),
                    resultado.getDouble("monto"),
                    resultado.getString(4), // Tipo de movimiento
                    resultado.getObject("noCuentaDestino") // No cuenta destino para transferencias
                };
                movimientos.add(movimiento);
            }

        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Error al buscar movimientos por tipo", e);
        }

        return movimientos;
    }

    @Override
    public void cancelarCuenta(int idCuenta) throws PersistenciaException {
        String consulta = "UPDATE Cuentas SET Estado = 'cancelada' WHERE IdCuenta = ?";

        try ( Connection conexion = this.conexionBD.crearConexion();  PreparedStatement comando = conexion.prepareStatement(consulta)) {

            comando.setInt(1, idCuenta);

            int filasActualizadas = comando.executeUpdate();

            if (filasActualizadas == 1) {
                System.out.println("La cuenta con ID " + idCuenta + " ha sido cancelada correctamente.");
            } else {
                System.out.println("No se pudo cancelar la cuenta con ID " + idCuenta + ". No se encontró la cuenta.");
            }
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "Error al cancelar la cuenta con ID " + idCuenta, e);
        }

    }

}
