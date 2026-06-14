package com.bren.patrones.creacionales.factorymethod;

public abstract class CreadorNotificacion {
    public void notificar(String destinatario, String mensaje) {
        CanalNotificacion canal = crearCanal();
        canal.enviar(destinatario, mensaje);
    }

    protected abstract CanalNotificacion crearCanal();
}
