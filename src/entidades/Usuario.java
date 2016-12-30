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
public class Usuario {
    private String _nickname;
    private String _contrasena;
    private boolean _estado;
    private Empleado _empleado;
    private Nivel _nivel;
    
    public String getNickname() {
        return _nickname;
    }

    public void setNickname(String nickname) {
        this._nickname = nickname;
    }

    public String getContrasena() {
        return _contrasena;
    }

    public void setContrasena(String contrasena) {
        this._contrasena = contrasena;
    }

    public boolean isEstado() {
        return _estado;
    }

    public void setEstado(boolean estado) {
        this._estado = estado;
    }

    public Empleado getEmpleado() {
        return _empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this._empleado = empleado;
    }

    public Nivel getNivel() {
        return _nivel;
    }

    public void setNivel(Nivel _nivel) {
        this._nivel = _nivel;
    }

    public Usuario() {
    }

    public Usuario(String pNickname, String pContrasena, boolean pEstado, Empleado pEmpleado) {
        this._nickname = pNickname;
        this._contrasena = pContrasena;
        this._estado = pEstado;
        this._empleado = pEmpleado;
    }

    public Usuario(String _nickname, String _contrasena) {
        this._nickname = _nickname;
        this._contrasena = _contrasena;
    }

    public Usuario(String pNickname) {
        this._nickname = pNickname;
    }

    @Override
    public String toString() {
        return _nickname;
    }
    
    
}
