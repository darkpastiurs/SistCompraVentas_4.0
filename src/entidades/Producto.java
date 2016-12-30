/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.sql.Date;

/**
 *
 * @author darkpastiursSennin
 */
public class Producto {
    long _id;
    String _nombre;
    Date _fechaRegistro;
    String _descripcion;
    Categoria _categoria;
    Marca _marca;
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

    public Date getFechaRegistro() {
        return _fechaRegistro;
    }

    public void setFechaRegistro(java.util.Date _fechaRegistro) {
        this._fechaRegistro = new Date(_fechaRegistro.getTime());
    }

    public String getDescripcion() {
        return _descripcion;
    }

    public void setDescripcion(String _descripcion) {
        this._descripcion = _descripcion;
    }

    public Categoria getCategoria() {
        return _categoria;
    }

    public void setCategoria(Categoria _categoria) {
        this._categoria = _categoria;
    }

    public Marca getMarca() {
        return _marca;
    }

    public void setMarca(Marca _marca) {
        this._marca = _marca;
    }

    public boolean isEstado() {
        return _estado;
    }

    public void setEstado(boolean _estado) {
        this._estado = _estado;
    }

    public Producto() {
    }

    public Producto(long _id) {
        this._id = _id;
    }

    @Override
    public String toString() {
        return _nombre;
    }
        
}
