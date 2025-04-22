package ProyectoTienda;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDataBase {
    private static ConexionDataBase instancia;
    private Connection conexion;
    private final String url = "jdbc:postgresql://localhost:5432/Tienda";
    private final String usuario = "postgres";
    private final String contraseña = "admin";

    private ConexionDataBase() {
        try {
            conexion = DriverManager.getConnection(url, usuario, contraseña);
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }

    // Método para obtener la instancia única
    public static ConexionDataBase getInstancia() {
        if (instancia == null) {
            instancia = new ConexionDataBase();
        }
        return instancia;
    }

    // Método para obtener la conexión
    public Connection getConexion() {
        return conexion;
    }
}


    



