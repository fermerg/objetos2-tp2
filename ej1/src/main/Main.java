package main;

import main.persistencia.RegistroArchivoTexto;
import main.persistencia.RegistroBD;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        RegistroArchivoTexto registroArchivo = new RegistroArchivoTexto("C:\\Users\\fm\\Desktop\\participantes.txt");
        RegistroBD registroBD = new RegistroBD();
        Concurso concursoAjedrez = new Concurso("Tenis", 1, LocalDate.now().minusDays(5), LocalDate.now().plusDays(10), registroBD);
        Participante fer = new Participante("Fernanda", "Merg", 34);
        Participante agus = new Participante("Agustin", "Currilefo", 45);

        concursoAjedrez.inscribirParticipante(agus, LocalDate.now());
        concursoAjedrez.inscribirParticipante(fer, LocalDate.now());
    }
}
