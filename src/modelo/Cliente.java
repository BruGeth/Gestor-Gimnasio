package modelo;

public class Cliente extends Persona {
    
    private int codigoCliente;
    private String tipoMenbresia;
    
    public Cliente() {
        
    }

    public Cliente(int codigoCliente, String tipoMenbresia, String nombre, String apellidos, int edad, String direccion, String genero, double talla, double peso) {
        super(nombre, apellidos, edad, direccion, genero, talla, peso);
        this.codigoCliente = codigoCliente;
        this.tipoMenbresia= tipoMenbresia;
    }
    
    public String getTipoMenbresia(){
        return tipoMenbresia;
    }
    
    public void setTipoMenbresia(String tipoMenbresia){
        this.tipoMenbresia = tipoMenbresia;
    }
    public int getCodigoCliente(){
        return codigoCliente;
    }
    
    public void setCodigoCliente(int codigoCliente){
        this.codigoCliente = codigoCliente;
    }
 
}
