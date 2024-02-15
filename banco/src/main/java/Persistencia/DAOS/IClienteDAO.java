/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia.DAOS;

import Dominio.Cliente;
import Dominio.Domicilio;
import Persistencia.Conexion.DTO.ClienteNuevoDTO;
import Persistencia.Conexion.DTO.DomicilioNuevoDTO;
import Persistencia.Excepciones.PersistenciaException;

/**
 * Clase interfaz del DAO de Clientes
 * @author INEGI
 */
public interface IClienteDAO {

    /**
     * Metodo para agregar cliente
     * @param cliente
     * @return
     * @throws PersistenciaException
     */
    public Cliente agregarCliente(ClienteNuevoDTO cliente) throws PersistenciaException;

    /**
     * Metodo para agregar domicilio
     * @param direccion
     * @return
     * @throws PersistenciaException
     */
    public Domicilio agregarDomicilio(DomicilioNuevoDTO direccion) throws PersistenciaException;

}
