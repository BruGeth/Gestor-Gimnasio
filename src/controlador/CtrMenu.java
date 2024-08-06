/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import DAO.RegistroAsistenciaDAO;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.RegistroAsistencia;
import vista.*;

public class CtrMenu implements ActionListener {

    RegistroAsistenciaDAO dao = new RegistroAsistenciaDAO();
    DefaultTableModel modelo = new DefaultTableModel();
    public static Menu vistaMenu = new Menu();

    public static void mostrar() {
        vistaMenu.setVisible(true);
        vistaMenu.setLocationRelativeTo(null);
    }

    public static void ocultar() {
        vistaMenu.setVisible(false);
    }

    public CtrMenu(Menu m) {
        this.vistaMenu = m;
        this.vistaMenu.btnGestionarClientes.addActionListener(this);
        this.vistaMenu.btnAsistencia.addActionListener(this);
        this.vistaMenu.btnIngresarProducto.addActionListener(this);
        this.vistaMenu.btnRegistrarVenta.addActionListener(this);
        this.vistaMenu.btnMenuSalir.addActionListener(this);
        Listar(vistaMenu.jTable1);
    }

    public void Listar(JTable jTable) {
        modelo = (DefaultTableModel) jTable.getModel();
        List<RegistroAsistencia> lista = dao.Listar();

        for (int i = 0; i < lista.size(); i++) {
            Object[] object = new Object[4];
            object[0] = lista.get(i).getCodigo();
            object[1] = lista.get(i).getNombre();
            object[2] = lista.get(i).getFecha();
            object[3] = lista.get(i).getHora_entrada();
            modelo.addRow(object);
        }
        vistaMenu.jTable1.setModel(modelo);
    }

    public void LimpiarTabla() {
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaMenu.btnGestionarClientes) {
            ocultar();
            ClienteMenu vistaClienteMenu = new ClienteMenu();
            CtrClienteMenu ctrClienteMenu = new CtrClienteMenu(vistaClienteMenu);
            ctrClienteMenu.mostrar();
        }
        if (e.getSource() == vistaMenu.btnAsistencia) {
            ocultar();
            AsistenciaCliente vistaAsistenciaCliente = new AsistenciaCliente();
            CtrAsistenciaCliente ctrAsistenciaCliente = new CtrAsistenciaCliente(vistaAsistenciaCliente);
            ctrAsistenciaCliente.mostrar();
        }
        if (e.getSource() == vistaMenu.btnIngresarProducto) {
            ocultar();
//            RegistroProductos vistaRegistroProductos = new RegistroProductos();
//            CtrRegistroProducto ctrRegistroProducto = new CtrRegistroProducto(vistaRegistroProductos);
//            ctrRegistroProducto.mostrar();

            ProductoMenu vistaProductoMenu = new ProductoMenu();
            CtrProductoMenu ctrProductoMenu = new CtrProductoMenu(vistaProductoMenu);
            ctrProductoMenu.mostrar();
        }
        if (e.getSource() == vistaMenu.btnRegistrarVenta) {
            ocultar();
            VentaProductos vistaVentaProductos = new VentaProductos();
            CtrGenerarVenta ctrGenerarVenta = new CtrGenerarVenta(vistaVentaProductos);
            ctrGenerarVenta.mostrar();
        }
        if (e.getSource() == vistaMenu.btnMenuSalir) {
            ocultar();
            Login vistaLogin = new Login();
            CtrLogin ctrLogin = new CtrLogin(vistaLogin);
            ctrLogin.mostrar();
        }
    }
}
