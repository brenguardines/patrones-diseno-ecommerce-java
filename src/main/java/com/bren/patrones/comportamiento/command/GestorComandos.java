package com.bren.patrones.comportamiento.command;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GestorComandos {
    private final List<String> historial =new ArrayList<>();

    public void ejecutar(ComandoPedido comando){
        if (comando == null){
            throw new IllegalArgumentException("El comando no puede ser nulo");
        }

        comando.ejecutar();
        historial.add(comando.obtenerDescripcion());
    }

    public List<String> obtenerHistorial(){
        return Collections.unmodifiableList(historial);
    }
}
