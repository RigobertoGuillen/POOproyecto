package ProyectoTienda;
public class ProductoElectronico extends Producto{

    public ProductoElectronico(String nombre, double precio) {
        super(nombre, precio);
    }

    @Override
    public void mostrarDetalle() {
        System.out.println("Electrónico: " + nombre + " - L" + precio);
    }
}


    

