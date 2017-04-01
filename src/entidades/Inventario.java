/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.math.BigDecimal;

/**
 *
 * @author darkpastiursSennin
 */
public class Inventario {
    private long _id;
    private BigDecimal _stock;
    private BigDecimal _precio;
    private Producto _producto;
    private boolean _estado;

    public long getId() {
        return _id;
    }

    public void setId(long _id) {
        this._id = _id;
    }

    public BigDecimal getStock() {
        return _stock;
    }

    public void setStock(BigDecimal _stock) {
        this._stock = _stock.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public BigDecimal getPrecio() {
        return _precio;
    }

    public void setPrecio(BigDecimal _precio) {
        this._precio = _precio.setScale(2, BigDecimal.ROUND_HALF_UP);
    }
    
    public Producto getProducto() {
        return _producto;
    }

    public void setProducto(Producto _producto) {
        this._producto = _producto;
    }

    public boolean isEstado() {
        return _estado;
    }

    public void setEstado(boolean _estado) {
        this._estado = _estado;
    }
    
    public Inventario() {
    }

    public Inventario(long _id) {
        this._id = _id;
    }

    @Override
    public String toString() {
        return this._producto.getNombre();
    }
}
