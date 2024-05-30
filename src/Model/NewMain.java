/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Model;

/**
 *
 * @author G15br
 */
public class NewMain {

    public static void main(String[] args) {
        CuentaEmpleado cuenta1 = new CuentaEmpleado("12321", "123");
        CuentaEmpleado cuenta2 = new CuentaEmpleado("12321", "123");
        Empleado e1 = new Empleado("Oliver","", cuenta1);
        Empleado e2 = new Empleado("Sam","", cuenta2);
        CuentaCliente Cuenta3 = new CuentaCliente("acbs", "12312");
        Cliente cl1 = new Cliente("Oliver","Padilla", 23, "Lima", "Masculino", 1.74, 70.0, Cuenta3);
        Empresa GoldsGyms = new Empresa("GoldsGyms","1223214214");
        GoldsGyms.agregarCliente(cl1);
        Producto Proteina = new Producto("Proteina",12,12.50,1);
        GoldsGyms.agregarProducto(Proteina);
        
        System.out.println(GoldsGyms.getListaProductos().get(0).getNombre());

        System.out.println("Nombre: " + cl1.getNombre() + "\nUsuario de Empleado: " + Cuenta3.getTipoMembresia());
    }

}
