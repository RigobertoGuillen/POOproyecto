package ProyectoTienda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteBD {
    
    private Connection conn;

    public ClienteBD(Connection conn) {
        this.conn = conn;
    }

    public int guardarCliente(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO cliente (nombre, correo, telefono, direccion) VALUES (?, ?, ?, ?) RETURNING id";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getCorreo());
            stmt.setString(3, cliente.getTelefono());
            stmt.setString(4, cliente.getDireccion());

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("id"); // devuelve el ID generado
            }
        }
        return -1;
    }
}
