package ejer1.src.test.java;

import ejer1.src.main.java.ejercicio1.GestorDeRegistros;

import java.util.ArrayList;
import java.util.List;

public class FakeRegistroArchivo implements GestorDeRegistros {

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
