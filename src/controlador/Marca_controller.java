/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import entidades.Marca;
import java.util.Collections;
import java.util.List;
import modelo.Marca_model;

/**
 *
 * @author darkpastiursSennin
 */
public class Marca_controller {
    
    public List<Marca> Obtener(){
        List<Marca> listaDatos = new Marca_model().obtenerMarcas();
        Collections.sort(listaDatos, (Marca m1, Marca m2) -> {
            return m1.getNombre().compareTo(m2.getNombre());
        });
        return listaDatos;
    }
    
    public Marca Obtener(Marca pMarca){
        return new Marca_model().obtenerMarca(pMarca);
    }
    
    public boolean Registrar(Marca pMarca){
        return new Marca_model().Agregar(pMarca);
    }
    
    public boolean Editar(Marca pMarca){
        return new Marca_model().Actualizar(pMarca);
    }
    
    public boolean Quitar(Marca pMarca){
        return new Marca_model().Eliminar(pMarca);
    }
}
