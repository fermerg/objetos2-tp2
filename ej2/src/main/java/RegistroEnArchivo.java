import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class RegistroEnArchivo implements GestorDeRegistro {

    File archivo;

    public RegistroEnArchivo(String rutaArchivo) {
        this.archivo = new File(rutaArchivo);
    }

    @Override
    public void registrar(String datos) {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(archivo, true))) {
            escritor.append(datos);
        } catch (IOException e) {
            throw new RuntimeException("Error al escribir datos en el archivo", e);
        }
    }
}
