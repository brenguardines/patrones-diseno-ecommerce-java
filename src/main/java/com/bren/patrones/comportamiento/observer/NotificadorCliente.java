package com.bren.patrones.comportamiento.observer;

import com.bren.patrones.ecommerce.Pedido;

public class NotificadorCliente implements ObservadorPedido {
    @Override
    public void actualizar(Pedido pedido) {
        System.out.println("Notificando a " + pedido.getCliente().getNombre() + ": el pedido " + pedido.getId() + " ahora se encuentra " + pedido.getEstadoPedido());
    }
}
