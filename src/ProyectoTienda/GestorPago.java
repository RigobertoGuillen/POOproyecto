package ProyectoTienda;
public class GestorPago {

    private MetodoPago metodoPago;

    public void setMetodoPago(MetodoPago metodo) {
        this.metodoPago = metodo;
    }

    public void procesarPago(double monto) {

        if (metodoPago == null) {
            System.out.println("No se ha seleccionado un método de pago.");
        } else {
            metodoPago.pagar(monto);
        } 
       
    }
    
}
