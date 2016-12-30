/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import entidades.Categoria;
import entidades.Marca;
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
public class Producto_model {
    
    public List<Producto> obtenerProductos(){
        List<Producto> productos = new ArrayList<>();
        Conexion conn = new Conexion();
        try{
            conn.conectar();
            CallableStatement cmd = conn.getConexion().prepareCall("{ call obtenerproductos() }");
            if(cmd.execute()){
                ResultSet lector = cmd.getResultSet();
                while(lector.next()){
                    Producto producto = new Producto();
                    producto.setId(lector.getLong(1));
                    producto.setNombre(lector.getString(2));
                    producto.setDescripcion(lector.getString(3));
                    producto.setMarca(new Marca_model().obtenerMarca(new Marca(lector.getLong(4))));
                    producto.setCategoria(new Categoria_model().obtenerCategoria(new Categoria(lector.getLong(5))));
                    producto.setEstado(lector.getBoolean(6));
                    productos.add(producto);
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
        return productos;        
    }
    
    public Producto obtenerProducto(Producto pProducto){
        Conexion conn = new Conexion();
        Producto producto = new Producto();
        try{
            conn.conectar();
            CallableStatement cmd = conn.getConexion().prepareCall("{ call obtenerproductos() }");
            if(cmd.execute()){
                ResultSet lector = cmd.getResultSet();
                if(lector.next()){
                    producto.setId(lector.getLong(1));
                    producto.setNombre(lector.getString(2));
                    producto.setDescripcion(lector.getString(3));
                    producto.setMarca(new Marca_model().obtenerMarca(new Marca(lector.getLong(4))));
                    producto.setCategoria(new Categoria_model().obtenerCategoria(new Categoria(lector.getLong(5))));
                    producto.setEstado(lector.getBoolean(6));
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
        return producto;        
    }
    
    public boolean Agregar(Producto pProducto){
        boolean exito = false;
        Conexion conn = new Conexion();
        
        try{
            conn.conectar();
            CallableStatement cmd = conn.getConexion().prepareCall("{ call insertarproducto(?,?,?,?) }");
            cmd.setString(1, pProducto.getNombre());
            cmd.setString(2, pProducto.getDescripcion());
            cmd.setLong(3, pProducto.getMarca().getId());
            cmd.setLong(4, pProducto.getCategoria().getId());
            if(cmd.execute()){
                ResultSet lector = cmd.getResultSet();
                if(lector.next()){                    
                    long idprod = lector.getLong(1); //Agregar el registro de inventario
                    exito = true;
                }
            }
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
    
    public boolean Actualizar(Producto pProducto){
        boolean exito = false;
        Conexion conn = new Conexion();
        
        try{
            conn.conectar();
            CallableStatement cmd = conn.getConexion().prepareCall("{ call actualizarproducto(?,?,?,?,?) }"); 
            //modificar funcion para que retorne el exito y el idproducto para actualizar inventario
            cmd.setLong(1, pProducto.getId());
            cmd.setString(2, pProducto.getNombre());
            cmd.setString(3, pProducto.getDescripcion());
            cmd.setLong(4, pProducto.getMarca().getId());
            cmd.setLong(5, pProducto.getCategoria().getId());
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
    
    public boolean Eliminar(Producto pProducto){
        boolean exito = false;
        Conexion conn = new Conexion();
        
        try{
            conn.conectar();
            CallableStatement cmd = conn.getConexion().prepareCall("{ call eliminarproducto(?) }");
            //modificar para agregar la desactivacion de inventario
            cmd.setLong(1, pProducto.getId());
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
