/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author chave
 */
public class Empresa {
   private String nombreEmpresa;
   private String ruc;
   private ArrayList<Producto> listaProductos;
   private ArrayList<Cliente> listaClientes;
   private ArrayList<Empleado> listaEmpleados;

    public Empresa(String nombreEmpresa, String ruc) {
        this.nombreEmpresa = nombreEmpresa;
        this.ruc = ruc;
        this.listaProductos= new ArrayList<>();
        this.listaClientes= new ArrayList<>();
        this.listaEmpleados= new ArrayList<>();
    }
    
    
    public void agregarProducto(Producto producto){
        listaProductos.add(producto);
    }
    public void agregarCliente(Cliente cliente){
        listaClientes.add(cliente);
    }
    public void agregarEmpleado(Empleado empleado){
        listaEmpleados.add(empleado);       
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }
    
    public void mostrarDatos(){};
   
}
