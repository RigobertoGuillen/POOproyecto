package ProyectoTienda;

import java.sql.Connection;
import java.sql.SQLException;

public class PedidoFacade {
    private GestorProducto gestorProducto = new GestorProducto(null);
    private GestorCliente gestorCliente = new GestorCliente();
    private GestorPago gestorPago = new GestorPago();
    private GestorFactura gestorFactura = new GestorFactura();

    public void realizarPedido(String nombreCliente, String correo, String telefono, String direccion, 
                              String nombreProducto, double precio, String categoria, String metodoPago) {
        System.out.println("Iniciando proceso de pedido...\n");

        try {
            Connection conn = ConexionDataBase.getInstancia().getConexion();
            Cliente cliente = new Cliente(nombreCliente, correo, telefono, direccion);
            ClienteBD clienteDAO = new ClienteBD(conn);
            int idCliente = clienteDAO.guardarCliente(cliente);
            cliente.setId(idCliente); // importante para usarlo en el pedido

            ProductoFactory factory = ProductoFactorySelector.getFactory(categoria);
            Producto producto = factory.crearProducto(nombreProducto, precio);

            Pedido pedido = new Pedido(cliente);
            pedido.agregarObservador(cliente);
            pedido.setEstado("Procesando");

            PedidoBD pedidoDAO = new PedidoBD(conn);
            int idPedido = pedidoDAO.guardarPedido(pedido);

            // Procesar método de pago
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
            metodo.procesarPago(producto.getPrecio());

            System.out.println("Producto: ");
            producto.mostrarDetalle();

            // Simular el cambio de estados
            String[] estados = {"Enviado", "Entregado"};
            for (String estado : estados) {
                Thread.sleep(1000); // Simular tiempo real
                pedido.cambiarEstado(estado);
                PedidoBD.actualizarEstado(idPedido, estado);
            }

            System.out.println("\nPedido completado con éxito.");

        } catch (SQLException | InterruptedException e) {
            e.printStackTrace();
        }
    }
    }
