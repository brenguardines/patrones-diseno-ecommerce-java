package com.bren.patrones.comportamiento.command;

public interface ComandoPedido {
    void ejecutar();

    String obtenerDescripcion();
}
