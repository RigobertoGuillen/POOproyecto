package ProyectoTienda;
public class ProductoConGarantia extends ProductoDecorador{

    private int años;

    public ProductoConGarantia(Producto producto, int años) {
        super(producto);
        this.años = años;
    }

    @Override
    public void mostrarDetalle() {
        productoOriginal.mostrarDetalle();
        System.out.println("Incluye garantía de " + años + " años.");
    }
    
}
