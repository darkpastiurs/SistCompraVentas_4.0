/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import entidades.Marca;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author darkpastiursSennin
 */
public class Marca_model {
    
    public List<Marca> obtenerMarcas(){
        List<Marca> marcas = new ArrayList<>();
        Conexion conn = new Conexion();
        try{
            conn.conectar();
            CallableStatement cmd = conn.getConexion().prepareCall("{ call obtenermarcas() }");
            if(cmd.execute()){
                ResultSet lector = cmd.getResultSet();
                while(lector.next()){
                    Marca marca = new Marca();
                    marca.setId(lector.getLong(1));
                    marca.setNombre(lector.getString(2));
                    marca.setEstado(lector.getBoolean(3));
                    marcas.add(marca);
                }
            }
        } catch(Exception ex){
            JOptionPane.showMessageDialog(
                    null, 
                    "No se han cargado datos debido al error: \n" + ex.getMessage()
                            + "\nFavor contacte al desarrollador",
                    "Sistema de Compras y Ventas - Marcas",
                    JOptionPane.ERROR_MESSAGE
            );
        } finally {
            conn.desconectar();
        }
        
        return marcas;
    }
    
    public Marca obtenerMarca(Marca pMarca){
        Marca marca = new Marca();
        Conexion conn = new Conexion();
        try{
            conn.conectar();
            CallableStatement cmd = conn.getConexion().prepareCall("{ call obtenermarca(?) }");
            cmd.setLong(1, pMarca.getId());
            if(cmd.execute()){
                ResultSet lector = cmd.getResultSet();
                if(lector.next()){
                    marca.setId(lector.getLong(1));
                    marca.setNombre(lector.getString(2));
                    marca.setEstado(lector.getBoolean(3));
                }
            }
        } catch(Exception ex){
            JOptionPane.showMessageDialog(
                    null, 
                    "No se han cargado datos debido al error: \n" + ex.getMessage()
                            + "\nFavor contacte al desarrollador",
                    "Sistema de Compras y Ventas - Marcas",
                    JOptionPane.ERROR_MESSAGE
            );
        } finally {
            conn.desconectar();
        }
        return marca;
    }
    
    public boolean Agregar(Marca pMarca){
        boolean exito = false;
        Conexion conn = new Conexion();
        try{
            conn.conectar();
            CallableStatement cmd = conn.getConexion().prepareCall("{ call insertarmarca(?) }");
            cmd.setString(1, pMarca.getNombre());
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
        } finally {
            conn.desconectar();
        }
        
        return exito;
    }
    
    public boolean Actualizar(Marca pMarca){
        boolean exito = false;
        Conexion conn = new Conexion();
        try{
            conn.conectar();
            CallableStatement cmd = conn.getConexion().prepareCall("{ call actualizarmarca(?,?) }");
            cmd.setLong(1, pMarca.getId());
            cmd.setString(2, pMarca.getNombre());
            if(cmd.execute()){
                ResultSet lector = cmd.getResultSet();
                if(lector.next()){
                    exito = lector.getBoolean(1);
                }
            }
        } catch(Exception ex){
            JOptionPane.showMessageDialog(
                    null, 
                    "No se han actualizado datos debido al error: \n" + ex.getMessage()
                            + "\nFavor contacte al desarrollador",
                    "Sistema de Compras y Ventas - Categorias",
                    JOptionPane.ERROR_MESSAGE
            );
        } finally {
            conn.desconectar();
        }
        
        return exito;
    }
    
    public boolean Eliminar(Marca pMarca){
        boolean exito = false;
        Conexion conn = new Conexion();
        try{
            conn.conectar();
            CallableStatement cmd = conn.getConexion().prepareCall("{ call eliminarmarca(?) }");
            cmd.setLong(1, pMarca.getId());
            if(cmd.execute()){
                ResultSet lector = cmd.getResultSet();
                if(lector.next()){
                    exito = true;
                }
            }
        } catch(Exception ex){
            JOptionPane.showMessageDialog(
                    null, 
                    "No se han eliminado datos debido al error: \n" + ex.getMessage()
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
