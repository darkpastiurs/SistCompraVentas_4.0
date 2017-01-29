/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author darkpastiursSennin
 */
public class Compra {
    
    private long _id;
    private java.sql.Date _fecha;
    private BigDecimal _subtotal;
    private BigDecimal _iva;
    private BigDecimal _total;
    private Proveedor _proveedor;
    private List<DetalleCompra> _detalleCompra;
    private String _nFactura;
    private Empleado _empleado;

    public long getId() {
        return _id;
    }

    public void setId(long _id) {
        this._id = _id;
    }

    public java.sql.Date getFecha() {
        return _fecha;
    }

    public void setFecha(java.util.Date _fecha) {
        this._fecha = new java.sql.Date(_fecha.getTime());
    }

    public BigDecimal getSubtotal() {
        return _subtotal;
    }

    public void setSubtotal(BigDecimal _subtotal) {
        this._subtotal = _subtotal.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public BigDecimal getIva() {
        return _iva;
    }

    public void setIva(BigDecimal _iva) {
        this._iva = _iva.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public BigDecimal getTotal() {
        return _total;
    }

    public void setTotal(BigDecimal _total) {
        this._total = _total.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public Proveedor getProveedor() {
        return _proveedor;
    }

    public void setProveedor(Proveedor _proveedor) {
        this._proveedor = _proveedor;
    }

    public List<DetalleCompra> getDetalleCompra() {
        return _detalleCompra;
    }

    public void setDetalleCompra(List<DetalleCompra> _detalleCompra) {
        this._detalleCompra = _detalleCompra;
    }

    public String getnFactura() {
        return _nFactura;
    }

    public void setnFactura(String _nFactura) {
        this._nFactura = _nFactura;
    }

    public Empleado getEmpleado() {
        return _empleado;
    }

    public void setEmpleado(Empleado _empleado) {
        this._empleado = _empleado;
    }
    
    public Compra() {
    }

    public Compra(long _id) {
        this._id = _id;
    }    
}
