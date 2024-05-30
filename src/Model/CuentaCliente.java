
package Model;

public class CuentaCliente {
        private String tipoMembresia;
        private String idCuenta;

    public CuentaCliente(String tipoMembresia, String idCuenta) {
        this.tipoMembresia = tipoMembresia;
        this.idCuenta = idCuenta;
    }

    public String getTipoMembresia() {        return tipoMembresia;    }
    public void setTipoMembresia(String tipoMembresia) {        this.tipoMembresia = tipoMembresia;    }
    public String getIdCuenta() {        return idCuenta;    }
    public void setIdCuenta(String idCuenta) {        this.idCuenta = idCuenta;    }
        
        
}
