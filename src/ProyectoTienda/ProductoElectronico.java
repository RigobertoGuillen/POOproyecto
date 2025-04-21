package ProyectoTienda;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ProductoElectronico extends Producto{

    private int garantiaMeses;

    public ProductoElectronico(String nombre, double precio, int garantiaMeses) {
        super(nombre, precio);
        this.garantiaMeses = garantiaMeses;
    }

    @Override
    public void mostrarDetalle() {
        System.out.println("Electrónico: " + nombre + " - L" + precio);
    }

    @Override
    public String getTipo(){

        return "Electronico";
    }

    @Override
    public void guardarEnBD() {
        try {
            Connection conn = (Connection) ConexionDataBase.getInstancia();
            String sql = "INSERT INTO producto_electronico (nombre, precio, garantia_meses) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nombre);
            stmt.setDouble(2, precio);
            stmt.setInt(3, garantiaMeses);
            stmt.executeUpdate();
            System.out.println("Producto electrónico guardado.");
        } catch (Exception e) {
            e.printStackTrace();
        }
}
}


    

