/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import DAO.LoginDAO;
import vista.Menu;
import vista.Login;
//import javax.swing.JOptionPane;

public class CtrLogin implements ActionListener {

    LoginDAO dao = new LoginDAO();
    public static Login vistaLogin = new Login();

    public static void mostrar() {
        vistaLogin.setVisible(true);
        vistaLogin.setLocationRelativeTo(null);
    }

    public static void ocultar() {
        vistaLogin.setVisible(false);
    }

    public CtrLogin(Login vistalogin) {
        this.vistaLogin = vistalogin;
        this.vistaLogin.btnEntrar.addActionListener(this);
        this.vistaLogin.btnSalir.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaLogin.btnEntrar) {
            int i = dao.accesoUsuario(vistaLogin.txtUsuario.getText(), vistaLogin.txtPassword.getText());
            //Trate de obtener el nombre del usuario
            //String nombreuser = dao.obtenerNombreUsuario(vistaLogin.txtUsuario.getText(), vistaLogin.txtPassword.getText());
            //JOptionPane.showMessageDialog(vistaLogin, "se presiono el boton");
            if (i == 1) {
                ocultar();
                Menu vistaMenu = new Menu();
                CtrMenu ctrMenu = new CtrMenu(vistaMenu);
                ctrMenu.mostrar();
            }
        }
        if (e.getSource() == vistaLogin.btnSalir) {
            ocultar();
        }
    }
}
