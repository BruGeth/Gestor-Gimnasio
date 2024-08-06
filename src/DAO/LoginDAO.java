/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import modelo.Conexion;

/**
 *
 * @author chave
 */
public class LoginDAO {

    Conexion conectar = new Conexion();

    public int accesoUsuario(String user, String password) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int i = 0;

        try {
            con = conectar.obtenerConexion();
            ps = con.prepareStatement("SELECT usuario, contrasena FROM cuentaEmpleado WHERE usuario = ? AND contrasena = ?");
            ps.setString(1, user);
            ps.setString(2, password);
            rs = ps.executeQuery();

            if (rs.next()) {
                i = 1; // Usuario y contraseña correctos
                JOptionPane.showMessageDialog(null, "Login correcto. Bienvenido " + user);
            } else {
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecta");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar los recursos: " + e.getMessage());
            }
        }

        return i;
    }

    
//esta parte iba a ser para obtener el nombre del empleando que habia ingresado y colocarlo en la venta.
/*    
    public String obtenerNombreUsuario(String user, String password) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String nombreUsuario = null;

        try {
            con = conectar.obtenerConexion();
            ps = con.prepareStatement("SELECT usuario, contrasena FROM cuentaEmpleado WHERE usuario = ? AND contrasena = ?");
            ps.setString(1, user);
            ps.setString(2, password);
            rs = ps.executeQuery();

            if (rs.next()) {
                
                nombreUsuario = rs.getString("usuario");
            } else {

                System.out.println("Usuario o contraseña incorrecta");

            }
        } catch (Exception e) {
            System.out.println("error");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                System.out.println("Error al cerrar los recursos: " + e.getMessage());
            }
        }

        return nombreUsuario; // Devuelve el nombre de usuario
    }*/
}
