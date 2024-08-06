package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Conexion;
import modelo.detallesBoleta;

/**
 *
 * @author G15br
 */
public class detallesBoletaDAO {

    Conexion conectar = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public int añadirCarrito(detallesBoleta db) {
        String sql = "insert into detalleBoleta(numeroBoleta, codigoProducto, cantidad, precioUnitario, subtotal) values(?,?,?,?,?)";
        try {
            con = conectar.obtenerConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, db.getNumeroBoleta());
            ps.setInt(2, db.getCodigoProducto());
            ps.setInt(3, db.getCantidad());
            ps.setDouble(4, db.getPrecioUnitario());
            double subtotal = (db.getPrecioUnitario() * db.getCantidad());
            ps.setDouble(5, subtotal);
            ps.executeUpdate();
        } catch (Exception e) {

        }
        return 1;
    }

    public int actualizarPedido(detallesBoleta db) {
        int r = 0;
        String sql = "update detalleBoleta set cantidad=?, precioUnitario=?, subtotal=? where id=? and CodigoProducto=? and numeroBoleta=?";
        try {
            con = conectar.obtenerConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, db.getCantidad());
            ps.setDouble(2, db.getPrecioUnitario());
            double subtotal = (db.getPrecioUnitario() * db.getCantidad());
            ps.setDouble(3, subtotal);
            ps.setInt(4, db.getIdDetalle());
            ps.setInt(5, db.getCodigoProducto());
            ps.setInt(6, db.getNumeroBoleta());
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

    public void eliminar(int id) {
        String sql = "delete from detalleBoleta where id = ?";
        try {
            con = conectar.obtenerConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {

        }
    }

    public List listar() {
        List<detallesBoleta> datos = new ArrayList<>();
        String sql = "SELECT db.id, db.codigoProducto, p.nombreProducto, db.cantidad, db.precioUnitario, db.subtotal FROM detalleBoleta db INNER JOIN Producto p ON db.codigoProducto = p.codigoProducto;";
        try {
            con = conectar.obtenerConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                detallesBoleta db = new detallesBoleta();
                db.setIdDetalle(rs.getInt(1));
                db.setCodigoProducto(rs.getInt(2));
                db.setNombreProducto(rs.getString(3));
                db.setCantidad(rs.getInt(4));
                db.setPrecioUnitario(rs.getDouble(5));
                db.setSubtotal(rs.getDouble(6));
                datos.add(db);
            }
        } catch (Exception e) {

        }
        return datos;
    }

}
