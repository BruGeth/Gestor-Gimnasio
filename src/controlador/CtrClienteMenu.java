/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Cliente;
import DAO.ClienteDAO;
import vista.ClienteMenu;
import vista.Menu;
import vista.Membresia;

/**
 *
 * @author chave
 */
public class CtrClienteMenu implements ActionListener {

    ClienteDAO dao = new ClienteDAO();
    Cliente c = new Cliente();
    DefaultTableModel modelo = new DefaultTableModel();
    public static ClienteMenu vistaClienteMenu = new ClienteMenu();

    public static void mostrar() {
        vistaClienteMenu.setVisible(true);
        vistaClienteMenu.setLocationRelativeTo(null);
    }

    public static void ocultar() {
        vistaClienteMenu.setVisible(false);
    }

    public CtrClienteMenu(ClienteMenu v) {
        this.vistaClienteMenu = v;
        this.vistaClienteMenu.btnListar.addActionListener(this);
        this.vistaClienteMenu.btnActualizarCliente.addActionListener(this);
        this.vistaClienteMenu.btnRegistarCliente.addActionListener(this);
        this.vistaClienteMenu.btnEditar.addActionListener(this);
        this.vistaClienteMenu.btnAtras.addActionListener(this);
        this.vistaClienteMenu.btnEliminarCliente.addActionListener(this);
        this.vistaClienteMenu.btnTipoMenbresia.addActionListener(this);
        listar(vistaClienteMenu.TablaClientes );
    }

    public void listar(JTable jTable) {
        modelo = (DefaultTableModel) jTable.getModel();
        List<Cliente> lista = dao.listar();

        for (int i = 0; i < lista.size(); i++) {
            Object[] object = new Object[8];
            object[0] = lista.get(i).getCodigoCliente();
            object[1] = lista.get(i).getNombre();
            object[2] = lista.get(i).getApellidos();
            object[3] = lista.get(i).getEdad();
            object[4] = lista.get(i).getDireccion();
            object[5] = lista.get(i).getGenero();
            object[6] = lista.get(i).getTalla();
            object[7] = lista.get(i).getPeso();
            modelo.addRow(object);
        }
        vistaClienteMenu.TablaClientes.setModel(modelo);
    }

    public void agregarCliente() {
        int codigoCliente = Integer.parseInt(vistaClienteMenu.txtCodigo.getText());
        String nombre = vistaClienteMenu.txtNombre.getText();
        String apellidos = vistaClienteMenu.txtApellidos.getText();
        String genero = vistaClienteMenu.txtGenero.getText();
        String direccion = vistaClienteMenu.txtDireccion.getText();
        int edad = Integer.parseInt(vistaClienteMenu.txtEdad.getText());
        double talla = Double.parseDouble(vistaClienteMenu.txtTalla.getText());
        double peso = Double.parseDouble(vistaClienteMenu.txtPeso.getText());
        c.setCodigoCliente(codigoCliente);
        c.setNombre(nombre);
        c.setApellidos(apellidos);
        c.setGenero(genero);
        c.setDireccion(direccion);
        c.setEdad(edad);
        c.setTalla(talla);
        c.setPeso(peso);
        int r = dao.agregar(c);
        if (r == 1) {
            JOptionPane.showMessageDialog(vistaClienteMenu, "usuario agregado exitosamente");
        } else {
            JOptionPane.showMessageDialog(vistaClienteMenu, "error");
        }
    }

    public void limpiarTabla() {
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
    }

    public void eliminarCliente() {
        int fila = vistaClienteMenu.TablaClientes.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vistaClienteMenu, "debe seleccionar un usuario");
        } else {
            int codigoCliente = Integer.parseInt((String) vistaClienteMenu.TablaClientes.getValueAt(fila, 0).toString());
            dao.eliminar(codigoCliente);
            JOptionPane.showMessageDialog(vistaClienteMenu, "usuario eliminado");
        }
    }

    public void actualizarCliente() {
        int codigoCliente = Integer.parseInt(vistaClienteMenu.txtCodigo.getText());
        String nombre = vistaClienteMenu.txtNombre.getText();
        String apellidos = vistaClienteMenu.txtApellidos.getText();
        String genero = vistaClienteMenu.txtGenero.getText();
        int edad = Integer.parseInt(vistaClienteMenu.txtEdad.getText());
        String direccion = vistaClienteMenu.txtDireccion.getText();
        double talla = Double.parseDouble(vistaClienteMenu.txtTalla.getText());
        double peso = Double.parseDouble(vistaClienteMenu.txtPeso.getText());
        c.setCodigoCliente(codigoCliente);
        c.setNombre(nombre);
        c.setApellidos(apellidos);
        c.setGenero(genero);
        c.setEdad(edad);
        c.setDireccion(direccion);
        c.setTalla(talla);
        c.setPeso(peso);
        int r = dao.actualizar(c);
        if (r == 1) {
            JOptionPane.showMessageDialog(vistaClienteMenu, "usuario actualizado correctamente");
        } else {
            JOptionPane.showMessageDialog(vistaClienteMenu, "el usuario no se pudo actualizar");
        }
    }

    public void editar() {
        int fila = vistaClienteMenu.TablaClientes.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vistaClienteMenu, "debe seleccionar una fila");
        } else {
            int codigoCliente = Integer.parseInt((String) vistaClienteMenu.TablaClientes.getValueAt(fila, 0).toString());
            String nombre = (String) vistaClienteMenu.TablaClientes.getValueAt(fila, 1);
            String apellidos = (String) vistaClienteMenu.TablaClientes.getValueAt(fila, 2);
            int edad = Integer.parseInt((String) vistaClienteMenu.TablaClientes.getValueAt(fila, 3).toString());
            String direccion = (String) vistaClienteMenu.TablaClientes.getValueAt(fila, 4);
            String genero = (String) vistaClienteMenu.TablaClientes.getValueAt(fila, 5);
            double talla = Double.parseDouble((String) vistaClienteMenu.TablaClientes.getValueAt(fila, 6).toString());
            double peso = Double.parseDouble((String) vistaClienteMenu.TablaClientes.getValueAt(fila, 7).toString());
            vistaClienteMenu.txtCodigo.setText("" + codigoCliente);
            vistaClienteMenu.txtNombre.setText(nombre);
            vistaClienteMenu.txtApellidos.setText(apellidos);
            vistaClienteMenu.txtEdad.setText("" + edad);
            vistaClienteMenu.txtDireccion.setText(direccion);
            vistaClienteMenu.txtGenero.setText(genero);
            vistaClienteMenu.txtTalla.setText("" + talla);
            vistaClienteMenu.txtPeso.setText("" + peso);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaClienteMenu.btnRegistarCliente) {
            limpiarTabla();
            agregarCliente();
        }
        if (e.getSource() == vistaClienteMenu.btnListar) {
            limpiarTabla();
            listar(vistaClienteMenu.TablaClientes);
        }
        if (e.getSource() == vistaClienteMenu.btnEliminarCliente) {
            eliminarCliente();
            limpiarTabla();
            listar(vistaClienteMenu.TablaClientes);
        }
        if (e.getSource() == vistaClienteMenu.btnActualizarCliente) {
            actualizarCliente();
            limpiarTabla();
            listar(vistaClienteMenu.TablaClientes);
        }
        if (e.getSource() == vistaClienteMenu.btnEditar) {
            editar();
        }
        if (e.getSource() == vistaClienteMenu.btnTipoMenbresia) {
            int fila = vistaClienteMenu.TablaClientes.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(vistaClienteMenu, "Debe seleccionar un usuario");
            } else {
                int codigoCliente = Integer.parseInt((String) vistaClienteMenu.TablaClientes.getValueAt(fila, 0).toString());
                //ocultar();
                Membresia vistaMembresia = new Membresia();
                CtrMembresia ctrMembresia = new CtrMembresia(vistaMembresia, codigoCliente);
                ctrMembresia.mostrar();
            }
        }
        if (e.getSource() == vistaClienteMenu.btnAtras) {
            ocultar();
            Menu vistaMenu = new Menu();
            CtrMenu ctrMenu = new CtrMenu(vistaMenu);
            ctrMenu.mostrar();
        }
    }

}
