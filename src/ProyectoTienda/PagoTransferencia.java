package ProyectoTienda;

public class PagoTransferencia implements MetodoPago {

    @Override
    public void pagar(double monto) {
        System.out.println("Pagando $" + monto + " por transferencia bancaria.");
    
}
}
