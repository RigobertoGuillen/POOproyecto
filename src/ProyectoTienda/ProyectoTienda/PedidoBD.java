package ProyectoTienda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PedidoBD {
    
    private static Connection conn;

    public PedidoBD(Connection conn) {
        PedidoBD.conn = conn;
    }

    public int guardarPedido(Pedido pedido) throws SQLException {
        String sql = "INSERT INTO pedido (cliente_id , estado) VALUES (?, ?) RETURNING id";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, pedido.getCliente().getId());
            stmt.setString(2, pedido.getEstado());

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }
        }
        return -1;
    }

    public static void actualizarEstado(int idPedido, String estado) {
        String sql = "UPDATE pedido SET estado = ? WHERE id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, estado);
            stmt.setInt(2, idPedido);
            int filasActualizadas = stmt.executeUpdate();

            if (filasActualizadas > 0) {
                System.out.println("Estado del pedido actualizado a: " + estado);
            } else {
                System.out.println("No se encontró el pedido con ID: " + idPedido);
            }

        } catch (SQLException e) {
            System.out.println("Error al actualizar estado del pedido: " + e.getMessage());
        }
    }
    }

