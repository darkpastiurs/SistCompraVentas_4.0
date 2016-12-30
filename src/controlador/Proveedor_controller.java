/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import entidades.Proveedor;
import java.util.Collections;
import java.util.List;
import modelo.Proveedor_model;

/**
 *
 * @author darkpastiursSennin
 */
public class Proveedor_controller {
    
    public List<Proveedor> Obtener(){
        List<Proveedor> listaDatos = new Proveedor_model().obtenerProveedores();
        Collections.sort(listaDatos, (Proveedor p1, Proveedor p2)->{
            return p1.getNombre().compareTo(p2.getNombre());
        });
        return listaDatos;
    }
    
    public Proveedor Obtener(Proveedor pProveedor){
        return new Proveedor_model().obtenerProveedor(pProveedor);
    }
    
    public boolean Registrar(Proveedor pProveedor){
        return new Proveedor_model().Agregar(pProveedor);
    }
    
    public boolean Editar(Proveedor pProveedor){
        return new Proveedor_model().Actualizar(pProveedor);
    }
    
    public boolean Borrar(Proveedor pProveedor){
        return new Proveedor_model().Eliminar(pProveedor);
    }
    
}
