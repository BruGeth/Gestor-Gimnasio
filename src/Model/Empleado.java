/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author G15br
 */
public class Empleado extends Persona {

    private CuentaEmpleado cuentaEmpleado;

    public Empleado(String nombre, int edad, String direccion, String genero, double talla, double peso,CuentaEmpleado cuentaEmpleado) {
        super(nombre, edad, direccion, genero, talla, peso); // Llamada al constructor de la clase Persona
        this.cuentaEmpleado = cuentaEmpleado;
    }    

    public CuentaEmpleado getCuentaEmpleado() {
        return cuentaEmpleado;
    }

    public void setCuentaEmpleado(CuentaEmpleado cuentaEmpleado) {
        this.cuentaEmpleado = cuentaEmpleado;
    }
       
    
   
}
