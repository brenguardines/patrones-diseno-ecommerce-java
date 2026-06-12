package com.bren.patrones.creacionales.factorymethod;

public class NotificacionWhatsApp implements CanalNotificacion {
    @Override
    public void enviar(String destinatario, String mensaje) {
        System.out.println("Enviando WhatsApp a " + destinatario + ": " + mensaje);
    }
}
