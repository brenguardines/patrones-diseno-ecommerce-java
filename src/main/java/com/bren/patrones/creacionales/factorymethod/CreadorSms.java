package com.bren.patrones.creacionales.factorymethod;

public class CreadorSms extends CreadorNotificacion {

    @Override
    protected CanalNotificacion crearCanal() {
        return new NotificacionSms();
    }
}
