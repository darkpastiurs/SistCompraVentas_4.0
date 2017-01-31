/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import entidades.Inventario;
import entidades.Producto;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author darkpastiursSennin
 */
public class Inventario_model {
    
    public List<Inventario> obtenerInventarios(){
        List<Inventario> inventarios = new ArrayList<>();
        Conexion conn = new Conexion();
        try{
            conn.conectar();
            CallableStatement cmd = conn.getConexion().prepareCall("{ call obtenerinventarios() }");
            if(cmd.execute()){
                ResultSet lector = cmd.getResultSet();
                while(lector.next()){
                    Inventario inventario = new Inventario();
                    inventario.setId(lector.getLong(1));
                    inventario.setStock(lector.getBigDecimal(2));
                    inventario.setPrecio(lector.getBigDecimal(3));
                    inventario.setProducto(new Producto_model().obtenerProducto(new Producto(lector.getLong(4))));
                    inventario.setEstado(lector.getBoolean(5));
                    inventarios.add(inventario);
                }
            }
        } catch(Exception ex){
            JOptionPane.showMessageDialog(
                    null, 
                    "No se han cargado datos debido al error: \n" + ex.getMessage()
                            + "\nFavor contacte al desarrollador",
                    "Sistema de Compras y Ventas - Producto",
                    JOptionPane.ERROR_MESSAGE
            );
        } finally {
            conn.desconectar();
        }
        return inventarios;        
    }
    
    public Inventario obtenerInventario(Inventario pInventario){
        Conexion conn = new Conexion();
        Inventario inventario = new Inventario();
        try{
            conn.conectar();
            CallableStatement cmd = conn.getConexion().prepareCall("{ call obtenerinventario(?) }");
            cmd.setLong(1, pInventario.getId());
            if(cmd.execute()){
                ResultSet lector = cmd.getResultSet();
                if(lector.next()){
                    inventario.setId(lector.getLong(1));
                    inventario.setStock(lector.getBigDecimal(2));
                    inventario.setPrecio(lector.getBigDecimal(3));
                    inventario.setProducto(new Producto_model().obtenerProducto(new Producto(lector.getLong(4))));
                    inventario.setEstado(lector.getBoolean(5));
                }
            }
        } catch(Exception ex){
            JOptionPane.showMessageDialog(
                    null, 
                    "No se han cargado datos debido al error: \n" + ex.getMessage()
                            + "\nFavor contacte al desarrollador",
                    "Sistema de Compras y Ventas - Producto",
                    JOptionPane.ERROR_MESSAGE
            );
        } finally {
            conn.desconectar();
        }
        return inventario;        
    }
    
    public boolean Agregar(Inventario pInventario){
        boolean exito = false;
        Conexion conn = new Conexion();
        try{
            conn.conectar();
            CallableStatement cmd = conn.getConexion().prepareCall("{ call insertarproducto(?,?,?,?,?) }");
            cmd.setString(1, pInventario.getProducto().getNombre());
            cmd.setString(2, pInventario.getProducto().getDescripcion());
            cmd.setLong(3, pInventario.getProducto().getMarca().getId());
            cmd.setLong(4, pInventario.getProducto().getCategoria().getId());
            cmd.setBigDecimal(5, pInventario.getPrecio());
            exito = cmd.execute();
        } catch(Exception ex){
            JOptionPane.showMessageDialog(
                    null, 
                    "No se han registrado datos debido al error: \n" + ex.getMessage()
                            + "\nFavor contacte al desarrollador",
                    "Sistema de Compras y Ventas - Producto",
                    JOptionPane.ERROR_MESSAGE
            );
        } finally {
            conn.desconectar();
        }
        return exito;
    }
    
    public boolean Actualizar(Inventario pInventario){
        boolean exito = false;
        Conexion conn = new Conexion();
        
        try{
            conn.conectar();
            CallableStatement cmd = conn.getConexion().prepareCall("{ call actualizarproducto(?,?,?,?,?,?) }"); 
            //modificar funcion para que retorne el exito y el idproducto para actualizar inventario
            cmd.setLong(1, pInventario.getId());
            cmd.setString(2, pInventario.getProducto().getNombre());
            cmd.setString(3, pInventario.getProducto().getDescripcion());
            cmd.setLong(4, pInventario.getProducto().getMarca().getId());
            cmd.setLong(5, pInventario.getProducto().getCategoria().getId());
            cmd.setBigDecimal(6, pInventario.getPrecio());
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
                    "Sistema de Compras y Ventas - Producto",
                    JOptionPane.ERROR_MESSAGE
            );
        } finally {
            conn.desconectar();
        }
        
        return exito;
    }
    
    public boolean Eliminar(Inventario pInventario){
        boolean exito = false;
        Conexion conn = new Conexion();
        
        try{
            conn.conectar();
            CallableStatement cmd = conn.getConexion().prepareCall("{ call eliminarproducto(?) }");
            //modificar para agregar la desactivacion de inventario
            cmd.setLong(1, pInventario.getId());
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
                    "Sistema de Compras y Ventas - Producto",
                    JOptionPane.ERROR_MESSAGE
            );
        } finally {
            conn.desconectar();
        }
        
        return exito;
    }
    
}
