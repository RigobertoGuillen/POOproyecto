package ProyectoTienda;
public class RopaFactory implements ProductoFactory{

    @Override
    public Producto crearProducto(String nombre, double precio) {
        return new ProductoRopa(nombre, precio, null);
    }
    
}
