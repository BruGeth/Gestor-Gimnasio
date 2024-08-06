/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import DAO.AsistenciaDAO;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import vista.AsistenciaCliente;
import vista.Menu;



public class CtrAsistenciaCliente implements ActionListener{
    AsistenciaDAO dao = new AsistenciaDAO();
    public static AsistenciaCliente vistaClienteMenu = new AsistenciaCliente();
    public static void mostrar(){
        vistaClienteMenu.setVisible(true);
        vistaClienteMenu.setLocationRelativeTo(null);}
    public static void ocultar(){vistaClienteMenu.setVisible(false);}
    
    
    public CtrAsistenciaCliente(AsistenciaCliente ac){
        this.vistaClienteMenu = ac;
        this.vistaClienteMenu.btnEnter.addActionListener(this);
        this.vistaClienteMenu.btnExit.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==vistaClienteMenu.btnEnter){
            int i = dao.registrarAsistencia(Integer.parseInt(vistaClienteMenu.txtAsistencia.getText()));
            JOptionPane.showMessageDialog(vistaClienteMenu, "Asistencia Registrada");
            if(i==1){
               ocultar();
               Menu vistaMenu = new Menu();
               CtrMenu ctrMenu = new CtrMenu(vistaMenu);
               ctrMenu.mostrar();
            }
        }
        if(e.getSource()==vistaClienteMenu.btnExit){
            ocultar();
            Menu vistaMenu = new Menu();
            CtrMenu ctrMenu = new CtrMenu(vistaMenu);
            ctrMenu.mostrar();
        }
    }
}
