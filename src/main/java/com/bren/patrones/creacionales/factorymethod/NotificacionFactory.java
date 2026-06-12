package com.bren.patrones.creacionales.factorymethod;

public class NotificacionFactory {
    public CanalNotificacion crearCanal(TipoNotificacion tipoNotificacion) {
        return switch (tipoNotificacion) {
            case EMAIL -> new NotificacionEmail();
            case WHATSAPP -> new NotificacionWhatsApp();
            case SMS -> new NotificacionSms();
        };
    }
}
