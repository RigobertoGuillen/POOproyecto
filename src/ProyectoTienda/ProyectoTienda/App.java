package ProyectoTienda;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws SQLException{
        
        PedidoFacade facade = new PedidoFacade();
 facade.realizarPedido(
            "Carlos Ramírez",          // nombreCliente
            "carlos89@mail.com",         // correo
            "7777-9999",               // teléfono
            "Colonia Centro",          // dirección
            "Audífonos Bluetooth",     // nombreProducto
            45.99,                     // precio
            "electronico",             // categoría
            "paypal"                   // método de pago
        );
    }

    }
    

       
    



        

        
    
       
           
    

        
       
    
    
    
    

    
    

        
