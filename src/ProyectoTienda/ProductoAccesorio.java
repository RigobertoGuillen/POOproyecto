package ProyectoTienda;
public class ProductoAccesorio extends Producto{

    public ProductoAccesorio(String nombre, double precio) {
        super(nombre, precio);
    }

    @Override
    public void mostrarDetalle() {
        System.out.println("Accesorio: " + nombre + " - L" + precio);
    }
    
}
