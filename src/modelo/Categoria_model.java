/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import entidades.Categoria;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author darkpastiursSennin
 */
public class Categoria_model {
    
    public List<Categoria> obtenerCategorias(){
        List<Categoria> categorias = new ArrayList<>();
        Conexion conn = new Conexion();
        try{
            conn.conectar();
            CallableStatement cmd = conn.getConexion().prepareCall("{ call obtenercategorias() }");
            if(cmd.execute()){
                ResultSet lector = cmd.getResultSet();
                while(lector.next()){
                    Categoria categoria = new Categoria();
                    categoria.setId(lector.getLong(1));
                    categoria.setNombre(lector.getString(2));
                    categoria.setEstado(lector.getBoolean(3));
                    categorias.add(categoria);
                }
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(
                    null, 
                    "No se han cargado datos debido al error: \n" + ex.getMessage()
                            + "\nFavor contacte al desarrollador",
                    "Sistema de Compras y Ventas - Categorias",
                    JOptionPane.ERROR_MESSAGE
            );
        } finally {
            conn.desconectar();
        }
        return categorias;
    }
    
    public Categoria obtenerCategoria(Categoria pCategoria){
        Categoria categoria = new Categoria();
        Conexion conn = new Conexion();
        try{
            conn.conectar();
            CallableStatement cmd = conn.getConexion().prepareCall("{ call obtenercategoria(?) }");
            cmd.setLong(1,pCategoria.getId());
            if(cmd.execute()){
                ResultSet lector = cmd.getResultSet();
                if(lector.next()){
                    categoria.setId(lector.getLong(1));
                    categoria.setNombre(lector.getString(2));
                }
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(
                    null, 
                    "No se han cargado datos debido al error: \n" + ex.getMessage()
                            + "\nFavor contacte al desarrollador",
                    "Sistema de Compras y Ventas - Categorias",
                    JOptionPane.ERROR_MESSAGE
            );
        } finally {
            conn.desconectar();
        }
        return categoria;
    }
    
    public boolean Agregar(Categoria pCategoria){
        boolean exito = false;
        Conexion conn = new Conexion();
        try{
            conn.conectar();
            CallableStatement cmd = conn.getConexion().prepareCall("{ call insertarcategoria(?)}");
            cmd.setString(1, pCategoria.getNombre());
            if(cmd.execute()){
                exito = true;
            }
        } catch(Exception ex){
            JOptionPane.showMessageDialog(
                    null, 
                    "No se han registrado datos debido al error: \n" + ex.getMessage()
                            + "\nFavor contacte al desarrollador",
                    "Sistema de Compras y Ventas - Categorias",
                    JOptionPane.ERROR_MESSAGE
            );
        } finally{
            conn.desconectar();
        }
        return exito;
    }
    
    public boolean Actualizar(Categoria pCategoria){
        boolean exito = false;
        Conexion conn = new Conexion();
        try{
            conn.conectar();
            CallableStatement cmd = conn.getConexion().prepareCall("{ call actualizarcategoria(?,?)}");
            cmd.setLong(1, pCategoria.getId());
            cmd.setString(2, pCategoria.getNombre());
            if(cmd.execute()){
                ResultSet lector = cmd.getResultSet();
                if(lector.next()){
                    exito = lector.getBoolean(1);                    
                }
            }
        } catch(Exception ex){
            JOptionPane.showMessageDialog(
                    null, 
                    "No se han registrado datos debido al error: \n" + ex.getMessage()
                            + "\nFavor contacte al desarrollador",
                    "Sistema de Compras y Ventas - Categorias",
                    JOptionPane.ERROR_MESSAGE
            );
        } finally{
            conn.desconectar();
        }
        return exito;
    }
    
    public boolean Eliminar(Categoria pCategoria){
        boolean exito = false;
        Conexion conn = new Conexion();
        try{
            conn.conectar();
            CallableStatement cmd = conn.getConexion().prepareCall("{ call eliminarcategoria(?) }");
            cmd.setLong(1, pCategoria.getId());
            if(cmd.execute()){
                ResultSet lector = cmd.getResultSet();
                if(lector.next()){
                    exito = lector.getBoolean(1);
                }
            }
        } catch(Exception ex){
            JOptionPane.showMessageDialog(
                    null, 
                    "No se han eliminados datos debido al error: \n" + ex.getMessage()
                            + "\nFavor contacte al desarrollador",
                    "Sistema de Compras y Ventas - Categorias",
                    JOptionPane.ERROR_MESSAGE
            );
        } finally {
            conn.desconectar();
        }
        return exito;
    }
}
