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
}
