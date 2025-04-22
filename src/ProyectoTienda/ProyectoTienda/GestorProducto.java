package ProyectoTienda;

import java.sql.SQLException;

public class GestorProducto {

    public void verificarDisponibilidad(String producto) {
        System.out.println("Verificando disponibilidad de " + producto);
    }

    private ProductoBD productoBD;

    public ProductoBD getProductoBD() {
        return productoBD;
    }

    public void setProductoBD(ProductoBD productoBD) {
        this.productoBD = productoBD;
    }

    public GestorProducto(){
        
    }

    // Constructor con dependencia de ProductoBD
    public GestorProducto(ProductoBD productoBD) {
        this.productoBD = productoBD;
    }

    // Método para crear y almacenar productos
    public void crearYGuardarProductos(String[][] productos) throws SQLException {
        for (String[] datos : productos) {
            String nombre = datos[0];
            String categoria = datos[1];
            double precio = Double.parseDouble(datos[2]);

            // Usamos el selector de fábrica
            ProductoFactory factory = ProductoFactorySelector.getFactory(categoria);
            Producto producto = factory.crearProducto(nombre, precio);

            // Mostrar detalles del producto y almacenarlo en la base de datos
            producto.mostrarDetalle();
            int id = productoBD.guardarProducto(producto, categoria);
            if (id != -1) {
                System.out.println("Producto guardado con ID: " + id + "\n");
            } else {
                System.out.println("Error al guardar el producto.\n");
            }
        }

        
    }
    
}
