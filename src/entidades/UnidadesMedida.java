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
public class UnidadesMedida {
    long _id;
    String _nombre;
    UnidadesMedida _convertir;
    double _equivalencia;
    boolean estado;

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

    public UnidadesMedida getConvertir() {
        return _convertir;
    }

    public void setConvertir(UnidadesMedida _convertir) {
        this._convertir = _convertir;
    }

    public double getEquivalencia() {
        return _equivalencia;
    }

    public void setEquivalencia(double _equivalencia) {
        this._equivalencia = _equivalencia;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public UnidadesMedida() {
    }

    public UnidadesMedida(long _id) {
        this._id = _id;
    }

    @Override
    public String toString() {
        return _nombre;
    }
    
    
    
}
