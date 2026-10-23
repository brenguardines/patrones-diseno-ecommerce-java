package com.bren.patrones.comportamiento.command;

import com.bren.patrones.ecommerce.Pedido;

public class EnviarPedidoCommand implements ComandoPedido{
    private final Pedido pedido;

    public EnviarPedidoCommand(Pedido pedido) {
        if (pedido == null){
            throw new IllegalArgumentException("El pedido no puede ser nulo");
        }
        this.pedido = pedido;
    }

    @Override
    public void ejecutar() {
        pedido.enviar();
    }

    @Override
    public String obtenerDescripcion() {
        return "Enviar pedido " + pedido.getId();
    }
}
