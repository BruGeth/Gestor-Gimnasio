/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author G15br
 */
public class detallesBoleta {

    private int idDetalle;
    private int numeroBoleta;
    private int CodigoProducto;
    private String NombreProducto;
    private int cantidad;
    private double precioUnitario;
    private double subtotal;

    public detallesBoleta() {
    }

    public detallesBoleta(int idDetalle, int CodigoProducto, String NombreProducto, int cantidad, double precioUnitario, double subtotal) {
        this.idDetalle = idDetalle;
        this.CodigoProducto = CodigoProducto;
        this.NombreProducto = NombreProducto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.subtotal = subtotal;
    }

    public detallesBoleta(int idDetalle, int numeroBoleta, int CodigoProducto, int cantidad, double precioUnitario, double subtotal) {
        this.idDetalle = idDetalle;
        this.numeroBoleta = numeroBoleta;
        this.CodigoProducto = CodigoProducto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.subtotal = subtotal;
    }

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public int getNumeroBoleta() {
        return numeroBoleta;
    }

    public void setNumeroBoleta(int numeroBoleta) {
        this.numeroBoleta = numeroBoleta;
    }

    public int getCodigoProducto() {
        return CodigoProducto;
    }

    public void setCodigoProducto(int CodigoProducto) {
        this.CodigoProducto = CodigoProducto;
    }

    public String getNombreProducto() {
        return NombreProducto;
    }

    public void setNombreProducto(String NombreProducto) {
        this.NombreProducto = NombreProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
}
