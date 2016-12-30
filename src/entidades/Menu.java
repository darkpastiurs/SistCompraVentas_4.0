/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author darkpastiursSennin
 */
public class Menu {
    private long _id;
    private String _nombre;
    private boolean _permiso;

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        this._id = id;
    }

    public String getNombre() {
        return _nombre;
    }

    public void setNombre(String nombre) {
        this._nombre = nombre;
    }

    public boolean isPermiso() {
        return _permiso;
    }

    public void setPermiso(boolean permiso) {
        this._permiso = permiso;
    }
    
    

    public Menu(){
        
    }
    
    public Menu(long pId, String pNombre, boolean pPermiso) {
        this._id = pId;
        this._nombre = pNombre;
        this._permiso = pPermiso;
    }
    
    
    
}
