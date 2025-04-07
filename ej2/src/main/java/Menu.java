public class Menu {
    private String nombre;
    private float precio;

    public Menu(String nombre, float precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public float getPrecio() {
        return this.precio;
    }
}
