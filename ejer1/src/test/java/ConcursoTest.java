package ejer1.src.test.java;


import ejer1.src.main.java.ejercicio1.Concurso;
import ejer1.src.main.java.ejercicio1.Participante;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ConcursoTest {
    Concurso concursoAjedrez;
    Participante fer;
    Participante agus;
    FakeRegistroArchivo archivo;
    LocalDate fechaInicio;
    LocalDate fechaFin;
    LocalDate fechaPrueba;


    @BeforeEach
    public void inicializar() {
        archivo = new FakeRegistroArchivo();
        fechaInicio = LocalDate.now().minusDays(10);
        fechaFin = LocalDate.now().plusDays(20);
        concursoAjedrez = new Concurso("Ajedrez", 1, fechaInicio, fechaFin, archivo);
        fer = new Participante("Fer", "Merg", 34);
        agus = new Participante("Agus", "Currilefo", 45);
        fechaPrueba = LocalDate.of(2025, 04, 07);

    }

    @Test
    public void inscripcionEnTermino() {
        concursoAjedrez.inscribirParticipante(fer, LocalDate.now());
        assertTrue(concursoAjedrez.estaInscripto(fer));
    }

    @Test
    public void inscripcionFueraDeTermino() {
        concursoAjedrez.inscribirParticipante(fer, LocalDate.now().plusDays(30));
        assertFalse(concursoAjedrez.estaInscripto(fer));
    }

    @Test
    public void inscripcionPrimerDia() {
        concursoAjedrez.inscribirParticipante(fer, LocalDate.now().minusDays(10));
        assertEquals(10, fer.cantidadPuntos());
    }

    @Test
    public void registroCorrecto() {


        concursoAjedrez.inscribirParticipante(fer, fechaPrueba);
        concursoAjedrez.inscribirParticipante(agus, fechaPrueba);
        assertEquals("[2025-04-07,34,1\n" +
                ", 2025-04-07,45,1\n" +
                "]", archivo.datos());
    }
}

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
