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
public class Proveedor {
    
    private long _id;
    private String _nombre;
    private String _nit;
    private String _nrc;
    private String _direccion;
    private String _telefono;
    private String _email;
    private String _website;
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

    public String getNIT() {
        return _nit;
    }

    public void setNIT(String _nit) {
        this._nit = _nit;
    }

    public String getNRC(boolean zero) {
        if(zero){
            return _nrc;
        } else {            
            return _nrc.replace("0", "");
        }
    }

    public void setNRC(String _nrc) {
        int zero = 8 - _nrc.length();
        if(_nrc.length() < 8){
            for (int i = 0; i < zero; i++) {
                _nrc = "0" + _nrc;
            }
        }
        this._nrc = _nrc;
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

    public String getWebsite() {
        return _website;
    }

    public void setWebsite(String _website) {
        this._website = _website;
    }

    public boolean isEstado() {
        return _estado;
    }

    public void setEstado(boolean _estado) {
        this._estado = _estado;
    }
    
    public Proveedor() {
    }

    public Proveedor(long _id) {
        this._id = _id;
    }

    @Override
    public String toString() {
        return _nombre;
    }
    
    
    
}
