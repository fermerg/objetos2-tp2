package ejer1.src.main.java.ejercicio1;

import ejer1.src.main.java.persistencia.RegistroArchivo;
import ejer1.src.main.java.persistencia.RegistroBD;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        RegistroArchivo registroArchivo = new RegistroArchivo("C:\\Users\\fm\\Desktop\\participantes.txt");
        RegistroBD registroBD = new RegistroBD();
        LocalDate fechaInicio = LocalDate.now().minusDays(5);
        LocalDate fechaFin = LocalDate.now().plusDays(10);
        Concurso concursoAjedrez = new Concurso("Tenis", 1, fechaInicio, fechaFin, registroBD);
        Participante fer = new Participante("Fernanda", "Merg", 34);
        Participante agus = new Participante("Agustin", "Currilefo", 45);

        concursoAjedrez.inscribirParticipante(agus, LocalDate.now());
        concursoAjedrez.inscribirParticipante(fer, LocalDate.now());
    }
}
