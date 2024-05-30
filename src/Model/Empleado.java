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

    public Empleado(String nombre,String apellidos, CuentaEmpleado cuentaEmpleado) {
        super(nombre,apellidos ,0, "", "", 0.0, 0.0); // Llamada al constructor de la clase Persona
        this.cuentaEmpleado = cuentaEmpleado;
    }

    public CuentaEmpleado getCuentaEmpleado() {
        return cuentaEmpleado;
    }

    public void setCuentaEmpleado(CuentaEmpleado cuentaEmpleado) {
        this.cuentaEmpleado = cuentaEmpleado;
    }

}
