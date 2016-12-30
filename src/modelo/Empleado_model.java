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
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Empleado_model {
    //Por en algun caso se llega a usar
    public List<Empleado> obtenerEmpleados(){
        List<Empleado> empleados = new ArrayList<>();
        Conexion conn = new Conexion();        
        try{
            conn.conectar();
            CallableStatement cmd = conn.getConexion().prepareCall("{ call obtenerEmpleados() }");
            if(cmd.execute()){
                ResultSet _reader = cmd.getResultSet();
                while(_reader.next()){
                    Empleado empleado = new Empleado();
                    empleado.setId(_reader.getInt(1));
                    empleado.setNombre(_reader.getString(2));
                    empleado.setApellidoPaterno(_reader.getString(3));
                    empleado.setApellidoMaterno(_reader.getObject(4) == null ? "" : _reader.getString(4)); 
                    empleado.setDUI(_reader.getString(5));
                    empleado.setNIT(_reader.getString(6));
                    empleado.setFechaNacimiento(_reader.getDate(7));
                    empleado.setGenero(_reader.getString(8).equals("F") ? "Femenino" : "Masculino");
                    empleado.setDireccion(_reader.getString(9));
                    empleado.setTelefono(_reader.getString(10));
                    empleado.setEmail(_reader.getString(11));
                    empleado.setEstado(_reader.getBoolean(12));
                    empleados.add(empleado);
                }
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(
                    null, 
                    "No se han cargado datos debido al error: \n" + ex.getMessage()
                            + "\nFavor contacte al desarrollador",
                    "Sistema de Compras y Ventas - Empleado",
                    JOptionPane.ERROR_MESSAGE
            );
        }finally{
            conn.desconectar();
        }
        return empleados;
    }
    
    public Empleado obtenerEmpleado(Empleado pEmpleado){
        Empleado empleado = new Empleado();
        Conexion conn = new Conexion();        
        try{
            conn.conectar();
            CallableStatement cmd = conn.getConexion().prepareCall("{ call obtenerEmpleado(?) }");
            cmd.setLong(1, pEmpleado.getId());
            if(cmd.execute()){
                ResultSet _reader = cmd.getResultSet();
                if(_reader.next()){
                    empleado.setId(_reader.getInt(1));
                    empleado.setNombre(_reader.getString(2));
                    empleado.setApellidoPaterno(_reader.getString(3));
                    empleado.setApellidoMaterno(_reader.getObject(4) == null ? "" : _reader.getString(4)); 
                    empleado.setDUI(_reader.getString(5));
                    empleado.setNIT(_reader.getString(6));
                    empleado.setFechaNacimiento(_reader.getDate(7));
                    empleado.setGenero(_reader.getString(8).equals("F") ? "Femenino" : "Masculino");
                    empleado.setDireccion(_reader.getString(9));
                    empleado.setTelefono(_reader.getString(10));
                    empleado.setEmail(_reader.getString(11));
                    empleado.setEstado(_reader.getBoolean(12));
                }
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(
                    null, 
                    "No se han cargado datos debido al error: \n" + ex.getMessage()
                            + "\nFavor contacte al desarrollador",
                    "Sistema de Compras y Ventas - Empleado",
                    JOptionPane.ERROR_MESSAGE
            );
        }finally{
            conn.desconectar();
        }
        return empleado;
    }
    
    
    public boolean Agregar(Empleado pEmpleado, Usuario pUsuario, Nivel pNivel){
        boolean exito = false;
        Conexion conn = new Conexion();
        try{
            conn.conectar();
            CallableStatement cmd = conn.getConexion().prepareCall("{ call insertarempleado(?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");
            cmd.setString(1, pEmpleado.getNombre());
            cmd.setString(2, pEmpleado.getApellidoPaterno());
            cmd.setString(3, pEmpleado.getApellidoMaterno());
            cmd.setString(4, pEmpleado.getDUI());
            cmd.setString(5, pEmpleado.getNIT());
            cmd.setDate(6, pEmpleado.getFechaNacimiento());
            cmd.setString(7, pEmpleado.getGenero());
            cmd.setString(8, pEmpleado.getDireccion());
            cmd.setString(9, pEmpleado.getTelefono());
            cmd.setString(10, pEmpleado.getEmail());
            cmd.setString(11, pUsuario.getNickname());
            cmd.setString(12, pUsuario.getContrasena());
            cmd.setLong(13, pNivel.getId());
            cmd.setBoolean(14, pUsuario.isEstado());
            if(cmd.execute()){
                exito = true;
            }
        }catch(Exception ex){            
            JOptionPane.showMessageDialog(
                    null, 
                    "No se han registrado datos debido al error: \n" + ex.getMessage()
                            + "\nFavor contacte al desarrollador",
                    "Sistema de Compras y Ventas - Empleado",
                    JOptionPane.ERROR_MESSAGE
            );
        } finally {
            conn.desconectar();
        }
        return exito;
    }
    
    public boolean Actualizar(Empleado pEmpleado, Usuario pUsuario, Nivel pNivel){
        boolean exito = false;
        Conexion conn = new Conexion();
        try{
            conn.conectar();            
            CallableStatement cmd = conn.getConexion().prepareCall("{ call actualizarempleado(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");
            cmd.setLong(1, pEmpleado.getId());
            cmd.setString(2, pEmpleado.getNombre());
            cmd.setString(3, pEmpleado.getApellidoPaterno());
            cmd.setString(4, pEmpleado.getApellidoMaterno());
            cmd.setString(5, pEmpleado.getDUI());
            cmd.setString(6, pEmpleado.getNIT());
            cmd.setDate(7, pEmpleado.getFechaNacimiento());
            cmd.setString(8, pEmpleado.getGenero());
            cmd.setString(9, pEmpleado.getDireccion());
            cmd.setString(10, pEmpleado.getTelefono());
            cmd.setString(11, pEmpleado.getEmail());
            cmd.setString(12, pUsuario.getNickname());
            if(pUsuario.getContrasena()== null){
                cmd.setNull(13, Types.VARCHAR);
            } else {
                cmd.setString(13, pUsuario.getContrasena());
            }
            cmd.setLong(14, pNivel.getId());
            cmd.setBoolean(15, pUsuario.isEstado());
            if(cmd.execute()){
                ResultSet lector = cmd.getResultSet();
                if (lector.next()){
                    if(lector.getBoolean(1)){                        
                        exito = true;
                    }
                }
            }
        }catch(Exception ex){            
            JOptionPane.showMessageDialog(
                    null, 
                    "No se han editado datos debido al error: \n" + ex.getMessage()
                    + "\nFavor contacte al desarrollador",
                    "Sistema de Compras y Ventas - Empleado",
                    JOptionPane.ERROR_MESSAGE
            );
        } finally {
            conn.desconectar();
        }
        return exito;
    }
    
    public boolean Eliminar(Empleado pEmpleado){
        boolean exito = false;
        Conexion conn = new Conexion();
        try{
            conn.conectar();
            CallableStatement cmd = conn.getConexion().prepareCall("{ call eliminarempleado(?) }");
            cmd.setLong(1, pEmpleado.getId());
            if(cmd.execute()){
                exito = true;
            }
        } catch(Exception ex){
            JOptionPane.showMessageDialog(
                    null, 
                    "No se ha eliminado el empleado debido al error: \n" + ex.getMessage() 
                    + "\nFavor contacte al desarrollador",
                    "Sistema de Compras y Ventas - Empleado",
                    JOptionPane.ERROR_MESSAGE
            );
        } finally {
            conn.desconectar();
        }
        
        return exito;
    }
    
}
