package com.bren.patrones.creacionales.factorymethod;

public class CreadorWhatsApp extends CreadorNotificacion {

    @Override
    protected CanalNotificacion crearCanal() {
        return new NotificacionWhatsApp();
    }
}
