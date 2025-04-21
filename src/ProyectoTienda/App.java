package ProyectoTienda;

public class App {
    public static void main(String[] args) {

        ProductoFactory factory;

        factory = new ElectronicoFactory();
        Producto laptop = factory.crearProducto("Laptop", 1200.0);
        laptop.mostrarDetalle();

        factory = new RopaFactory();
        Producto p2 = factory.crearProducto("Camiseta", 25.0);
        p2.mostrarDetalle();

        factory = new AccesorioFactory();
        Producto p3 = factory.crearProducto("Reloj", 90.0);
        p3.mostrarDetalle();

        
   
        Producto laptopConDescuento = new ProductoConDescuento(laptop , 0.15);
        Producto laptopConDescuentoYGarantia = new ProductoConGarantia(laptopConDescuento, 2);

        // Mostrar el resultado
        laptopConDescuentoYGarantia.mostrarDetalle();
        System.out.println("Precio final: L" + laptopConDescuentoYGarantia.getPrecio());

       

        
    }
    }
    

    
    

        
