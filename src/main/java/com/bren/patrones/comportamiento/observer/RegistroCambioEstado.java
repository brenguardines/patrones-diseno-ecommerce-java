package com.bren.patrones.comportamiento.observer;

import com.bren.patrones.ecommerce.Pedido;

public class RegistroCambioEstado implements ObservadorPedido {
    @Override
    public void actualizar(Pedido pedido) {
        System.out.println("Registrando cambio de estado del pedido " + pedido.getId() + ": " + pedido.getEstadoPedido());
    }
}
