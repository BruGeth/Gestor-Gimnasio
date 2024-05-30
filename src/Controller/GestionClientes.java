package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Model.Cliente;
import View.ClientMenu;
import Model.CuentaCliente;

public class GestionClientes implements ActionListener {

    private ClientMenu interfaz;
    private Cliente clientes;
    private CuentaCliente cuenta;

    public GestionClientes(ClientMenu interfaz, Cliente clientes,CuentaCliente cuenta) {
        this.interfaz = interfaz;
        this.clientes = clientes;
        this.cuenta = cuenta;
        this.interfaz.btnRegistarCliente.addActionListener(this);
        this.interfaz.btnActualizarCliente.addActionListener(this);
        this.interfaz.btnEliminarCliente.addActionListener(this);
        this.interfaz.btnVolver.addActionListener(this);

    }

    public void iniciar() {
        interfaz.setTitle("Gestor de Clientes");
        interfaz.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == interfaz.btnRegistarCliente) {
            cuenta.setIdCuenta(interfaz.txtCodigo.getText());
            clientes.setNombre(interfaz.txtNombre.getText());
            clientes.setApellidos(interfaz.txtApellidos.getText());
            clientes.setGenero(interfaz.txtGenero.getText());
            clientes.setEdad(Integer.parseInt(interfaz.txtEdad.getText()));
            clientes.setDireccion(interfaz.txtDireccion.getText());
            clientes.setTalla(Integer.parseInt(interfaz.txtTalla.getText()));
            clientes.setPeso(Integer.parseInt(interfaz.txtPeso.getText()));

        } else if (e.getSource() == interfaz.btnActualizarCliente) {
            // Acción para actualizar los datos de un cliente existente
            // Buscar el cliente en la lista y actualizar sus atributos
            // ...

        } else if (e.getSource() == interfaz.btnEliminarCliente) {
            // Acción para eliminar un cliente
            // Buscar el cliente en la lista y eliminarlo
            // ...

        } else if (e.getSource() == interfaz.btnVolver) {
            // Acción para volver a la pantalla anterior
            // ...
        }

    }

}
