package ejer1.src.test.java;

import ejercicio1.ProveedorFecha;

import java.time.LocalDateTime;

public class FakeProveedorFecha implements ProveedorFecha {
    @Override
    public LocalDateTime fecha() {
        return LocalDateTime.of(2025, 03, 25, 03, 39);
    }

    public LocalDateTime fechaInicio() {
        return LocalDateTime.of(2025, 03, 31, 07, 66);
    }
}