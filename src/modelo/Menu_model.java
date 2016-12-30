/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author darkpastiursSennin
 */

import entidades.Menu;
import entidades.Nivel;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Menu_model {
    
    public List<Menu> obtenerMenus(Nivel pNivel){
        List<Menu> menus = new ArrayList<>();
        Conexion conn = new Conexion();
        try{
            conn.conectar();
            CallableStatement cmd = conn.getConexion().prepareCall("{ call cargarPermisos(?) }");
            cmd.setLong(1, pNivel.getId());
            if(cmd.execute()){
                ResultSet lector = cmd.getResultSet();
                while(lector.next()){
                    Menu menu = new Menu();
                    menu.setId(lector.getLong(1));
                    menu.setNombre(lector.getString(2));
                    menu.setPermiso(lector.getBoolean(3));
                    menus.add(menu);
                }
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(
                    null, 
                    "No se han cargado datos debido al error: \n" + ex.getMessage()
                            + "\nFavor contacte al desarrollador",
                    "Sistema de Compras y Ventas - Menu",
                    JOptionPane.ERROR_MESSAGE
            );
        } finally {
            conn.desconectar();
        }
        return menus;
    }
    
    public List<Menu> obtenerMenusnoNivel(){
        List<Menu> menus = new ArrayList<>();
        Conexion conn = new Conexion();
        try{
            conn.conectar();
            CallableStatement cmd = conn.getConexion().prepareCall("{ call obtenermenus() }");
            if(cmd.execute()){
                ResultSet lector = cmd.getResultSet();
                while(lector.next()){
                    Menu menu = new Menu();
                    menu.setId(lector.getLong(1));
                    menu.setNombre(lector.getString(2));
                    menus.add(menu);
                }
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(
                    null, 
                    "No se han cargado datos debido al error: \n" + ex.getMessage()
                            + "\nFavor contacte al desarrollador",
                    "Sistema de Compras y Ventas - Menu",
                    JOptionPane.ERROR_MESSAGE
            );
        } finally {
            conn.desconectar();
        }
        return menus;
    }
    
    public boolean Agregar(Menu pMenu, Nivel pNivel){
        boolean exito = false;
        Conexion conn = new Conexion();
        try{
            conn.conectar();
            CallableStatement cmd = conn.getConexion().prepareCall("{ call insertarpermiso(?,?,?) }");
            cmd.setLong(1, pNivel.getId());
            cmd.setLong(2, pMenu.getId());
            cmd.setBoolean(3, pMenu.isPermiso());
            if(cmd.execute()){
                exito = true;
            }
        } catch(Exception ex){
            JOptionPane.showMessageDialog(
                    null, 
                    "No se han agregado datos debido al error: \n" + ex.getMessage()
                            + "\nFavor contacte al desarrollador",
                    "Sistema de Compras y Ventas - Menu",
                    JOptionPane.ERROR_MESSAGE
            );
        } finally {
            conn.desconectar();
        }
        return exito;
    }
    
    public boolean editarPermisos(Menu pMenu, Nivel pNivel){
        boolean exito = false;
        Conexion conn = new Conexion();
        try{
            conn.conectar();
            CallableStatement cmd = conn.getConexion().prepareCall("{ call cambiarpermiso(?,?,?) }");
            cmd.setLong(1, pNivel.getId());
            cmd.setLong(2, pMenu.getId());
            cmd.setBoolean(3, pMenu.isPermiso());
            if(cmd.execute()){
                ResultSet lector = cmd.getResultSet();
                if(lector.next())                
                    exito = lector.getBoolean(1);
            }
        } catch(Exception ex){
            JOptionPane.showMessageDialog(
                    null, 
                    "No se han editado datos debido al error: \n" + ex.getMessage()
                            + "\nFavor contacte al desarrollador",
                    "Sistema de Compras y Ventas - Menu",
                    JOptionPane.ERROR_MESSAGE
            );
        } finally {
            conn.desconectar();
        }
        return exito;
    }
    
}
