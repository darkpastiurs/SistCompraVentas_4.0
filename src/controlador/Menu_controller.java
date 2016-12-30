/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import entidades.Menu;
import entidades.Nivel;
import java.util.Collections;
import java.util.List;
import modelo.Menu_model;

/**
 *
 * @author darkpastiursSennin
 */
public class Menu_controller {
    
    public List<Menu> Obtener(Nivel pNivel){
        List<Menu> listaDatos = new Menu_model().obtenerMenus(pNivel);
        Collections.sort(listaDatos, (Menu m1, Menu m2) -> {
            return Long.compare(m1.getId(), m2.getId());
        }); 
        return listaDatos;
    }
    
    public List<Menu> Obtener(){
        return new Menu_model().obtenerMenusnoNivel();
    }
    
    public boolean Registrar(Menu pMenu, Nivel pNivel){
        return new Menu_model().Agregar(pMenu, pNivel);
    }
    
    public boolean Editar(Menu pMenu, Nivel pNivel){
        return new Menu_model().editarPermisos(pMenu, pNivel);
    }
}
