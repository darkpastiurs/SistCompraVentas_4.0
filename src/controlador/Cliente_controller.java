/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import entidades.Cliente;
import java.util.Collections;
import java.util.List;
import modelo.Cliente_model;

/**
 *
 * @author darkpastiursSennin
 */
public class Cliente_controller {
    
    public List<Cliente> Obtener(){
        List<Cliente> listaDatos = new Cliente_model().obtenerClientes();
        Collections.sort(listaDatos, (Cliente c1, Cliente c2) -> {
            return (c1.getApellidoPaterno() + " " + 
                    c1.getApellidoMaterno() + " " +
                    c1.getNombre()).compareTo(c2.getApellidoPaterno() + " " + 
                                                c2.getApellidoMaterno()+ " " + 
                                                c2.getNombre());
        });
        return listaDatos;
    }
    
    public Cliente Obtener(Cliente pCliente){
        return new Cliente_model().obtenerCliente(pCliente);
    }
    
    public boolean Registrar(Cliente pCliente){
        return new Cliente_model().Agregar(pCliente);
    }
    
    public boolean Editar(Cliente pCliente){
        return new Cliente_model().Actualizar(pCliente);
    }
    
    public boolean Borrar(Cliente pCliente){
        return new Cliente_model().Eliminar(pCliente);
    }
}
