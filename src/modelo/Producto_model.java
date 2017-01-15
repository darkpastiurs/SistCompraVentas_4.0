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
    
    public Producto obtenerProducto(Producto pProducto){
        Conexion conn = new Conexion();
        Producto producto = new Producto();
        try{
            conn.conectar();
            CallableStatement cmd = conn.getConexion().prepareCall("{ call obtenerproducto(?) }");
            cmd.setLong(1, pProducto.getId());
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
}
