package ProyectoTienda;

import java.sql.Connection;
import java.sql.SQLDataException;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLDataException{

      /*  PedidoFacade pedidoFacade = new PedidoFacade();

        pedidoFacade.realizarPedido(
            "Carlos Ramírez Sosa",          // nombreCliente
            "carlos55@mail.com",         // correo
            "7777-9999",               // teléfono
            "Colonia Centro",          // dirección
            "Audífonos Bluetooth",     // nombreProducto
            45.99,                     // precio
            "electronico",             // categoría
            "paypal"                   // método de pago
        );*/

        ConexionDataBase conexionDB = ConexionDataBase.getInstancia();
        Connection conn = conexionDB.getConexion();

        // Paso 2: Crear instancia de ProductoBD con la conexión
        ProductoBD productoBD = new ProductoBD(conn);

        // Paso 3: Crear instancia de GestorProducto con la BD
        GestorProducto gestorProducto = new GestorProducto();
        gestorProducto.setProductoBD(productoBD); // necesitas este setter o usar constructor

        // Paso 4: Definir productos para guardar
        String[][] productos = {
            {"Laptop HP", "electronico", "1200.50"},
            {"Camiseta Nike", "ropa", "29.99"},
            {"Reloj Casio", "accesorio", "89.90"}
        };

        // Paso 5: Guardarlos en la BD
        try {
            gestorProducto.crearYGuardarProductos(productos);
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
    }
    }
    
    

    
    

        
