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
public class Empleado {
    private long _id;
    private String _nombre;
    private String _apellidoPaterno;
    private String _apellidoMaterno;
    private String _dui;
    private String _nit;
    private Date _fechaNacimiento;
    private String _genero;
    private String _direccion;
    private String _telefono;
    private String _email;
    private boolean _estado;
    

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

    public String getApellidoPaterno() {
        return _apellidoPaterno;
    }

    public void setApellidoPaterno(String _apellidoPaterno) {
        this._apellidoPaterno = _apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return _apellidoMaterno;
    }

    public void setApellidoMaterno(String _apellidoMaterno) {
        this._apellidoMaterno = _apellidoMaterno;
    }

    public String getDUI() {
        return _dui;
    }

    public void setDUI(String _dui) {
        this._dui = _dui;
    }

    public String getNIT() {
        return _nit;
    }

    public void setNIT(String _nit) {
        this._nit = _nit;
    }

    public Date getFechaNacimiento() {
        return _fechaNacimiento;
    }

    public void setFechaNacimiento(java.util.Date _fechaNacimiento) {
        this._fechaNacimiento = new java.sql.Date(_fechaNacimiento.getTime());
    }

    public String getGenero() {
        return _genero;
    }

    public void setGenero(String _genero) {
        this._genero = _genero;
    }

    public String getDireccion() {
        return _direccion;
    }

    public void setDireccion(String _direccion) {
        this._direccion = _direccion;
    }

    public String getTelefono() {
        return _telefono;
    }

    public void setTelefono(String _telefono) {
        this._telefono = _telefono;
    }

    public String getEmail() {
        return _email;
    }

    public void setEmail(String _email) {
        this._email = _email;
    }

    public Empleado() {
    }

    public boolean isEstado() {
        return _estado;
    }

    public void setEstado(boolean _estado) {
        this._estado = _estado;
    }
    
    public Empleado(long _id) {
        this._id = _id;
    }
    
    @Override
    public String toString() {
        return _nombre + " " + _apellidoPaterno + " " + _apellidoMaterno;
    }
}
