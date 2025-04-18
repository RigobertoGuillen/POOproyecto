package ProyectoTienda;
public interface ProductoFactory {
    
    Producto crearProducto(String nombre, double precio);
}
