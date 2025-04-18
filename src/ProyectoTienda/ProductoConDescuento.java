package ProyectoTienda;
public class ProductoConDescuento extends ProductoDecorador{

    private double porcentajeDescuento;

    public ProductoConDescuento(Producto producto, double porcentajeDescuento) {
        super(producto);
        this.porcentajeDescuento = porcentajeDescuento;
    }

    @Override
    public void mostrarDetalle() {
        double precioFinal = productoOriginal.getPrecio() * (1 - porcentajeDescuento);
        System.out.println(productoOriginal.nombre + " con " + (porcentajeDescuento * 100) + "% de descuento - L" + precioFinal);
    }

    @Override
    public double getPrecio() {
        return productoOriginal.getPrecio() * (1 - porcentajeDescuento);
    }
    
}
