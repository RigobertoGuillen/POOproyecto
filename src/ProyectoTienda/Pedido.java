package ProyectoTienda;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    
     private String estado;
    private List<Observador> observadores = new ArrayList<>();

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
}
