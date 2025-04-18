package ProyectoTienda;
public class ElectronicoFactory implements ProductoFactory{

    @Override
    public Producto crearProducto(String nombre, double precio) {
        return new ProductoElectronico(nombre, precio);
    }
}
