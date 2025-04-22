package ProyectoTienda;

public class ProductoRopa extends Producto {
    private String talla;

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public ProductoRopa(String nombre, double precio, String talla) {
        super(nombre, precio);
        this.talla = talla;
    }

    @Override
    public void mostrarDetalle() {
        System.out.println("Ropa: " + nombre + " - L" + precio);
    }

    @Override
    public String getTipo() {
        return "ropa";
    }

    @Override
    public void guardarEnBD() {
        
    }
}