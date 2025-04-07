package ejer1.src.main.java.ejercicio1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Concurso {
    private String nombre;
    private Integer id;
    private List<Participante> participantes;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private LocalDate fechaInscripcion;
    private GestorDeRegistros registro;


    public Concurso(String nombre, int id, LocalDate fechaInicio, LocalDate fechaFin, GestorDeRegistros registro) {
        this.nombre = nombre;
        this.id = id;
        this.participantes = new ArrayList<>();
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.registro = registro;
    }

    public void inscribirParticipante(Participante participante, LocalDate fechaInscripcion) {
        if (inscripcionEstaAbierta(fechaInscripcion)) {
            this.fechaInscripcion = fechaInscripcion;
            this.participantes.add(participante);
            this.registro.registrar(fechaInscripcion.toString() + "," + participante.id() + "," + this.id + "\n");
        }
        if (inscripcionPrimerDia(fechaInscripcion)) {
            participante.sumar10puntos();
        }
    }

    private boolean inscripcionEstaAbierta(LocalDate fechaInscripcion) {
        return (((this.fechaInicio().isBefore(fechaInscripcion)) || (this.fechaInicio().isEqual(fechaInscripcion)))
                && (this.fechaFin().isAfter(fechaInscripcion)));
    }

    private boolean inscripcionPrimerDia(LocalDate fechaInscripcion) {
        return this.fechaInicio().isEqual(fechaInscripcion);
    }

    public boolean estaInscripto(Participante participante) {
        return this.participantes.contains(participante);
    }

    public LocalDate fechaInicio() {
        return this.fechaInicio;
    }

    public LocalDate fechaFin() {
        return this.fechaFin;
    }
}
