
package Model;

public class Cliente {

    private String nombre, direccion, genero, membresia;
    private int codigo, edad;
    private double peso, talla;

    //Constructor
    public Cliente(String nombre, String direccion, String genero, String membresia, int edad, double peso, double talla) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.genero = genero;
        this.membresia = membresia;
        this.codigo = codigo;
        this.edad = edad;
        this.peso = peso;
        this.talla = talla;
    }

    //Getter y Setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getMembresia() {
        return membresia;
    }

    public void setMembresia(String membresia) {
        this.membresia = membresia;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getTalla() {
        return talla;
    }

    public void setTalla(double talla) {
        this.talla = talla;
    }

}
