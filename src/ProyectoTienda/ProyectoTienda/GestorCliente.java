package ProyectoTienda;

import java.sql.Connection;
import java.sql.SQLException;

    public class GestorCliente {
    public Cliente registrarCliente(String nombre, String correo, String telefono, String direccion, Connection conn) throws SQLException {
        Cliente cliente = new Cliente(nombre, correo, telefono, direccion);
        ClienteBD clienteDAO = new ClienteBD(conn);
        int id = clienteDAO.guardarCliente(cliente);
        cliente.setId(id);
        return cliente;
    }
    
}
