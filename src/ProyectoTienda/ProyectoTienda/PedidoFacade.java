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
            
            Cliente cliente = gestorCliente.registrarCliente(nombreCliente, correo, telefono, direccion, conn);


            ProductoFactory factory = ProductoFactorySelector.getFactory(categoria);
            Producto producto = factory.crearProducto(nombreProducto, precio);

            Pedido pedido = new Pedido(cliente);
            pedido.agregarObservador(cliente);
            pedido.setEstado("Procesando");

            PedidoBD pedidoDAO = new PedidoBD(conn);
            int idPedido = pedidoDAO.guardarPedido(pedido);

            // Procesar tipo pago 
            gestorPago.procesarPago(metodoPago, producto.getPrecio());

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
