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
import modelo.Boleta;
import modelo.Conexion;

/**
 *
 * @author G15br
 */
public class BoletaDAO {

    Conexion conectar = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    private static int numeroBoleta = 0;

    public List listar() {
        List<Boleta> datos = new ArrayList<>();
        String sql = "select * from Boleta";
        try {
            con = conectar.obtenerConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Boleta b = new Boleta();
                b.setNumeroBoleta(rs.getInt(1));
                b.setFecha(rs.getString(2));
                b.setDNICliente(rs.getInt(3));
                b.setTotal(rs.getDouble(4));
                datos.add(b);
            }
        } catch (Exception e) {

        }
        return datos;
    }

    public String obtenerFecha() {
        String fecha_actual = null; // Valor por defecto en caso de error o no encontrar el producto
        String sql = "SELECT CURDATE()";
        try {
            con = conectar.obtenerConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                fecha_actual = rs.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fecha_actual;
    }

    public int generarNumeroBoleta() {
        // Consulta el número de boleta más alto en la base de datos
        int numeroMaximo = 0;
        String sql = "SELECT MAX(numeroBoleta)FROM Boleta;";
        try {
            con = conectar.obtenerConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                String numeroBoletaStr = rs.getString(1);
                if (numeroBoletaStr != null) {
                    numeroMaximo = Integer.parseInt(numeroBoletaStr);
            }
            }
            // Si no hay registros, comienza desde 0001
            if (numeroMaximo == 0) {
                return 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Incrementa el número máximo en 1 para obtener un nuevo número de boleta
        return numeroMaximo + 1;
    }

    public int PrepararBoleta(Boleta b) {
        String sql = "insert into Boleta(numeroBoleta, fecha, total, codigoCliente) values(?,?,?,?)";
        try {
            con = conectar.obtenerConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, b.getNumeroBoleta());
            ps.setString(2, b.getFecha());
            ps.setDouble(3, b.getTotal());
            ps.setInt(4, b.getDNICliente());
            ps.executeUpdate();
        } catch (Exception e) {

        }
        return 1;
    }

    public int GenerarBoleta(Boleta b) {
        int r = 0;
        String sql = "update Boleta set numeroBoleta=?, fecha=?, total=? where codigoCliente=?";
        try {
            con = conectar.obtenerConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, b.getNumeroBoleta());
            ps.setString(2, b.getFecha());
            ps.setDouble(3, b.getTotal());
            ps.setInt(4, b.getDNICliente());
            ps.executeUpdate();
        } catch (Exception e) {
            if (r == 1) {
                return 1;
            } else {
                return 0;
            }
        }
        return 1;
    }

}
