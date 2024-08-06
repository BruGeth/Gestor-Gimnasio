/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author chave
 */
public class Producto {
    private int codigoProducto;
    private String nombreProducto;
    private int cantidad;
    private double precio;
    private String categoria;
    
    public Producto() {
    }

    public Producto(int codigoProducto, String nombreProducto , int cantidad, double precio, String categoria) {
        this.codigoProducto = codigoProducto;
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.categoria = categoria;
    }
    
    public int getCodigoProducto() {
        return codigoProducto;
    }
    
    public void setCodigoProducto(int codigoProducto) { 
        this.codigoProducto = codigoProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    //Controladores cambiar
    
    public void mostrarProducto(){};
    public void registrarProducto(){};
    public void actualizarProducto(){};
    public  void eliminarProducto(){};
    
          
    
}
