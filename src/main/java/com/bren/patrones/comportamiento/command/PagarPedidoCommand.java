package com.bren.patrones.comportamiento.command;

import com.bren.patrones.ecommerce.Pedido;

public class PagarPedidoCommand implements ComandoPedido{
    private final Pedido pedido;

    public PagarPedidoCommand(Pedido pedido) {
        if (pedido == null){
            throw new IllegalArgumentException("El pedido no puede ser nulo");
        }
        this.pedido = pedido;
    }

    @Override
    public void ejecutar() {
        pedido.pagar();
    }

    @Override
    public String obtenerDescripcion() {
        return "Pagar pedido " + pedido.getId();
    }
}
