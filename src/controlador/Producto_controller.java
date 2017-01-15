/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import entidades.Producto;
import java.util.Collections;
import java.util.List;
import modelo.Producto_model;

/**
 *
 * @author darkpastiursSennin
 */
public class Producto_controller {
    
//    public List<Producto> Obtener(){
//        List<Producto> listaDatos = new Producto_model().obtenerProductos();
//        Collections.sort(listaDatos, (Producto p1, Producto p2) ->{
//            return p1.getNombre().compareTo(p2.getNombre());
//        });
//        return listaDatos;
//    }
    
    public Producto Obtener(Producto pProducto){
        return new Producto_model().obtenerProducto(pProducto);
    }
    
//    public boolean Registrar(Producto pProducto){
//        return new Producto_model().Agregar(pProducto);
//    }
//    
//    public boolean Editar(Producto pProducto){
//        return new Producto_model().Actualizar(pProducto);
//    }
//    
//    public boolean Borrar(Producto pProducto){
//        return new Producto_model().Eliminar(pProducto);
//    }
    
}
