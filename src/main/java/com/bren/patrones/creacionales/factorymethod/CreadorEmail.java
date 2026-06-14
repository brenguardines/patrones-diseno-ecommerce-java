package com.bren.patrones.creacionales.factorymethod;

public class CreadorEmail extends CreadorNotificacion {

    @Override
    protected CanalNotificacion crearCanal() {
        return new NotificacionEmail();
    }
}
