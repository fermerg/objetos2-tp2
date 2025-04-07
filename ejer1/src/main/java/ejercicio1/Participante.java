package ejer1.src.main.java.ejercicio1;

public class Participante {
    private String nombre;
    private String apellido;
    private Integer id;
    private int puntos;


    public Participante(String nombre, String apellido, Integer id) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
    }

    public int cantidadPuntos() {
        return this.puntos;
    }

    public void sumar10puntos() {
        this.puntos += 10;
    }

    public Integer id() {
        return this.id;
    }
}
