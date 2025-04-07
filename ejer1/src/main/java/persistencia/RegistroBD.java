package ejer1.src.main.java.persistencia;

import ejer1.src.main.java.ejercicio1.ConexionBD;
import ejer1.src.main.java.ejercicio1.GestorDeRegistros;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

public class RegistroBD implements GestorDeRegistros {

    @Override
    public void registrar(String datos) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement statement = conexion.prepareStatement("INSERT INTO inscripcion (fecha_inscripcion, id_participante, id_concurso) VALUES (?, ?, ?)")) {

            String[] registro = datos.split(",");
            statement.setString(1, registro[0].trim()); // Fecha de inscripción
            statement.setString(2, registro[1].trim()); // ID del participante
            statement.setString(3, registro[2].trim()); //nombre concurso

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
