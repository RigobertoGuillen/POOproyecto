package ProyectoTienda;
public class ProductoElectronico extends Producto{

    private int garantiaMeses;

    public ProductoElectronico(String nombre, double precio, int garantiaMeses) {
        super(nombre, precio);
        this.garantiaMeses = garantiaMeses;
    }

    @Override
    public void mostrarDetalle() {
        System.out.println("Electrónico: " + nombre + " - L" + precio);
    }

    @Override
    public String getTipo(){

        return "Electronico";
    }
}


    

