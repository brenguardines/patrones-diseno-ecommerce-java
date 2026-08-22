package com.bren.patrones.comportamiento.state;

import com.bren.patrones.ecommerce.EstadoPedido;

public class EstadoCancelado implements EstadoPedidoState {
    @Override
    public EstadoPedidoState pagar() {
        throw new IllegalStateException("No se puede pagar un pedido cancelado");
    }

    @Override
    public EstadoPedidoState enviar() {
        throw new IllegalStateException("No se puede enviar un pedido cancelado");
    }

    @Override
    public EstadoPedidoState entregar() {
        throw new IllegalStateException("No se puede entregar un pedido cancelado");
    }

    @Override
    public EstadoPedidoState cancelar() {
        throw new IllegalStateException("El pedido ya se encuentra cancelado");
    }

    @Override
    public EstadoPedido getEstado() {
        return EstadoPedido.CANCELADO;
    }
}