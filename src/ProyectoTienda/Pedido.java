package ProyectoTienda;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    
     private String estado;
    private List<Observador> observadores = new ArrayList<>();
    private int id;
    private Cliente cliente;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    private List<Producto> productos;


    public void agregarObservador(Observador obs) {
        observadores.add(obs);
    }

    public void cambiarEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
        notificarObservadores();
    }

    private void notificarObservadores() {
        for (Observador obs : observadores) {
            obs.actualizar("El estado del pedido cambió a: " + estado);
        }
    }

    public String getEstado() {
        return estado;
    }

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto p) {
        productos.add(p);
    }
}
