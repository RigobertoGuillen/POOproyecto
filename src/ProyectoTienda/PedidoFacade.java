package ProyectoTienda;
public class PedidoFacade {
    private GestorProducto gestorProducto = new GestorProducto();
    private GestorCliente gestorCliente = new GestorCliente();
    private GestorPago gestorPago = new GestorPago();
    private GestorFactura gestorFactura = new GestorFactura();

    public void realizarPedido(String nombreCliente, String nombreProducto, double precio, String categoria, String metodoPago) {
        System.out.println("Iniciando proceso de pedido...\n");

        Cliente cliente = new Cliente(nombreCliente);
        ProductoFactory factory = ProductoFactorySelector.getFactory(categoria);
        Producto producto = factory.crearProducto(nombreProducto, precio);

        
        Pedido pedido = new Pedido(cliente);
        pedido.agregarObservador(cliente);

        gestorCliente.registrarCliente(cliente.getNombre());
        producto.mostrarDetalle();
        gestorProducto.verificarDisponibilidad(nombreProducto);
        
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
    gestorPago.setMetodoPago(metodo);
    gestorPago.procesarPago(producto.getPrecio());

    gestorFactura.generarFactura(producto.nombre, producto.getPrecio());

        
        pedido.cambiarEstado("Procesando");
        pedido.cambiarEstado("Enviado");
        pedido.cambiarEstado("Entregado");

        System.out.println("\nPedido completado con éxito.");
    }
}