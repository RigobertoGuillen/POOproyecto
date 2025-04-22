package ProyectoTienda;

public abstract class ProductoDecorador extends Producto {

    protected Producto productoOriginal;

    public ProductoDecorador(Producto producto) {
        super(producto.nombre, producto.precio);
        this.productoOriginal = producto;
    }

    @Override
    public abstract void mostrarDetalle();
}
    

