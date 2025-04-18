package ProyectoTienda;
public abstract class Producto {

    protected String nombre;
    protected double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public abstract void mostrarDetalle();

    public double getPrecio() {
        return precio;
    }
    
}
