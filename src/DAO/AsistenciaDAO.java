/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import modelo.Conexion;

public class AsistenciaDAO {

    Conexion conectar = new Conexion();
    Connection con;
    PreparedStatement ps;

    public int registrarAsistencia(int codCliente) {
        int i = 1;
        try {
            con = conectar.obtenerConexion();
            ps = con.prepareStatement("INSERT INTO Asistencia (codigoCliente, fecha, hora_entrada) VALUES (?, CURDATE(),CURTIME())");
            ps.setInt(1, codCliente);
            ps.executeUpdate();
        } catch (Exception e) {

        }
        return i;
    }
}
