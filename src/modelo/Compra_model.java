/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import entidades.Compra;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import javax.swing.JOptionPane;
import org.json.JSONArray;
import org.json.JSONObject;
import org.postgresql.util.PGobject;

/**
 *
 * @author darkpastiursSennin
 */
public class Compra_model {
    
    public boolean Agregar(Compra pCompra){
        boolean exito = false;
        Conexion conn = new Conexion();
        try{
            conn.conectar();
            CallableStatement cmd = conn.getConexion().prepareCall("{call insertarcompra(?,?,?,?,?,?,?)}");            
            JSONArray jsona = new JSONArray();
            pCompra.getDetalleCompra().stream().forEach(detalle ->{
                JSONObject jsono = new JSONObject();
                jsono.put("idinv", detalle.getInventario().getId());
                jsono.put("cantidad", detalle.getCantidad());
                jsono.put("preciouni", detalle.getPrecioUnitario());
                jsono.put("precioto", detalle.getPrecioTotal());
                jsona.put(jsono);
            });
            PGobject detalles = new PGobject();
            detalles.setType("json");
            detalles.setValue(jsona.toString());
            cmd.setLong(1, pCompra.getProveedor().getId());
            cmd.setBigDecimal(2, pCompra.getSubtotal());
            cmd.setBigDecimal(3, pCompra.getIva());
            cmd.setBigDecimal(4, pCompra.getTotal());
            cmd.setObject(5, detalles);
            cmd.setString(6, pCompra.getnFactura());
            cmd.setLong(7, pCompra.getEmpleado().getId());
            exito = cmd.execute();
        } catch(Exception ex){
            JOptionPane.showMessageDialog(
                    null, 
                    "No se han registrado los datos debido al error: \n" + ex.getMessage()
                            + "\nFavor contacte al desarrollador",
                    "Sistema de Compras y Ventas - Compra",
                    JOptionPane.ERROR_MESSAGE
            );
        } finally {
            conn.desconectar();
        }
        return exito;
    }
    
}
