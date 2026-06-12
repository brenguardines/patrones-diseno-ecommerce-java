package com.bren.patrones.creacionales.factorymethod;

public class NotificacionSms implements CanalNotificacion {
    @Override
    public void enviar(String destinatario, String mensaje) {
        System.out.println("Enviando SMS a " + destinatario + ": " + mensaje);
    }
}
