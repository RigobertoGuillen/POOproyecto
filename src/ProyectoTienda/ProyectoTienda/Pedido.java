package ProyectoTienda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    
     private String estado;
    private List<Observador> observadores = new ArrayList<>();
    private int id;
    private Cliente cliente;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    private List<Producto> productos;


    public void agregarObservador(Observador obs) {
        observadores.add(obs);
    }

    public void cambiarEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
        notificarObservadores();
    }

    private void notificarObservadores() {
        for (Observador obs : observadores) {
            obs.actualizar("El estado del pedido cambió a: " + estado);
        }
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto p) {
        productos.add(p);
    }

    public void guardarEnBD() {
        try {
            Connection conn = (Connection) ConexionDataBase.getInstancia();

            // 1. Insertar pedido
            String insertPedido = "INSERT INTO pedido (cliente_id) VALUES (?) RETURNING id";
            PreparedStatement stmtPedido = conn.prepareStatement(insertPedido);
            stmtPedido.setInt(1, cliente.getId());
            ResultSet rs = stmtPedido.executeQuery();
            rs.next();
            int pedidoId = rs.getInt(1);

            // 2. Insertar productos y relación
            for (Producto p : productos) {
                p.guardarEnBD(); // inserta producto en su tabla hija

                // Obtener ID del último producto insertado
                ResultSet rsProd = conn.createStatement().executeQuery("SELECT MAX(id) FROM producto");
                rsProd.next();
                int productoId = rsProd.getInt(1);

                String insertRelacion = "INSERT INTO pedido_producto (pedido_id, producto_id, cantidad) VALUES (?, ?, ?)";
                PreparedStatement stmtRel = conn.prepareStatement(insertRelacion);
                stmtRel.setInt(1, pedidoId);
                stmtRel.setInt(2, productoId);
                stmtRel.setInt(3, 1); // cantidad fija por ahora
                stmtRel.executeUpdate();
            }

            System.out.println("Pedido registrado con productos.");

        } catch (Exception e) {
            e.printStackTrace();
        }
}
}
