package com.bren.patrones.creacionales.factorymethod;

public class NotificacionEmail implements CanalNotificacion {
    @Override
    public void enviar(String destinatario, String mensaje) {
        System.out.println("Enviando email a " + destinatario + ": " + mensaje);
    }
}
