/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import entidades.Compra;
import java.util.Collections;
import java.util.List;
import modelo.Compra_model;

/**
 *
 * @author darkpastiursSennin
 */
public class Compra_controller {
    
    public List<Compra> Obtener(){
        List<Compra> listaDatos = new Compra_model().obtenerCompras();
        Collections.sort(listaDatos, (Compra c1, Compra c2) -> {
            return c2.getFecha().compareTo(c1.getFecha());
        });
        return listaDatos;
    }
    
    public boolean Registrar(Compra pCompra){
        return new Compra_model().Agregar(pCompra);
    }
    
}
