/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import entidades.UnidadesMedida;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author darkpastiursSennin
 */
public class UnidadesMedida_model {
    
    List<UnidadesMedida> obtenerMedidas(){
        List<UnidadesMedida> medidas = new ArrayList<>();
        Conexion conn = new Conexion();
        try{
            conn.conectar();
            CallableStatement cmd = conn.getConexion().prepareCall("{ call obtenermedidas() }");
            if(cmd.execute()){
                ResultSet lector = cmd.getResultSet();
                while(lector.next()){
                    UnidadesMedida medida = new UnidadesMedida();
                    medida.setId(lector.getLong(1));
                    medida.setNombre(lector.getString(2));
                    if(lector.getObject(3) != null){
                        medida.setConvertir(obtenerMedida(medida));
                        medida.setEquivalencia(lector.getDouble(4));
                    }
                    medida.setEstado(lector.getBoolean(5));
                    medidas.add(medida);
                }
            }
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(
                    null, 
                    "No se han cargado datos debido al error: \n" + ex.getMessage()
                            + "\nFavor contacte al desarrollador",
                    "Sistema de Compras y Ventas - Unidades de Medida",
                    JOptionPane.ERROR_MESSAGE
            );
        } finally {
            conn.desconectar();
        }
        return medidas;
    }
    
    UnidadesMedida obtenerMedida(UnidadesMedida pUnidad){
        UnidadesMedida medida = new UnidadesMedida();
        Conexion conn = new Conexion();
        try{
            conn.conectar();
            CallableStatement cmd = conn.getConexion().prepareCall("{ call obtenermedidas() }");
            if(cmd.execute()){
                ResultSet lector = cmd.getResultSet();
                if(lector.next()){
                    medida.setId(lector.getLong(1));
                    medida.setNombre(lector.getString(2));
                    if(lector.getObject(3) != null){
                        medida.setConvertir(obtenerMedida(medida));
                        medida.setEquivalencia(lector.getDouble(4));
                    }
                    medida.setEstado(lector.getBoolean(5));
                }
            }
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(
                    null, 
                    "No se han cargado datos debido al error: \n" + ex.getMessage()
                            + "\nFavor contacte al desarrollador",
                    "Sistema de Compras y Ventas - Unidades de Medida",
                    JOptionPane.ERROR_MESSAGE
            );
        } finally {
            conn.desconectar();
        }
        return medida;
    }
    
    boolean Agregar(UnidadesMedida pUnidad){
        boolean exito = false;
        Conexion conn = new Conexion();
        try{
            conn.conectar();
            CallableStatement cmd = conn.getConexion().prepareCall("{ call insertarmedida(?,?,?) }");
            cmd.setString(1, pUnidad.getNombre());
            if(pUnidad.getConvertir().getId() == 0){
                cmd.setNull(2, java.sql.Types.BIGINT);
                cmd.setNull(3, java.sql.Types.NUMERIC);
            } else {
                cmd.setLong(2, pUnidad.getConvertir().getId());
                cmd.setDouble(3, pUnidad.getEquivalencia());
            }
            if(cmd.execute()){
                exito = true;
            }
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(
                    null, 
                    "No se han ingresado datos debido al error: \n" + ex.getMessage()
                            + "\nFavor contacte al desarrollador",
                    "Sistema de Compras y Ventas - Unidades de Medida",
                    JOptionPane.ERROR_MESSAGE
            );
        } finally {
            conn.desconectar();
        }
        return exito;
    }
    
    boolean Actualizar(UnidadesMedida pUnidad){
        boolean exito = false;
        Conexion conn = new Conexion();
        try{
            conn.conectar();
            CallableStatement cmd = conn.getConexion().prepareCall("{ call actualizarmedida(?,?,?,?) }");
            cmd.setLong(1, pUnidad.getId());
            cmd.setString(2, pUnidad.getNombre());
            if(pUnidad.getConvertir().getId() == 0){
                cmd.setNull(3, java.sql.Types.BIGINT);
                cmd.setNull(4, java.sql.Types.NUMERIC);
            } else {
                cmd.setLong(3, pUnidad.getConvertir().getId());
                cmd.setDouble(4, pUnidad.getEquivalencia());
            }
            if(cmd.execute()){
                ResultSet lector = cmd.getResultSet();
                if(lector.next()){
                    exito = lector.getBoolean(1);
                }
            }
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(
                    null, 
                    "No se han editado datos debido al error: \n" + ex.getMessage()
                            + "\nFavor contacte al desarrollador",
                    "Sistema de Compras y Ventas - Unidades de Medida",
                    JOptionPane.ERROR_MESSAGE
            );
        } finally {
            conn.desconectar();
        }
        return exito;
    }
    
    boolean Eliminar(UnidadesMedida pUnidad){
        boolean exito = false;
        Conexion conn = new Conexion();
        try{
            conn.conectar();
            CallableStatement cmd = conn.getConexion().prepareCall("{ call eliminarmedida(?,?,?,?) }");
            cmd.setLong(1, pUnidad.getId());
            cmd.setString(2, pUnidad.getNombre());
            if(pUnidad.getConvertir().getId() == 0){
                cmd.setNull(3, java.sql.Types.BIGINT);
                cmd.setNull(4, java.sql.Types.NUMERIC);
            } else {
                cmd.setLong(3, pUnidad.getConvertir().getId());
                cmd.setDouble(4, pUnidad.getEquivalencia());
            }
            if(cmd.execute()){
                ResultSet lector = cmd.getResultSet();
                if(lector.next()){
                    exito = lector.getBoolean(1);
                }
            }
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(
                    null, 
                    "No se han editado datos debido al error: \n" + ex.getMessage()
                            + "\nFavor contacte al desarrollador",
                    "Sistema de Compras y Ventas - Unidades de Medida",
                    JOptionPane.ERROR_MESSAGE
            );
        } finally {
            conn.desconectar();
        }
        return exito;
    }
}
