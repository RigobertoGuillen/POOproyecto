package ProyectoTienda;

public class PagoTransferencia implements MetodoPago {

    @Override
    public void pagar(double monto) {
        System.out.println("Pagando $" + monto + " por transferencia bancaria.");
    
}

    @Override
    public void procesarPago(double monto) {
        System.out.println("Procesando pago de $" + monto + " mediante transferencia bancaria...");
    }
}
