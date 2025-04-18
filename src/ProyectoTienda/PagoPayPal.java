package ProyectoTienda;

public class PagoPayPal implements MetodoPago{

    @Override
    public void pagar(double monto) {
        System.out.println("Pagando $" + monto + " con PayPal.");
    }
    
}
