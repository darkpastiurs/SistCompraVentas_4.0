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

import entidades.Empleado;
import entidades.Nivel;
import entidades.Usuario;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Usuario_model {
    Conexion conn = new Conexion();
    
    
    public boolean login(Usuario pUsuario){
        boolean exito = false;
        
        try{
            conn.conectar();
            CallableStatement cmd = conn.getConexion().prepareCall("{ call login(?,?) }");
            cmd.setString(1, pUsuario.getNickname());
            cmd.setString(2, pUsuario.getContrasena());
            if(cmd.execute()){
                ResultSet _reader = cmd.getResultSet();
                if(_reader.next()){
                    exito = _reader.getBoolean(1);
                }
            }
        } catch(Exception ex){
            JOptionPane.showMessageDialog(
                    null, 
                    "No se han cargado datos debido al error: \n" + ex.getMessage()
                            + "\nFavor contacte al desarrollador",
                    "Sistema de Compras y Ventas - Usuario",
                    JOptionPane.ERROR_MESSAGE
            );
        } finally {
            conn.desconectar();
        }
        
        return exito;
    }
    
    
    public List<Usuario> obtenerUsuarios(){
        List<Usuario> usuarios = new ArrayList<>();        
        try{
            conn.conectar();
            CallableStatement cmd = conn.getConexion().prepareCall("{ call obtenerUsuarios() }");
            if(cmd.execute()){
                ResultSet lector = cmd.getResultSet();
                while(lector.next()){
                    Usuario usuario = new Usuario();
                    usuario.setNickname(lector.getString(1));
                    usuario.setEstado(lector.getBoolean(2));
                    usuario.setEmpleado(new Empleado_model().obtenerEmpleado(new Empleado(lector.getInt(3))));
                    usuario.setNivel(new Nivel_model().obtenerNivel(new Nivel(lector.getLong(4)), true));
                    usuarios.add(usuario);
                }
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(
                    null, 
                    "No se han cargado datos debido al error: \n" + ex.getMessage()
                            + "\nFavor contacte al desarrollador",
                    "Sistema de Compras y Ventas - Usuario",
                    JOptionPane.ERROR_MESSAGE
            );
        }finally{
            conn.desconectar();
        }
        return usuarios;
    }
    
    public Usuario obtenerUsuario(Usuario pUsuario){
        Usuario usuario = new Usuario();        
        try{
            conn.conectar();
            CallableStatement cmd = conn.getConexion().prepareCall("{ call obtenerUsuario(?) }");
            cmd.setString(1, pUsuario.getNickname());
            if(cmd.execute()){
                ResultSet _reader = cmd.getResultSet();
                if(_reader.next()){
                    usuario.setNickname(_reader.getString(1));
                    usuario.setEstado(_reader.getBoolean(2));
                    usuario.setEmpleado(new Empleado_model().obtenerEmpleado(new Empleado(_reader.getInt(3))));
                    usuario.setNivel(new Nivel_model().obtenerNivel(new Nivel(_reader.getLong(4)), true));
                }
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(
                    null, 
                    "No se han cargado datos debido al error: \n" + ex.getMessage()
                            + "\nFavor contacte al desarrollador",
                    "Sistema de Compras y Ventas - Usuario",
                    JOptionPane.ERROR_MESSAGE
            );
        }finally{
            conn.desconectar();
        }
        return usuario;
    }
    
}
