package test;

import main.GestorDeRegistros;

import java.util.ArrayList;
import java.util.List;

public class RegistroArchivoTextoFake implements GestorDeRegistros {

    private List<String> datos = new ArrayList<>();
    ;

    @Override
    public void registrar(String datos) {
        this.datos.add(datos);
    }

    public String datos() {
        return this.datos.toString();
    }

}
