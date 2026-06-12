package com.bren.patrones.creacionales.factorymethod;

public class FactoryMethodDemo {
    public static void ejecutar() {
        NotificacionFactory factory = new NotificacionFactory();

        CanalNotificacion canalEmail = factory.crearCanal(TipoNotificacion.EMAIL);
        canalEmail.enviar("bren@email.com", "Tu pedido fue creado correctamente");

        CanalNotificacion canalWhatsApp = factory.crearCanal(TipoNotificacion.WHATSAPP);
        canalWhatsApp.enviar("1234567890", "Tu pedido fue creado correctamente");

        CanalNotificacion canalSms = factory.crearCanal(TipoNotificacion.SMS);
        canalSms.enviar("1234567890", "Tu pedido fue creado correctamente");
    }
}
