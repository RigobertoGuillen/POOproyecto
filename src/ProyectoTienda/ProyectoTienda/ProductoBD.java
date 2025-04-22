package ProyectoTienda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductoBD {
    
    private Connection conn;

    public ProductoBD(Connection conn) {
        this.conn = conn;
    }

   public int guardarProducto(Producto producto, String categoria) throws SQLException {
        String sql = "INSERT INTO producto (nombre, precio) VALUES (?, ?) RETURNING id";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, producto.getNombre());
            stmt.setDouble(2, producto.getPrecio());

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int idProducto = rs.getInt("id");

                // Guardar en tabla hija según categoría
                if (categoria.equalsIgnoreCase("electronico")) {
                    String sqlHijo = "INSERT INTO producto_electronico (id, garantia) VALUES (?, ?)";
                    try (PreparedStatement stmtHijo = conn.prepareStatement(sqlHijo)) {
                        stmtHijo.setInt(1, idProducto);
                        stmtHijo.setInt(2, ((ProductoElectronico) producto).getGarantiaMeses());
                        stmtHijo.executeUpdate();
                    }
                } else if (categoria.equalsIgnoreCase("ropa")) {
                    String sqlHijo = "INSERT INTO producto_ropa (id, talla) VALUES (?, ?)";
                    try (PreparedStatement stmtHijo = conn.prepareStatement(sqlHijo)) {
                        stmtHijo.setInt(1, idProducto);
                        stmtHijo.setString(2, ((ProductoRopa) producto).getTalla());
                        stmtHijo.executeUpdate();
                    }
                }

                return idProducto;
            }
        }

        return -1;
    }
}
