package ProyectoTienda;

public class ProductoFactorySelector {
    
    public static ProductoFactory getFactory(String categoria) {
        switch (categoria.toLowerCase()) {
            case "electronico":
                return new ElectronicoFactory();
            case "ropa":
                return new RopaFactory();
            case "accesorio":
                return new AccesorioFactory();
            default:
                throw new IllegalArgumentException("Categoría no válida: " + categoria);
        }
    }
}
