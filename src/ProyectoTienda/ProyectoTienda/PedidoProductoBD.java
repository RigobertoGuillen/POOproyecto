package ProyectoTienda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PedidoProductoBD {
    
    private Connection conn;

    public PedidoProductoBD(Connection conn) {
        this.conn = conn;
    }

    public void guardarProductoEnPedido(int pedidoId, int productoId, int cantidad) throws SQLException {
        String sql = "INSERT INTO pedido_producto (pedido_id, producto_id, cantidad) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, pedidoId);
            stmt.setInt(2, productoId);
            stmt.setInt(3, cantidad);
            stmt.executeUpdate();
        }
    }

    
}
