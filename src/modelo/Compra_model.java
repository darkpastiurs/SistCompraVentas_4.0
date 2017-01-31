/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import entidades.Compra;
import entidades.DetalleCompra;
import entidades.Empleado;
import entidades.Inventario;
import entidades.Proveedor;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.json.JSONArray;
import org.json.JSONObject;
import org.postgresql.util.PGobject;

/**
 *
 * @author darkpastiursSennin
 */
public class Compra_model {
    
    public List<Compra> obtenerCompras(){
        List<Compra> compras = new ArrayList<>();
        Conexion conn = new Conexion();
        try{
            conn.conectar();
            CallableStatement cmd = conn.getConexion().prepareCall("{ call obtenercompras() }");
            if(cmd.execute()){
                ResultSet lector = cmd.getResultSet();
                while(lector.next()){
                    Compra compra = new Compra();
                    compra.setId(lector.getLong(1));
                    compra.setFecha(lector.getTimestamp(2));
                    compra.setSubtotal(lector.getBigDecimal(3));
                    compra.setIva(lector.getBigDecimal(4));
                    compra.setTotal(lector.getBigDecimal(5));
                    compra.setProveedor(new Proveedor_model().obtenerProveedor(new Proveedor(lector.getLong(6))));
                    compra.setnFactura(lector.getString(7));
                    compra.setEmpleado(new Empleado_model().obtenerEmpleado(new Empleado(lector.getLong(8))));
                    compra.setDetalleCompra(new DetalleCompra_model().Obtener(compra));
                    compras.add(compra);
                }
            }
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
        return compras;
    }
    
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
