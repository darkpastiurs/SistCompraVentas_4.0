/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import entidades.Usuario;
import java.util.Collections;
import java.util.List;
import modelo.Usuario_model;

/**
 *
 * @author darkpastiursSennin
 */
public class Usuario_controller {
    
    public boolean login(Usuario pUsuario){
        return new Usuario_model().login(pUsuario);
    }
    
    public List<Usuario> Obtener(){
        List<Usuario> listaDatos = new Usuario_model().obtenerUsuarios();
        Collections.sort(listaDatos, (Usuario u1, Usuario u2) -> {
            return (u1.getEmpleado().getApellidoPaterno() + " "
                    + u1.getEmpleado().getApellidoMaterno() + " "
                    + u1.getEmpleado().getNombre()).compareTo(u2.getEmpleado().getApellidoPaterno() + " "
                            + u2.getEmpleado().getApellidoMaterno() + " "
                            + u2.getEmpleado().getNombre());
        });
        return listaDatos;
    }
    
    public Usuario Obtener(Usuario pUsuario){
        return new Usuario_model().obtenerUsuario(pUsuario);
    }
}
