package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Conexion;
import modelo.Producto;

/**
 *
 * @author chave
 */
public class ProductoDAO {

    Conexion conectar = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public int agregar(Producto p) {
        String sql = "INSERT INTO Producto (codigoProducto, nombreProducto, cantidad, precio, categoria) VALUES (?, ?, ?, ?, ?)";
        try {
            con = conectar.obtenerConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, p.getCodigoProducto());
            ps.setString(2, p.getNombreProducto());
            ps.setInt(3, p.getCantidad());
            ps.setDouble(4, p.getPrecio());
            ps.setString(5, p.getCategoria());
            ps.executeUpdate();
        } catch (Exception e) {

        }
        return 1;
    }

    public void eliminar(int codigoProducto) {
        String sql = "DELETE FROM Producto WHERE codigoProducto = ?";
        try {
            con = conectar.obtenerConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, codigoProducto);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int actualizar(Producto p) {
        int r = 0;
        String sql = "UPDATE Producto SET nombreProducto=?, cantidad=?, precio=?, categoria=? WHERE codigoProducto=?";
        try {
            con = conectar.obtenerConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getNombreProducto());
            ps.setInt(2, p.getCantidad());
            ps.setDouble(3, p.getPrecio());
            ps.setString(4, p.getCategoria());
            ps.setInt(5, p.getCodigoProducto());
            r = ps.executeUpdate();
            if (r == 1) {
                return 1;
            } else {
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }

    public String obtenerNomProducto(int codigoProducto) {
        String nombreProducto = null;
        String sql = "SELECT nombreProducto FROM Producto WHERE codigoProducto = ?";
        try {
            con = conectar.obtenerConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, codigoProducto);
            rs = ps.executeQuery();
            if (rs.next()) {
                nombreProducto = rs.getString("nombreProducto");
            }
        } catch (Exception e) {
            e.printStackTrace(); // Manejo básico de excepciones (imprime el error)
        }
        return nombreProducto;
    }

    public int obtenerStockProducto(int codigoProducto) {
        int stockProducto = -1; // Valor por defecto en caso de error o no encontrar el producto
        String sql = "SELECT cantidad FROM Producto WHERE codigoProducto = ?";
        try {
            con = conectar.obtenerConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, codigoProducto);
            rs = ps.executeQuery();
            if (rs.next()) {
                stockProducto = rs.getInt("cantidad");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stockProducto;
    }

    public int actualizarStock(int codigoProducto, int cantidadCambio) {
        String sql = "UPDATE Producto SET cantidad = cantidad + ? WHERE codigoProducto = ?";
        try {
            con = conectar.obtenerConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cantidadCambio);
            ps.setInt(2, codigoProducto);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public double obtenerPrecioProducto(int codigoProducto) {
        double precioProducto = -1.0; // Valor por defecto en caso de error o no encontrar el producto
        String sql = "SELECT precio FROM Producto WHERE codigoProducto = ?";
        try {
            con = conectar.obtenerConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, codigoProducto);
            rs = ps.executeQuery();
            if (rs.next()) {
                precioProducto = rs.getDouble("precio");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return precioProducto;
    }

    public List listar() {
        List<Producto> datos = new ArrayList<>();
        String sql = "select * from Producto";
        try {
            con = conectar.obtenerConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto p = new Producto();
                p.setCodigoProducto(rs.getInt(1));
                p.setNombreProducto(rs.getString(2));
                p.setCantidad(rs.getInt(3));
                p.setPrecio(rs.getDouble(4));
                p.setCategoria(rs.getString(5));
                datos.add(p);
            }
        } catch (Exception e) {

        }
        return datos;
    }

    public int registrarVenta(Producto p) {
        String sql = "insert into Boleta(numeroBoleta,fecha,total,codigoCliente) values(?,?,?,?)";
        try {
            con = conectar.obtenerConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, p.getCodigoProducto());
            ps.setString(2, p.getNombreProducto());
            ps.setInt(3, p.getCantidad());
            ps.setDouble(4, p.getPrecio());
            ps.setString(5, p.getCategoria());
        } catch (Exception e) {

        }
        return 1;
    }

}
