/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import entidades.Nivel;
import java.util.Collections;
import java.util.List;
import modelo.Nivel_model;

/**
 *
 * @author darkpastiursSennin
 */
public class Nivel_controller {
    
    public List<Nivel> Obtener(boolean menus){
        List<Nivel> listaDatos = new Nivel_model().obtenerNiveles(menus);
        Collections.sort(listaDatos, (Nivel n1, Nivel n2) -> {
            return Long.compare(n1.getId(), n2.getId());
        });
        return listaDatos;
    }
    
    public Nivel Obtener(Nivel pNivel, boolean menu){
        return new Nivel_model().obtenerNivel(pNivel, menu);
    }
    
    public boolean Registrar(Nivel pNivel){
        return new Nivel_model().Agregar(pNivel);
    }
    
    public boolean Editar(Nivel pNivel){
        return new Nivel_model().Actualizar(pNivel);
    }
    
    public boolean Borrar(Nivel pNivel){
        return new Nivel_model().Eliminar(pNivel);
    }
}
