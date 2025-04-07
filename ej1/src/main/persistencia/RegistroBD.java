package main.persistencia;

import main.ConexionBD;
import main.GestorDeRegistros;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

public class RegistroBD implements GestorDeRegistros {
    Connection conexion = ConexionBD.obtenerConexion();


    @Override
    public void registrar(String datos) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String sql = "INSERT INTO inscripcion (fecha_inscripcion, id_participante, id_concurso) VALUES (?, ?, ?)";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            String[] registro = datos.split(",");
            statement.setString(1, registro[0].trim()); // Fecha de inscripción
            statement.setString(2, registro[1].trim()); // ID del participante
            statement.setString(3, registro[2].trim()); //nombre concurso
            statement.addBatch();
            statement.executeBatch();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            conexion.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
