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
import modelo.Cliente;
import modelo.Conexion;

/**
 *
 * @author chave
 */
public class ClienteDAO {

    Conexion conectar = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public int agregar(Cliente c) {
        String sql = "insert into Cliente(codigoCliente,nombre,apellidos,edad,direccion,genero,talla,peso) values(?,?,?,?,?,?,?,?)";
        try {
            con = conectar.obtenerConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, c.getCodigoCliente());
            ps.setString(2, c.getNombre());
            ps.setString(3, c.getApellidos());
            ps.setInt(4, c.getEdad());
            ps.setString(5, c.getDireccion());
            ps.setString(6, c.getGenero());
            ps.setDouble(7, c.getTalla());
            ps.setDouble(8, c.getPeso());
            ps.executeUpdate();
        } catch (Exception e) {

        }
        return 1;
    }

    public void eliminar(int codigoCliente) {
        String sql = "delete from Cliente where codigoCliente = ?";
        try {
            con = conectar.obtenerConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, codigoCliente);
            ps.executeUpdate();
        } catch (Exception e) {

        }
    }

    public int actualizarTipoMembresia(String tp, int c) {
        String tipoMembresia = tp;
        int codigoCliente = c;
        int r = 0;
        String sql = "UPDATE Cliente SET tipoMembresia = ? WHERE codigoCliente = ?";
        try {
            con = conectar.obtenerConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, tipoMembresia);
            ps.setInt(2, codigoCliente);
            r = ps.executeUpdate();
            if (r == 1) {
                return 1;
            } else {
                return 0;
            }
        } catch (Exception e) {

        }
        return r;
    }
    
    public int actualizar(Cliente c) {
        int r = 0;
        String sql = "update Cliente set nombre=?, apellidos=?, edad=?, direccion=?, genero=?, talla=?, peso=? where codigoCliente=?";
        try {
            con = conectar.obtenerConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getApellidos());
            ps.setInt(3, c.getEdad());
            ps.setString(4, c.getDireccion());
            ps.setString(5, c.getGenero());
            ps.setDouble(6, c.getTalla());
            ps.setDouble(7, c.getPeso());
            ps.setInt(8, c.getCodigoCliente());
            r = ps.executeUpdate();
            if (r == 1) {
                return 1;
            } else {
                return 0;
            }
        } catch (Exception e) {

        }
        return r;
    }

    public List listar() {
        List<Cliente> datos = new ArrayList<>();
        String sql = "select * from Cliente";
        try {
            con = conectar.obtenerConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setCodigoCliente(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setApellidos(rs.getString(3));
                c.setEdad(rs.getInt(4));
                c.setDireccion(rs.getString(5));
                c.setGenero(rs.getString(6));
                c.setTalla(rs.getDouble(7));
                c.setPeso(rs.getDouble(8));
                datos.add(c);
            }
        } catch (Exception e) {

        }
        return datos;
    }

    public String obtenerNomCliente(int codigoCliente) {
        String nombreCliente = null;
        String sql = "SELECT nombre FROM Cliente WHERE codigoCliente = ?";
        try {
            con = conectar.obtenerConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, codigoCliente);
            rs = ps.executeQuery();
            if (rs.next()) {
                nombreCliente = rs.getString("nombre");
            }
        } catch (Exception e) {
            e.printStackTrace(); // Manejo básico de excepciones (imprime el error)
        }
        return nombreCliente;
    }

}
