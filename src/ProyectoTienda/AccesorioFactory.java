package ProyectoTienda;
public class AccesorioFactory implements ProductoFactory{

    @Override
    public Producto crearProducto(String nombre, double precio) {
        return new ProductoAccesorio(nombre, precio);
    }   
    
}
