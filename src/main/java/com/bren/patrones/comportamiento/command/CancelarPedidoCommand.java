package com.bren.patrones.comportamiento.command;

import com.bren.patrones.ecommerce.Pedido;

public class CancelarPedidoCommand implements ComandoPedido{
    private final Pedido pedido;

    public CancelarPedidoCommand(Pedido pedido) {
        if (pedido == null){
            throw new IllegalArgumentException("El pedido no puede ser nulo");
        }
        this.pedido = pedido;
    }

    @Override
    public void ejecutar() {
        pedido.cancelar();
    }

    @Override
    public String obtenerDescripcion() {
        return "Cancelar pedido " + pedido.getId();
    }
}
