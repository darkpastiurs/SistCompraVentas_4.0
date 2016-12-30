/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import entidades.Nivel;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author darkpastiursSennin
 */
public class Nivel_model {
    
    //EL parametro de menus es para cargar o no los menus en la consulta
    public Nivel obtenerNivel(Nivel pNivel, boolean menus){
        Nivel nivel = new Nivel();
        Conexion conn = new Conexion();
        try{
            conn.conectar();
            CallableStatement cmd = conn.getConexion().prepareCall("{ call obtenernivel(?) }");
            cmd.setLong(1, pNivel.getId());
            if(cmd.execute()){
                ResultSet lector = cmd.getResultSet();
                if(lector.next()){                    
                    nivel.setId(lector.getLong(1));
                    nivel.setNombre(lector.getString(2));
                    nivel.setEstado(lector.getBoolean(3));
                    if(menus){                        
                        nivel.setMenus(new Menu_model().obtenerMenus(pNivel));
                    }
                }
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(
                    null, 
                    "No se han cargado datos debido al error: \n" + ex.getMessage()
                            + "\nFavor contacte al desarrollador",
                    "Sistema de Compras y Ventas - Nivel",
                    JOptionPane.ERROR_MESSAGE
            );
        } finally {
            conn.desconectar();
        }
        return nivel;
    }    
   
    
    public List<Nivel> obtenerNiveles(boolean menus){
        List<Nivel> niveles = new ArrayList<>();
        Conexion conn = new Conexion();
        try{
            conn.conectar();
            CallableStatement cmd = conn.getConexion().prepareCall("{ call obtenerniveles() }");
            if(cmd.execute()){
                ResultSet lector = cmd.getResultSet();
                while(lector.next()){
                    Nivel nivel = new Nivel();
                    nivel.setId(lector.getLong(1));
                    nivel.setNombre(lector.getString(2));
                    nivel.setEstado(lector.getBoolean(3));
                    if(menus){                        
                        nivel.setMenus(new Menu_model().obtenerMenus(new Nivel(nivel.getId())));
                    }
                    niveles.add(nivel);
                }
            }
        } catch(Exception ex){
            JOptionPane.showMessageDialog(
                    null, 
                    "No se han cargado datos debido al error: \n" + ex.getMessage()
                            + "\nFavor contacte al desarrollador",
                    "Sistema de Compras y Ventas - Nivel",
                    JOptionPane.ERROR_MESSAGE
            );
        } finally {
            conn.desconectar();
        }
        return niveles;
    }
    
    public boolean Agregar(Nivel pNivel){
        boolean exito = false;
        Conexion conn = new Conexion();
        try{
            conn.conectar();
            CallableStatement cmd = conn.getConexion().prepareCall("{ call insertarnivel(?) }");
            cmd.setString(1, pNivel.getNombre());
            if(cmd.execute()){
                exito = true;
            }
        } catch(Exception ex){
            JOptionPane.showMessageDialog(
                    null, 
                    "No se han registrado datos debido al error: \n" + ex.getMessage()
                            + "\nFavor contacte al desarrollador",
                    "Sistema de Compras y Ventas - Nivel",
                    JOptionPane.ERROR_MESSAGE
            );
        } finally {
            conn.desconectar();
        }
        return exito;
    }
    
    public boolean Actualizar(Nivel pNivel){
        boolean exito = false;
        Conexion conn = new Conexion();
        try{
            conn.conectar();
            CallableStatement cmd = conn.getConexion().prepareCall("{ call actualizarnivel(?,?) }");
            cmd.setLong(1, pNivel.getId());
            cmd.setString(2, pNivel.getNombre());
            if(cmd.execute()){
                exito = true;
            }
        } catch(Exception ex){
            JOptionPane.showMessageDialog(
                    null, 
                    "No se han editado datos debido al error: \n" + ex.getMessage()
                            + "\nFavor contacte al desarrollador",
                    "Sistema de Compras y Ventas - Nivel",
                    JOptionPane.ERROR_MESSAGE
            );
        } finally {
            conn.desconectar();
        }
        return exito;
    }
    
    public boolean Eliminar(Nivel pNivel){
        boolean exito = false;
        Conexion conn = new Conexion();
        try{
            conn.conectar();
            CallableStatement cmd = conn.getConexion().prepareCall("{ call eliminarnivel(?) }");
            cmd.setLong(1, pNivel.getId());
            if(cmd.execute()){
                exito = true;
            }
        } catch(Exception ex){
            JOptionPane.showMessageDialog(
                    null, 
                    "No se han editado datos debido al error: \n" + ex.getMessage()
                            + "\nFavor contacte al desarrollador",
                    "Sistema de Compras y Ventas - Nivel",
                    JOptionPane.ERROR_MESSAGE
            );
        } finally {
            conn.desconectar();
        }
        return exito;
    }
}
