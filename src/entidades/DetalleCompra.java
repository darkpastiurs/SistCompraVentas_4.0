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
public class DetalleCompra {
    private Inventario _inventario;
    private BigDecimal _cantidad;
    private BigDecimal _precioUnitario;
    private BigDecimal _precioTotal;

    public Inventario getInventario() {
        return _inventario;
    }

    public void setInventario(Inventario _inventario) {
        this._inventario = _inventario;
    }

    public BigDecimal getCantidad() {
        return _cantidad;
    }

    public void setCantidad(BigDecimal _cantidad) {
        this._cantidad = _cantidad.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public BigDecimal getPrecioUnitario() {
        return _precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal _precioUnitario) {
        this._precioUnitario = _precioUnitario.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public BigDecimal getPrecioTotal() {
        return _precioTotal;
    }

    public void setPrecioTotal(BigDecimal _precioTotal) {
        this._precioTotal = _precioTotal.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public DetalleCompra() {
    }
    
    
    
}
