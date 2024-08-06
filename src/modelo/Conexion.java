/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class Conexion {
    Connection con;
    
public Connection obtenerConexion(){
        String bd = "Gym";
        String url = "jdbc:mysql://localhost/"+bd;
        String user = "root";
        String password = "";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión a base de datos exitosa");
            return con;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error, No hay Conexión");
            return con=null;
        }
    }
}

