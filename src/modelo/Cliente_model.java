/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import entidades.Cliente;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author darkpastiursSennin
 */
public class Cliente_model {
    
    public List<Cliente> obtenerClientes(){
        List<Cliente> clientes = new ArrayList<>();
        Conexion conn = new Conexion();
        try{
            conn.conectar();
            CallableStatement cmd = conn.getConexion().prepareCall("{ call obtenerclientes() }");
            if(cmd.execute()){
                ResultSet lector = cmd.getResultSet();
                while(lector.next()){
                    Cliente cliente = new Cliente();
                    cliente.setId(lector.getLong(1));
                    cliente.setNombre(lector.getString(2));
                    cliente.setApellidoPaterno(lector.getString(3));
                    cliente.setApellidoMaterno(lector.getObject(4) == null ? "" : lector.getString(4)); 
                    cliente.setDUI(lector.getString(5));
                    cliente.setNIT(lector.getString(6));
                    cliente.setFechaNacimiento(lector.getDate(7));                       
                    cliente.setGenero(lector.getString(8).equals("F") ? "Femenino" : "Masculino");
                    cliente.setDireccion(lector.getString(9));
                    cliente.setTelefono(lector.getString(10));
                    cliente.setEmail(lector.getString(11));
                    cliente.setEstado(lector.getBoolean(12));
                    clientes.add(cliente);
                }
            }
        } catch(Exception ex){
            JOptionPane.showMessageDialog(
                    null, 
                    "No se han cargado datos debido al error: \n" + ex.getMessage()
                            + "\nFavor contacte al desarrollador",
                    "Sistema de Compras y Ventas - Cliente",
                    JOptionPane.ERROR_MESSAGE
            );
        } finally{
            conn.desconectar();
        }
        return clientes;
    }
    
    public Cliente obtenerCliente(Cliente pCliente){;
        Conexion conn = new Conexion();
        Cliente cliente = new Cliente();
        try{
            conn.conectar();
            CallableStatement cmd = conn.getConexion().prepareCall("{ call obtenercliente(?) }");
            cmd.setLong(1, pCliente.getId());
            if(cmd.execute()){
                ResultSet lector = cmd.getResultSet();
                if(lector.next()){
                    cliente.setId(lector.getLong(1));
                    cliente.setNombre(lector.getString(2));
                    cliente.setApellidoPaterno(lector.getString(3));
                    cliente.setApellidoMaterno(lector.getString(4));
                    cliente.setDUI(lector.getString(5));
                    cliente.setNIT(lector.getString(6));
                    cliente.setFechaNacimiento(lector.getDate(7));
                    cliente.setGenero(lector.getString(8));
                    cliente.setDireccion(lector.getString(9));
                    cliente.setTelefono(lector.getString(10));
                    cliente.setEmail(lector.getString(11));
                    cliente.setEstado(lector.getBoolean(12));
                }
            }
        } catch(Exception ex){
            JOptionPane.showMessageDialog(
                    null, 
                    "No se han cargado datos debido al error: \n" + ex.getMessage()
                            + "\nFavor contacte al desarrollador",
                    "Sistema de Compras y Ventas - Cliente",
                    JOptionPane.ERROR_MESSAGE
            );
        } finally{
            conn.desconectar();
        }
        return cliente;
    }
    
    public boolean Agregar(Cliente pCliente){
        boolean exito = false;
        Conexion conn = new Conexion();
        try{
            conn.conectar();
            CallableStatement cmd = conn.getConexion().prepareCall("{ call insertarcliente(?,?,?,?,?,?,?,?,?,?) }");
            cmd.setString(1, pCliente.getNombre());
            cmd.setString(2, pCliente.getApellidoPaterno());
            cmd.setString(3, pCliente.getApellidoMaterno());
            cmd.setString(4, pCliente.getDUI());
            cmd.setString(5, pCliente.getNIT());
            cmd.setDate(6, pCliente.getFechaNacimiento());
            cmd.setString(7, pCliente.getGenero());
            cmd.setString(8, pCliente.getDireccion());
            cmd.setString(9, pCliente.getTelefono());
            cmd.setString(10, pCliente.getEmail());
            if(cmd.execute()){
                exito = true;
            }
        } catch(Exception ex){
            JOptionPane.showMessageDialog(
                    null, 
                    "No se han registrado los datos debido al error: \n" + ex.getMessage()
                            + "\nFavor contacte al desarrollador",
                    "Sistema de Compras y Ventas - Cliente",
                    JOptionPane.ERROR_MESSAGE
            );
        } finally {
            
        }
        return exito;
    }
    
    public boolean Actualizar(Cliente pCliente){
        boolean exito = false;
        Conexion conn = new Conexion();
        try{
            conn.conectar();
            CallableStatement cmd = conn.getConexion().prepareCall("{ call actualizarclientes(?,?,?,?,?,?,?,?,?,?,?) }");
            cmd.setLong(1, pCliente.getId());
            cmd.setString(2, pCliente.getNombre());
            cmd.setString(3, pCliente.getApellidoPaterno());
            cmd.setString(4, pCliente.getApellidoMaterno());
            cmd.setString(5, pCliente.getDUI());
            cmd.setString(6, pCliente.getNIT());
            cmd.setDate(7, pCliente.getFechaNacimiento());
            cmd.setString(8, pCliente.getGenero());
            cmd.setString(9, pCliente.getDireccion());
            cmd.setString(10, pCliente.getTelefono());
            cmd.setString(11, pCliente.getEmail());
            if(cmd.execute()){
                ResultSet lector = cmd.getResultSet();
                if(lector.next()){
                    exito = lector.getBoolean(1);                    
                }
            }
        } catch(Exception ex){
            JOptionPane.showMessageDialog(
                    null, 
                    "No se han editado datos debido al error: \n" + ex.getMessage()
                            + "\nFavor contacte al desarrollador",
                    "Sistema de Compras y Ventas - Cliente",
                    JOptionPane.ERROR_MESSAGE);
        } finally {
            conn.desconectar();
        }
        return exito;
    }
    
    public boolean Eliminar(Cliente pCliente){
        boolean exito = false;
        Conexion conn = new Conexion();
        try{
            conn.conectar();
            CallableStatement cmd = conn.getConexion().prepareCall("{ call eliminarcliente(?) }");
            cmd.setLong(1, pCliente.getId());
            if(cmd.execute()){
                ResultSet lector = cmd.getResultSet();
                if(lector.next()){                    
                    exito = lector.getBoolean(1);
                }
            }
        } catch(Exception ex){
            JOptionPane.showMessageDialog(
                    null, 
                    "No se han eliminado datos debido al error: \n" + ex.getMessage()
                            + "\nFavor contacte al desarrollador",
                    "Sistema de Compras y Ventas - Cliente",
                    JOptionPane.ERROR_MESSAGE);
        } finally {
            conn.desconectar();
        }
        return exito;
    }
    
}
