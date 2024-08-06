package controlador;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Producto;
import DAO.ProductoDAO;
import vista.ProductoMenu;
import vista.Menu;

public class CtrProductoMenu implements ActionListener {

    ProductoDAO dao = new ProductoDAO();
    Producto p = new Producto();
    DefaultTableModel modelo = new DefaultTableModel();
    public static ProductoMenu vistaProductoMenu = new ProductoMenu();

    public static void mostrar() {
        vistaProductoMenu.setVisible(true);
        vistaProductoMenu.setLocationRelativeTo(null);
    }

    public static void ocultar() {
        vistaProductoMenu.setVisible(false);
    }

    public CtrProductoMenu(ProductoMenu v) {
        this.vistaProductoMenu = v;
        this.vistaProductoMenu.btnListar.addActionListener(this);
        this.vistaProductoMenu.btnActualizarProducto.addActionListener(this);
        this.vistaProductoMenu.btnRegistrarProducto.addActionListener(this);
        this.vistaProductoMenu.btnEditar.addActionListener(this);
        this.vistaProductoMenu.btnAtras.addActionListener(this);
        this.vistaProductoMenu.btnEliminarProducto.addActionListener(this);
        listar(vistaProductoMenu.TablaProductos);
    }

    public void listar(JTable jTable) {
        modelo = (DefaultTableModel) jTable.getModel();
        List<Producto> lista = dao.listar();
        Object[] object = new Object[5];
        for (int i = 0; i < lista.size(); i++) {
            object[0] = lista.get(i).getCodigoProducto();
            object[1] = lista.get(i).getNombreProducto();
            object[2] = lista.get(i).getCantidad();
            object[3] = lista.get(i).getPrecio();
            object[4] = lista.get(i).getCategoria();
            modelo.addRow(object);
        }
        vistaProductoMenu.TablaProductos.setModel(modelo);
    }

    public void agregarProducto() {
        int codigoProducto = Integer.parseInt(vistaProductoMenu.txtCodigo.getText());
        String nombre = vistaProductoMenu.txtNombre.getText();
        int cantidad = Integer.parseInt(vistaProductoMenu.txtCantidad.getText());
        double precio = Double.parseDouble(vistaProductoMenu.txtPrecio.getText());
        String categoria =vistaProductoMenu.txtCategoria.getText();

        p.setCodigoProducto(codigoProducto);
        p.setNombreProducto(nombre);
        p.setCantidad(cantidad);
        p.setPrecio(precio);
        p.setCategoria(categoria);

        int r = dao.agregar(p);
        if (r == 1) {
            JOptionPane.showMessageDialog(vistaProductoMenu, "Producto agregado exitosamente");
        } else {
            JOptionPane.showMessageDialog(vistaProductoMenu, "Error");
        }
    }

    public void limpiarTabla() {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

    public void eliminarProducto() {
        int fila = vistaProductoMenu.TablaProductos.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vistaProductoMenu, "Debe seleccionar un producto");
        } else {
            int codigoProducto = Integer.parseInt((String) vistaProductoMenu.TablaProductos.getValueAt(fila, 0).toString());
            dao.eliminar(codigoProducto);
            JOptionPane.showMessageDialog(vistaProductoMenu, "Producto eliminado");
        }
    }

    public void actualizarProducto() {
        int codigoProducto = Integer.parseInt(vistaProductoMenu.txtCodigo.getText());
        String nombre = vistaProductoMenu.txtNombre.getText();
        int cantidad = Integer.parseInt(vistaProductoMenu.txtCantidad.getText());
        double precio = Double.parseDouble(vistaProductoMenu.txtPrecio.getText());
        String categoria = vistaProductoMenu.txtCategoria.getText();

        p.setCodigoProducto(codigoProducto);
        p.setNombreProducto(nombre);
        p.setCantidad(cantidad);
        p.setPrecio(precio);
        p.setCategoria(categoria);

        int r = dao.actualizar(p);
        if (r == 1) {
            JOptionPane.showMessageDialog(vistaProductoMenu, "Producto actualizado correctamente");
        } else {
            JOptionPane.showMessageDialog(vistaProductoMenu, "Error al actualizar el producto");
        }
    }

    public void editar() {
        int fila = vistaProductoMenu.TablaProductos.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vistaProductoMenu, "Debe seleccionar una fila");
        } else {
            int codigoProducto = Integer.parseInt((String) vistaProductoMenu.TablaProductos.getValueAt(fila, 0).toString());
            String nombre = (String) vistaProductoMenu.TablaProductos.getValueAt(fila, 1);
            int cantidad = Integer.parseInt((String) vistaProductoMenu.TablaProductos.getValueAt(fila, 2).toString());
            double precio = Double.parseDouble((String) vistaProductoMenu.TablaProductos.getValueAt(fila, 3).toString());
            int categoria = Integer.parseInt((String) vistaProductoMenu.TablaProductos.getValueAt(fila, 4).toString());

            vistaProductoMenu.txtCodigo.setText("" + codigoProducto);
            vistaProductoMenu.txtNombre.setText(nombre);
            vistaProductoMenu.txtCantidad.setText("" + cantidad);
            vistaProductoMenu.txtPrecio.setText("" + precio);
            vistaProductoMenu.txtCategoria.setText("" + categoria);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaProductoMenu.btnRegistrarProducto) {
            agregarProducto();
            limpiarTabla();
            listar(vistaProductoMenu.TablaProductos);
        }
        if (e.getSource() == vistaProductoMenu.btnListar) {
            limpiarTabla();
            listar(vistaProductoMenu.TablaProductos);
        }
        if (e.getSource() == vistaProductoMenu.btnEliminarProducto) {
            eliminarProducto();
            limpiarTabla();
            listar(vistaProductoMenu.TablaProductos);
        }
        if (e.getSource() == vistaProductoMenu.btnActualizarProducto) {
            actualizarProducto();
            limpiarTabla();
            listar(vistaProductoMenu.TablaProductos);
        }
        if (e.getSource() == vistaProductoMenu.btnEditar) {
            editar();
        }
        if (e.getSource() == vistaProductoMenu.btnAtras) {
            ocultar();
            Menu vistaMenu = new Menu();
            CtrMenu ctrMenu = new CtrMenu(vistaMenu);
            ctrMenu.mostrar();
        }
    }
}