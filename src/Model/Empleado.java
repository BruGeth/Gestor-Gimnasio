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

    private String idCliente;
    private String puesto;
    private Double salario;

    public Empleado(String nombre, int edad, String direccion, String genero, double talla, double peso, String idCliente, String puesto, Double salario) {
        super(nombre, edad, direccion, genero, talla, peso); // Llamada al constructor de la clase Persona
        this.idCliente = idCliente;
        this.puesto = puesto;
        this.salario = salario;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public void calcularSalario() {
        // Implementación del método para calcular el salario
    }

}
