/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import entidades.Empleado;
import entidades.Nivel;
import entidades.Usuario;
import java.util.Collections;
import java.util.List;
import modelo.Empleado_model;

/**
 *
 * @author darkpastiursSennin
 */
public class Empleado_controller {
    
    public List<Empleado> Obtener(){
        List<Empleado> listaDatos = new Empleado_model().obtenerEmpleados();
        Collections.sort(listaDatos, (Empleado e1, Empleado e2) -> {
            return (e1.getApellidoPaterno() + " "
                    + e1.getApellidoMaterno() + " "
                    + e1.getNombre()).trim().compareTo((e2.getApellidoPaterno() + " "
                            + e2.getApellidoMaterno() + " "
                            + e2.getNombre()).trim());
        });
        return listaDatos;
    }
    
    public Empleado Obtener(Empleado pEmpleado){
        return new Empleado_model().obtenerEmpleado(pEmpleado);
    }
    
    public boolean Registrar(Empleado pEmpleado, Usuario pUsuario, Nivel pNivel){
        return new Empleado_model().Agregar(pEmpleado, pUsuario, pNivel);
    }
    
    public boolean Editar(Empleado pEmpleado, Usuario pUsuario, Nivel pNivel){
        return new Empleado_model().Actualizar(pEmpleado, pUsuario, pNivel);
    }
    
    public boolean Borrar(Empleado pEmpleado){
        return new Empleado_model().Eliminar(pEmpleado);
    }
}
