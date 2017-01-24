/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import entidades.Inventario;
import java.util.Collections;
import java.util.List;
import modelo.Inventario_model;

/**
 *
 * @author darkpastiursSennin
 */
public class Inventario_controller {
    
    public List<Inventario> Obtener(){
        List<Inventario> listaDatos = new Inventario_model().obtenerInventarios();
        Collections.sort(listaDatos, (Inventario p1, Inventario p2) ->{
            return p1.getProducto().getNombre().compareTo(p2.getProducto().getNombre());
        });
        return listaDatos;
    }
    
    public boolean Registrar(Inventario pInventario){
        return new Inventario_model().Agregar(pInventario);
    }
    
    public boolean Editar(Inventario pInventario){
        return new Inventario_model().Actualizar(pInventario);
    }
    
    public boolean Borrar(Inventario pInventario){
        return new Inventario_model().Eliminar(pInventario);
    }
}
