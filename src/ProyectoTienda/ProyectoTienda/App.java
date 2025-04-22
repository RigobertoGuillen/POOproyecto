package ProyectoTienda;

import java.sql.Connection;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException{


        Connection conn = ConexionDataBase.getInstancia().getConexion();

        // 2. Crear DAOs
        ClienteBD clienteBD = new ClienteBD(conn);
        ProductoBD productoBD = new ProductoBD(conn);
        PedidoBD pedidoBD = new PedidoBD(conn);
        
        GestorProducto gestorProducto = new GestorProducto(productoBD);
        String[][] productos = {
            {"Laptop", "Electronico", "1200.00"},
            {"Camisa", "Ropa", "25.50"},
            {"Reloj", "Accesorio", "75.99"}
        };
        gestorProducto.crearYGuardarProductos(productos);

    }
    }
    
    

    
    

        
