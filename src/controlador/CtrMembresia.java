/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import vista.Membresia;
import DAO.ClienteDAO;
import javax.swing.JOptionPane;

/**
 *
 * @author chave
 */
public class CtrMembresia implements ActionListener {

    ClienteDAO dao = new ClienteDAO();
    public static Membresia vistaMembresia = new Membresia();
    public int codigoCliente;

    public static void mostrar() {
        vistaMembresia.setVisible(true);
        vistaMembresia.setLocationRelativeTo(null);
    }

    public static void ocultar() {
        vistaMembresia.setVisible(false);
    }

    public CtrMembresia(Membresia vistaMembresia, int codigoCliente) {
        this.vistaMembresia = vistaMembresia;
        this.codigoCliente = codigoCliente;
        this.vistaMembresia.btnPlanBlack.addActionListener(this);
        this.vistaMembresia.btnPlanFit.addActionListener(this);
        this.vistaMembresia.btnPlanStandart.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaMembresia.btnPlanBlack) {
            int r = dao.actualizarTipoMembresia("Plan Black", codigoCliente);
            if (r == 1) {
                JOptionPane.showMessageDialog(vistaMembresia, "Se actualizo correctamente el tipo de membresia");
                ocultar();
            } else {
                JOptionPane.showMessageDialog(vistaMembresia, "No se actualizo la menbresia");
            }
        }
        if (e.getSource() == vistaMembresia.btnPlanFit) {
            int r = dao.actualizarTipoMembresia("Plan Fit", codigoCliente);
            if (r == 1) {
                JOptionPane.showMessageDialog(vistaMembresia, "Se actualizo correctamente el tipo de membresia");
                ocultar();
            } else {
                JOptionPane.showMessageDialog(vistaMembresia, "No se actualizo la menbresia");
            }
        }
        if (e.getSource() == vistaMembresia.btnPlanStandart) {
            int r = dao.actualizarTipoMembresia("Plan Standart", codigoCliente);
            if (r == 1) {
                JOptionPane.showMessageDialog(vistaMembresia, "Se actualizo correctamente el tipo de membresia");
                ocultar();
            } else {
                JOptionPane.showMessageDialog(vistaMembresia, "No se actualizo la menbresia");
            }
        }
    }
}
