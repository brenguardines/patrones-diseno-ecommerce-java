package com.bren.patrones.creacionales.factorymethod;

public class FactoryMethodDemo {
    public static void ejecutar() {
        CreadorNotificacion creadorEmail = new CreadorEmail();
        creadorEmail.notificar("bren@email.com", "Tu pedido fue creado correctamente");

        CreadorNotificacion creadorWhatsApp = new CreadorWhatsApp();
        creadorWhatsApp.notificar("1234567890", "Tu pedido fue despachado");

        CreadorNotificacion creadorSms = new CreadorSms();
        creadorSms.notificar("1234567890", "Tu pedido fue entregado");
    }
}
