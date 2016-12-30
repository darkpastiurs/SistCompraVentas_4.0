/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import entidades.Proveedor;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author darkpastiursSennin
 */
public class Proveedor_model {
    
    public List<Proveedor> obtenerProveedores(){
        List<Proveedor> proveedores = new ArrayList<>();
        Conexion conn = new Conexion();
        try{
            conn.conectar();
            CallableStatement cmd = conn.getConexion().prepareCall("{ call obtenerproveedores() }");
            if(cmd.execute()){
                ResultSet lector = cmd.getResultSet();
                while(lector.next()){
                    Proveedor proveedor = new Proveedor();
                    proveedor.setId(lector.getLong(1));
                    proveedor.setNombre(lector.getString(2));
                    proveedor.setNIT(lector.getString(3));
                    proveedor.setNRC(lector.getString(4));
                    proveedor.setDireccion(lector.getString(5));
                    proveedor.setTelefono(lector.getString(6));
                    proveedor.setEmail(lector.getObject(7) == null ? "No posee correo" : lector.getString(7));
                    proveedor.setWebsite(lector.getObject(8) == null ? "No posee sitio web" : lector.getString(8));
                    proveedor.setEstado(lector.getBoolean(9));
                    proveedores.add(proveedor);
                }
            }
        } catch(Exception ex){
            JOptionPane.showMessageDialog(
                    null, 
                    "No se han cargado datos debido al error: \n" + ex.getMessage()
                            + "\nFavor contacte al desarrollador",
                    "Sistema de Compras y Ventas - Proveedor",
                    JOptionPane.ERROR_MESSAGE
            );
        } finally {
            conn.desconectar();
        }        
        return proveedores;
    }
    
    public Proveedor obtenerProveedor(Proveedor pProveedor){
        Proveedor proveedor = new Proveedor();
        Conexion conn = new Conexion();
        try{
            conn.conectar();
            CallableStatement cmd = conn.getConexion().prepareCall("{ call obtenerproveedor(?) }");
            cmd.setLong(1, pProveedor.getId());
            if(cmd.execute()){
                ResultSet lector = cmd.getResultSet();
                if(lector.next()){
                    proveedor.setId(lector.getLong(1));
                    proveedor.setNombre(lector.getString(2));
                    proveedor.setNIT(lector.getString(3));
                    proveedor.setNRC(lector.getString(4));
                    proveedor.setDireccion(lector.getString(5));
                    proveedor.setTelefono(lector.getString(6));
                    proveedor.setEmail(lector.getObject(7) == null ? "No posee correo" : lector.getString(7));
                    proveedor.setWebsite(lector.getObject(8) == null ? "No posee sitio web" : lector.getString(8));
                }
            }
        } catch(Exception ex){
            JOptionPane.showMessageDialog(
                    null, 
                    "No se han cargado datos debido al error: \n" + ex.getMessage()
                            + "\nFavor contacte al desarrollador",
                    "Sistema de Compras y Ventas - Proveedor",
                    JOptionPane.ERROR_MESSAGE
            );
        } finally {
            conn.desconectar();
        }        
        return proveedor;
    }
    
    public boolean Agregar(Proveedor pProveedor){
        boolean exito = true;
        Conexion conn = new Conexion();
        try{
            conn.conectar();
            CallableStatement cmd = conn.getConexion().prepareCall("{ call insertarproveedor(?,?,?,?,?,?,?) }");
            cmd.setString(1, pProveedor.getNombre());
            cmd.setString(2, pProveedor.getNIT());
            cmd.setString(3, pProveedor.getNRC(true));
            cmd.setString(4, pProveedor.getDireccion());
            cmd.setString(5, pProveedor.getTelefono());
            cmd.setString(6, pProveedor.getEmail());
            cmd.setString(7, pProveedor.getWebsite());
            exito = cmd.execute();
        } catch(Exception ex){
             JOptionPane.showMessageDialog(
                    null, 
                    "No se han registrado los datos debido al error: \n" + ex.getMessage()
                            + "\nFavor contacte al desarrollador",
                    "Sistema de Compras y Ventas - Proveedor",
                    JOptionPane.ERROR_MESSAGE
            );
        } finally {
            conn.desconectar();
        }   
        return exito;
    }
    
    public boolean Actualizar(Proveedor pProveedor){
        boolean exito = true;
        Conexion conn = new Conexion();
        try{
            conn.conectar();
            CallableStatement cmd = conn.getConexion().prepareCall("{ call actualizarproveedor(?,?,?,?,?,?,?,?) }");
            cmd.setLong(1, pProveedor.getId());
            cmd.setString(2, pProveedor.getNombre());
            cmd.setString(3, pProveedor.getNIT());
            cmd.setString(4, pProveedor.getNRC(true));
            cmd.setString(5, pProveedor.getDireccion());
            cmd.setString(6, pProveedor.getTelefono());
            cmd.setString(7, pProveedor.getEmail());
            cmd.setString(8, pProveedor.getWebsite());
            if(cmd.execute()){
                ResultSet lector = cmd.getResultSet();
                if(lector.next()){
                    exito = lector.getBoolean(1);
                }
            }
        } catch(Exception ex){
             JOptionPane.showMessageDialog(
                    null, 
                    "No se han registrado los datos debido al error: \n" + ex.getMessage()
                            + "\nFavor contacte al desarrollador",
                    "Sistema de Compras y Ventas - Proveedor",
                    JOptionPane.ERROR_MESSAGE
            );
        } finally {
            conn.desconectar();
        }   
        return exito;
    }
    
    public boolean Eliminar(Proveedor pProveedor){
        boolean exito = true;
        Conexion conn = new Conexion();
        try{
            conn.conectar();
            CallableStatement cmd = conn.getConexion().prepareCall("{ call eliminarproveedor(?) }");
            cmd.setLong(1, pProveedor.getId());
            if(cmd.execute()){
                ResultSet lector = cmd.getResultSet();
                if(lector.next()){
                    exito = lector.getBoolean(1);
                }
            }
        } catch(Exception ex){
             JOptionPane.showMessageDialog(
                    null, 
                    "No se han registrado los datos debido al error: \n" + ex.getMessage()
                            + "\nFavor contacte al desarrollador",
                    "Sistema de Compras y Ventas - Proveedor",
                    JOptionPane.ERROR_MESSAGE
            );
        } finally {
            conn.desconectar();
        }   
        return exito;
    }
}
