/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

public class RegistroAsistencia {

    private String codigo;
    private String nombre;
    private String fecha;
    private String hora_entrada;

    public RegistroAsistencia() {

    }

    public RegistroAsistencia(String codigo, String nombre, String fecha, String hora_entrada) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.fecha = fecha;
        this.hora_entrada = hora_entrada;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora_entrada() {
        return hora_entrada;
    }

    public void setHora_entrada(String hora_entrada) {
        this.hora_entrada = hora_entrada;
    }
}
