/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import entidades.Categoria;
import java.util.Collections;
import java.util.List;
import modelo.Categoria_model;

/**
 *
 * @author darkpastiursSennin
 */
public class Categoria_controller {
    
    public List<Categoria> Obtener(){
        List<Categoria> listaDatos = new Categoria_model().obtenerCategorias();
        Collections.sort(listaDatos, (Categoria c1, Categoria c2) -> {
            return c1.getNombre().compareTo(c2.getNombre());
        });
        return listaDatos;
    }
    
    public Categoria Obtener(Categoria pCategoria){
        return new Categoria_model().obtenerCategoria(pCategoria);
    }
    
    public boolean Registrar(Categoria pCategoria){
        return new Categoria_model().Agregar(pCategoria);
    }
    
    public boolean Editar(Categoria pCategoria){
        return new Categoria_model().Actualizar(pCategoria);
    }
    
    public boolean Borrar(Categoria pCategoria){
        return new Categoria_model().Eliminar(pCategoria);
    }
}
