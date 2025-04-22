package ProyectoTienda;

public class PagoPayPal implements MetodoPago{

    @Override
    public void pagar(double monto) {
        System.out.println("Pagando L" + monto + " con PayPal.");
    }

    @Override
    public void procesarPago(double monto) {
        System.out.println("Procesando pago de L" + monto + " con PayPal...");

    }
    
}
