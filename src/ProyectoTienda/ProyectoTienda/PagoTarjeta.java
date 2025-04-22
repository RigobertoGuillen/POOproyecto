package ProyectoTienda;

public class PagoTarjeta implements MetodoPago {

    @Override
    public void pagar(double monto) {
        System.out.println("Pagando $" + monto + " con tarjeta de crédito.");
    
}

    @Override
    public void procesarPago(double monto) {
        System.out.println("Procesando pago de $" + monto + " con tarjeta de crédito...");
    }
}