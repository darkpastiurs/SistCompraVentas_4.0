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
public class Inventario {
    long _id;
    double _stock;
    double _precioCompra;
    double _precioVenta;
    Producto _producto;
    UnidadesMedida _unidad;

    public long getId() {
        return _id;
    }

    public void setId(long _id) {
        this._id = _id;
    }

    public double getStock() {
        return _stock;
    }

    public void setStock(double _stock) {
        this._stock = _stock;
    }

    public double getPrecioCompra() {
        return _precioCompra;
    }

    public void setPrecioCompra(double _precioCompra) {
        this._precioCompra = _precioCompra;
    }

    public double getPrecioVenta() {
        return _precioVenta;
    }

    public void setPrecioVenta(double _precioVenta) {
        this._precioVenta = _precioVenta;
    }

    public Producto getProducto() {
        return _producto;
    }

    public void setProducto(Producto _producto) {
        this._producto = _producto;
    }

    public UnidadesMedida getUnidad() {
        return _unidad;
    }

    public void setUnidad(UnidadesMedida _unidad) {
        this._unidad = _unidad;
    }

    public Inventario() {
    }

    public Inventario(long _id) {
        this._id = _id;
    }
    
    
    
}
