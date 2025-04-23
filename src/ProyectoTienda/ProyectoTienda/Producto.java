package ProyectoTienda;
public abstract class Producto {

    protected int id;
    protected String nombre;
    protected double precio;
    
    
    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

   

    public double getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public abstract void guardarEnBD();

    public abstract void mostrarDetalle();

    public abstract String getTipo();
    
}
