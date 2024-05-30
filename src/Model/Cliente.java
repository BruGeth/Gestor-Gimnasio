
package Model;

public class Cliente extends Persona{
    private CuentaCliente cuentaCliente;

    public Cliente(String nombre, int edad, String direccion, String genero, double talla, double peso,CuentaCliente cuentaCliente) {
        super(nombre, edad, direccion, genero, talla, peso);
        this.cuentaCliente = cuentaCliente;
    }

    public CuentaCliente getCuentaCliente() {
        return cuentaCliente;
    }

    public void setCuentaCliente(CuentaCliente cuentaCliente) {
        this.cuentaCliente = cuentaCliente;
    }

    
    
    
}
