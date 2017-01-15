/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import entidades.Inventario;
import modelo.Inventario_model;

/**
 *
 * @author darkpastiursSennin
 */
public class Inventario_controller {
    
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
