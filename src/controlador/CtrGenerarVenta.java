package controlador;

import DAO.BoletaDAO;
import DAO.ClienteDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Producto;
import DAO.ProductoDAO;
import DAO.detallesBoletaDAO;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Boleta;
import modelo.detallesBoleta;
import vista.Menu;
import vista.VentaProductos;

/**
 *
 * @author G15br
 */
public class CtrGenerarVenta implements ActionListener {

    Producto p = new Producto();
    ProductoDAO daoP = new ProductoDAO();
    Boleta b = new Boleta();
    BoletaDAO daoB = new BoletaDAO();
    detallesBoleta db = new detallesBoleta();
    ClienteDAO daoC = new ClienteDAO();
    detallesBoletaDAO daoDB = new detallesBoletaDAO();
    DefaultTableModel modelo = new DefaultTableModel();
    public static VentaProductos vista = new VentaProductos();

    public static void mostrar() {
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
    }

    public static void ocultar() {
        vista.setVisible(false);
    }

    public CtrGenerarVenta(VentaProductos v) {
        this.vista = v;
        this.vista.btnBuscarCliente.addActionListener(this);
        this.vista.btnBuscarProducto.addActionListener(this);
        this.vista.btnAgregarPedido.addActionListener(this);
        this.vista.btnActualizarPedido.addActionListener(this);
        this.vista.btnEliminarPedido.addActionListener(this);
        this.vista.btnGenerarBoleta.addActionListener(this);
        this.vista.btnCancelar.addActionListener(this);
        String fechaActual = daoB.obtenerFecha();
        vista.txtFecha.setText(fechaActual);
        vista.txtFecha.setEditable(false);
        vista.txtNombreCliente.setEditable(false);
        vista.txtNombreProducto.setEditable(false);
        vista.txtStock.setEditable(false);
        vista.txtPrecio.setEditable(false);
        listar(vista.tableDetalleBoleta);
    }

    public void buscarCliente() {
        int codCliente = Integer.parseInt(vista.txtDNI.getText());
        String NomCli = daoC.obtenerNomCliente(codCliente);

        if (NomCli != null) {
            System.out.println("Cliente encontrado");
            System.out.println(NomCli);
            vista.txtNombreCliente.setText(NomCli);
        } else {
            JOptionPane.showMessageDialog(null, "Cliente no encontrado");
            System.out.println("Cliente no encontrado");
            vista.txtNombreCliente.setText("");
        }
    }

    public void buscarProducto() {
        int codProducto = Integer.parseInt(vista.txtCodigoProducto.getText());
        String NomProd = daoP.obtenerNomProducto(codProducto);
        int stock = daoP.obtenerStockProducto(codProducto);
        double precio = daoP.obtenerPrecioProducto(codProducto);

        if (NomProd != null) {
            System.out.println("Producto encontrado");
            vista.txtNombreProducto.setText(NomProd);
            vista.txtStock.setText(String.valueOf(stock));
            vista.txtPrecio.setText(String.valueOf(precio));
        } else {
            JOptionPane.showMessageDialog(null, "Producto no encontrado");
            System.out.println("Producto no encontrado");
            vista.txtNombreProducto.setText("");
            vista.txtStock.setText("");
            vista.txtPrecio.setText("");
        }
    }

    public void listar(JTable jTable) {
        modelo = (DefaultTableModel) jTable.getModel();
        List<detallesBoleta> listaDB = daoDB.listar();

        for (int i = 0; i < listaDB.size(); i++) {
            Object[] object = new Object[6];
            object[0] = listaDB.get(i).getIdDetalle();
            object[1] = listaDB.get(i).getCodigoProducto();
            object[2] = listaDB.get(i).getNombreProducto();
            object[3] = listaDB.get(i).getCantidad();
            object[4] = listaDB.get(i).getPrecioUnitario();
            object[5] = listaDB.get(i).getSubtotal();
            modelo.addRow(object);
        }
        vista.tableDetalleBoleta.setModel(modelo);
    }

    public void limpiarTabla() {
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
    }

    public void agregarCarrito() {

        int numBol = daoB.generarNumeroBoleta();
        String fecha = vista.txtFecha.getText();
        Double Total = 0.0;
        int DNI = Integer.parseInt(vista.txtDNI.getText());

        b.setNumeroBoleta(numBol);
        b.setFecha(fecha);
        b.setTotal(Total);
        b.setDNICliente(DNI);
        daoB.PrepararBoleta(b);

        int codProducto = Integer.parseInt(vista.txtCodigoProducto.getText());
        int cant = Integer.parseInt(vista.txtCantidad.getText());
        double precio = Double.parseDouble(vista.txtPrecio.getText());
        int stock = Integer.parseInt(vista.txtStock.getText());

        if (cant > stock) {
            JOptionPane.showMessageDialog(vista, "Stock isuficiente");
        } else {
            db.setNumeroBoleta(numBol);
            db.setCodigoProducto(codProducto);
            db.setPrecioUnitario(precio);
            db.setCantidad(cant);
            int r = 0;
            r = daoDB.añadirCarrito(db);

            if (r == 1) {
                int actualizarStock = daoP.actualizarStock(codProducto, -cant);
                if (actualizarStock > 0) {
                    JOptionPane.showMessageDialog(vista, "Pedido añadido y stock actualizado");
                } else {
                    JOptionPane.showMessageDialog(vista, "Error al actualizar el stock");
                }
            } else {
                JOptionPane.showMessageDialog(vista, "Error al añadir el pedido al carrito");
            }
        }
    }

    public void eliminarCarrito() {
        int fila = vista.tableDetalleBoleta.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vista, "Debe seleccionar un pedido");
        } else {
            int id = Integer.parseInt((String) vista.tableDetalleBoleta.getValueAt(fila, 0).toString());
            int codProducto = Integer.parseInt(vista.tableDetalleBoleta.getValueAt(fila, 1).toString());
            int cantidad = Integer.parseInt(vista.tableDetalleBoleta.getValueAt(fila, 3).toString());

            daoDB.eliminar(id);

            int r = daoP.actualizarStock(codProducto, cantidad);

            if (r > 0) {
                JOptionPane.showMessageDialog(vista, "Pedido removido y stock actualizado");
                limpiarTabla();
                listar(vista.tableDetalleBoleta);
            } else {
                JOptionPane.showMessageDialog(vista, "Error al actualizar el stock");
            }
        }
    }

    public void actualizarCarrito() {
        int cantidad = Integer.parseInt(vista.txtCantidad.getText());
        Double PrecioU = Double.parseDouble(vista.txtPrecio.getText());
        Double Subtotal = cantidad * PrecioU;
        int id = 0;
        int CodProducto = Integer.parseInt(vista.txtCodigoProducto.getText());
        int numBol = 0;
        db.setCantidad(cantidad);
        db.setPrecioUnitario(PrecioU);
        db.setSubtotal(Subtotal);
        db.setIdDetalle(id);
        db.setCodigoProducto(CodProducto);
        db.setNumeroBoleta(numBol);
        int r = daoDB.actualizarPedido(db);
        if (r == 1) {
            JOptionPane.showMessageDialog(vista, "usuario actualizado correctamente");
        } else {
            JOptionPane.showMessageDialog(vista, "el usuario no se pudo actualizar");
        }
    }

    public void actualizarPedido() {
        int fila = vista.tableDetalleBoleta.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vista, "Seleccione un pedido para actualizar");
            return;
        }

        int codProducto = Integer.parseInt(vista.txtCodigoProducto.getText());
        int cantidadAnterior = Integer.parseInt(vista.tableDetalleBoleta.getValueAt(fila, 3).toString());
        int cantidadNueva = Integer.parseInt(vista.txtCantidad.getText());
        int diferenciaCantidad = cantidadNueva - cantidadAnterior;

        int stockActual = daoP.obtenerStockProducto(codProducto);
        if (stockActual + cantidadAnterior < cantidadNueva) {
            JOptionPane.showMessageDialog(vista, "Stock insuficiente para la actualización");
            return;
        }

        // Actualizar el pedido en la base de datos
        actualizarCarrito();

        // Actualizar el stock
        int r = daoP.actualizarStock(codProducto, -diferenciaCantidad);
        if (r > 0) {
            JOptionPane.showMessageDialog(vista, "Pedido actualizado y stock modificado");
            limpiarTabla();
            listar(vista.tableDetalleBoleta);
        } else {
            JOptionPane.showMessageDialog(vista, "Error al actualizar el stock");
        }
    }

    public void generarBoleta() {
        int numBol = (int) vista.tableDetalleBoleta.getValueAt(1, 1);
        String fecha = vista.txtFecha.getText();
        Double Total = 0.0;

        for (int fila = 0; fila < modelo.getRowCount(); fila++) {
            Object valor = modelo.getValueAt(fila, 5);
            if (valor instanceof Number) {
                Total += ((Number) valor).doubleValue();
            }
        }

        int DNI = Integer.parseInt(vista.txtDNI.getText());
        b.setNumeroBoleta(numBol);
        b.setFecha(fecha);
        b.setTotal(Total);
        b.setDNICliente(DNI);
        int r = daoB.PrepararBoleta(b);
        if (r == 1) {
            JOptionPane.showMessageDialog(vista, "Boleta Procesada");
        } else {
            JOptionPane.showMessageDialog(vista, "error");
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnBuscarCliente) {
            buscarCliente();
        }
        if (e.getSource() == vista.btnBuscarProducto) {
            buscarProducto();
        }
        if (e.getSource() == vista.btnAgregarPedido) {
            limpiarTabla();
            agregarCarrito();
            listar(vista.tableDetalleBoleta);
        }
        if (e.getSource() == vista.btnActualizarPedido) {
            actualizarPedido();
            limpiarTabla();
            listar(vista.tableDetalleBoleta);
        }
        if (e.getSource() == vista.btnEliminarPedido) {
            eliminarCarrito();
            limpiarTabla();
            listar(vista.tableDetalleBoleta);
        }
        if (e.getSource() == vista.btnCancelar) {
            ocultar();
            Menu vistaMenu = new Menu();
            CtrMenu ctrMenu = new CtrMenu(vistaMenu);
            ctrMenu.mostrar();
        }
        if (e.getSource() == vista.btnGenerarBoleta) {
            generarBoleta();
            limpiarTabla();
            listar(vista.tableDetalleBoleta);
        }
    }
}
