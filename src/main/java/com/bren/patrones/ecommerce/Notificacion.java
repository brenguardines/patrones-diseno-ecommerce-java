package com.bren.patrones.ecommerce;

import java.time.LocalDateTime;

public class Notificacion {
    private String destinatario;
    private String mensaje;
    private LocalDateTime fechaCreacion;

    public Notificacion(String destinatario, String mensaje) {
        this.destinatario = destinatario;
        this.mensaje = mensaje;
        this.fechaCreacion = LocalDateTime.now();
    }

    public String getDestinatario() {
        return destinatario;
    }

    public String getMensaje() {
        return mensaje;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void enviar() {
        System.out.println("Enviando notificacion a " + destinatario + ": " + mensaje);
    }

    @Override
    public String toString() {
        return "Notificacion{" +
                "destinatario='" + destinatario + '\'' +
                ", mensaje='" + mensaje + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                '}';
    }
}
