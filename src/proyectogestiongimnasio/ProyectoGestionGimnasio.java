/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectogestiongimnasio;

//import modelo.*;
//import vista.RegistroProductos;
import controlador.*;
//import vista.ClienteMenu;
import vista.Login;

public class ProyectoGestionGimnasio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            //RegistroProductos vista = new RegistroProductos();
            //conregistroProducto cro = new conregistroProducto(vista);
            //vista.setVisible(true);
            
            
            //menuCliente
            //ClienteMenu vistacm = new ClienteMenu();
            //CtrClienteMenu crt = new CtrClienteMenu(vistacm);
            //vistacm.setVisible(true);
           
            Login vistaLogin = new Login();
            CtrLogin ctrLogin = new CtrLogin(vistaLogin);
            ctrLogin.mostrar();
    }
    
}
