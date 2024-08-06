/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author G15br
 */
public class Empleado extends Persona {

    private cuentaEmpleado cuentaEmpleado;

    public Empleado(String nombre, String apellidos, cuentaEmpleado cuentaEmpleado) {
        super(nombre, apellidos); // Llamada al constructor de la clase Persona
        this.cuentaEmpleado = cuentaEmpleado;
    }

    public cuentaEmpleado getCuentaEmpleado() {
        return cuentaEmpleado;
    }

    public void setCuentaEmpleado(cuentaEmpleado cuentaEmpleado) {
        this.cuentaEmpleado = cuentaEmpleado;
    }
}
