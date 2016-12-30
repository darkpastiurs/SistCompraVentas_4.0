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
public class Categoria {
    long _id;
    String _nombre;
    boolean _estado;

    public long getId() {
        return _id;
    }

    public void setId(long _id) {
        this._id = _id;
    }

    public String getNombre() {
        return _nombre;
    }

    public void setNombre(String _nombre) {
        this._nombre = _nombre;
    }   

    public Categoria(long _id) {
        this._id = _id;
    }

    public boolean isEstado() {
        return _estado;
    }

    public void setEstado(boolean _estado) {
        this._estado = _estado;
    }
    public Categoria() {
    }

    @Override
    public String toString() {
        return _nombre;
    }    
}
