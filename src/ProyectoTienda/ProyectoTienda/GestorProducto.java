package ProyectoTienda;

import java.sql.Connection;
import java.sql.SQLException;

public class GestorProducto {

    private ProductoBD productoBD;

    // Constructor que recibe una conexión (puede venir del Facade)
    public GestorProducto(Connection conn) {
        this.productoBD = new ProductoBD(conn);
    }

    /**
     * Crea y guarda múltiples productos usando una matriz de datos.
     * Cada fila representa: {nombre, categoria, precio}
     */
    public void crearYGuardarProductos(String[][] productos) throws SQLException {
        for (String[] datos : productos) {
            String nombre = datos[0];
            String categoria = datos[1];
            double precio = Double.parseDouble(datos[2]);

            // Usar el selector de fábrica para obtener la fábrica adecuada
            ProductoFactory factory = ProductoFactorySelector.getFactory(categoria);
            Producto producto = factory.crearProducto(nombre, precio);

            // Mostrar detalle y guardar en la base de datos
            producto.mostrarDetalle();

            int id = productoBD.guardarProducto(producto, categoria);
            if (id != -1) {
                System.out.println("Producto guardado con ID: " + id + "\n");
            } else {
                System.out.println("Error al guardar el producto.\n");
            }
        }
    }

    /**
     * Crea y guarda un solo producto
     */
    public int crearYGuardarProducto(String nombre, String categoria, double precio) throws SQLException {
        ProductoFactory factory = ProductoFactorySelector.getFactory(categoria);
        Producto producto = factory.crearProducto(nombre, precio);

        producto.mostrarDetalle();
        int id = productoBD.guardarProducto(producto, categoria);

        if (id != -1) {
            System.out.println("Producto guardado con ID: " + id + "\n");
        } else {
            System.out.println("Error al guardar el producto.\n");
        }

        return id;
    }
    
}
