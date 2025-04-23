package ProyectoTienda;
public class GestorPago {

    private MetodoPago metodoPago;

    public void setMetodoPago(MetodoPago metodo) {
        this.metodoPago = metodo;
    }

    public void procesarPago(String metodoPago, double monto) {
        MetodoPago metodo;
        switch (metodoPago.toLowerCase()) {
            case "tarjeta":
                metodo = new PagoTarjeta();
                break;
            case "paypal":
                metodo = new PagoPayPal();
                break;
            case "transferencia":
                metodo = new PagoTransferencia();
                break;
            default:
                throw new IllegalArgumentException("Método de pago no válido.");
        }
        metodo.procesarPago(monto);
    }

        
       
    }

   
    

