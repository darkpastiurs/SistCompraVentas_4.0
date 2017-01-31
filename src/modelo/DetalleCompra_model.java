/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import entidades.Compra;
import entidades.DetalleCompra;
import entidades.Inventario;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author darkpastiursSennin
 */
public class DetalleCompra_model {
    
    public List<DetalleCompra> Obtener(Compra pCompra){
        List<DetalleCompra> detalles = new ArrayList<>();
        Conexion conn = new Conexion();
        try{
            conn.conectar();
            CallableStatement cmd = conn.getConexion().prepareCall("{ call obtenerdetallescompra(?) }");
            cmd.setLong(1, pCompra.getId());
            if(cmd.execute()){
                ResultSet lector = cmd.getResultSet();
                while(lector.next()){
                    DetalleCompra detalle = new DetalleCompra();
                    detalle.setInventario(new Inventario_model().obtenerInventario(new Inventario(lector.getLong(1))));
                    detalle.setCantidad(lector.getBigDecimal(2));
                    detalle.setPrecioUnitario(lector.getBigDecimal(3));
                    detalle.setPrecioTotal(lector.getBigDecimal(4));
                    detalles.add(detalle);
                }
            }
        } catch(Exception ex){
            JOptionPane.showMessageDialog(
                    null, 
                    "No se han registrado los datos debido al error: \n" + ex.getMessage()
                            + "\nFavor contacte al desarrollador",
                    "Sistema de Compras y Ventas - Detalles de la compra",
                    JOptionPane.ERROR_MESSAGE
            );
        } finally {
            conn.desconectar();
        }    
        return detalles;
    }
    
}
