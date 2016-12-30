/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.List;

/**
 *
 * @author darkpastiursSennin
 */
public class Nivel {
    
    private long _id;
    private String _nombre;
    private boolean _estado;
    private List<Menu> _menus;

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

    public boolean isEstado() {
        return _estado;
    }

    public void setEstado(boolean _estado) {
        this._estado = _estado;
    }
    
    public List<Menu> getMenus() {
        return _menus;
    }

    public void setMenus(List<Menu> menus) {
        this._menus = menus;
    }
    
    public Nivel(){
        
    }

    public Nivel(long pId) {
        this._id = pId;
    }

    
    
    public Nivel(long pId, String pNombre, boolean pEstado, List<Menu> pMenus) {
        this._id = pId;
        this._nombre = pNombre;
        this._estado = pEstado;
        this._menus = pMenus;
    }

    @Override
    public String toString() {
        return _nombre;
    }    
}
