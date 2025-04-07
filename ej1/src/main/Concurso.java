package main;

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
            this.registro.registrar(fechaInscripcion + " " + participante.id() + " " + this.id + "\n");
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

//TP1
//Implemente un sistema de Concursos, donde los participantes pueden inscribirse para participar de
//los mismos. El participante debe poder inscribirse a los concursos. El concurso acepta la
//inscripción solo dentro del rango de fecha de inscripción. El participante gana 10 puntos si se
//inscribe durante el primer día de abierta la inscripción. Dado un participante se puede conocer la
//cantidad de puntos ganados. Si un participante intenta inscribirse fuera de la fecha de inscripción
//se debe informar con un mensaje.
//Luego de implementar escriba los siguientes casos de test:
//1. Un participante se inscribe en un concurso
//2. Un participante se inscribe en un concurso el primer día de abierta la inscripción.
//3. Un participante intenta inscribirse fuera del rango de inscripción.
//Importante: Tener en cuenta el paso del tiempo en aquellos tests que verifican cuestiones
//relacionadas con la fecha.
//Lograr alta cobertura (mayor a 90%).

//TP2
//1) Sobre el ejercicio 1 del trabajo practico 1, se pide que cada vez que se inscriba un participante
//en un concurso se guarde en un archivo de texto, la fecha/hora de inscripción, el id del participante
//y el id del concurso, con el siguiente formato:
//dd/mm/yyyy, id_participante, id_concurso
//dd/mm/yyyy, id_participante, id_concurso
//dd/mm/yyyy, id_participante, id_concurso
//dd/mm/yyyy, id_participante, id_concurso