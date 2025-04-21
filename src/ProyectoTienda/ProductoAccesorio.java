package ProyectoTienda;
public class ProductoAccesorio extends Producto{

   private String material;

    public ProductoAccesorio(String nombre, double precio, String material) {
        super(nombre, precio);
        this.material = material;
    }

    @Override
    public void mostrarDetalle() {
        System.out.println("Accesorio: " + nombre + " - L" + precio);
    }

    @Override
    public String getTipo() {
        return "accesorio";
    }

    @Override
    public void guardarEnBD() {
        
    }


    
}
