/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Conexion;
import modelo.RegistroAsistencia;

public class RegistroAsistenciaDAO {

    Conexion conectar = new Conexion();
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List Listar() {
        List<RegistroAsistencia> datos = new ArrayList<>();
        String sql = "SELECT c.codigoCliente, c.nombre, a.fecha, a.hora_entrada FROM Cliente c INNER JOIN Asistencia a ON c.codigoCliente = a.codigoCliente;";
        try {
            con = conectar.obtenerConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                RegistroAsistencia ra = new RegistroAsistencia();
                ra.setCodigo(rs.getString(1));
                ra.setNombre(rs.getString(2));
                ra.setFecha(rs.getString(3));
                ra.setHora_entrada(rs.getString(4));
                datos.add(ra);
            }
        } catch (Exception e) {

        }
        return datos;
    }
}
