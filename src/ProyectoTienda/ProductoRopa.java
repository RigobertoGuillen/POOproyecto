package ProyectoTienda;
public class ProductoRopa extends Producto {
    public ProductoRopa(String nombre, double precio) {
        super(nombre, precio);
    }

    @Override
    public void mostrarDetalle() {
        System.out.println("Ropa: " + nombre + " - L" + precio);
    }
}