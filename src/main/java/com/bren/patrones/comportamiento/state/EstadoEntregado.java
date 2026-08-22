package com.bren.patrones.comportamiento.state;

import com.bren.patrones.ecommerce.EstadoPedido;

public class EstadoEntregado implements EstadoPedidoState {
    @Override
    public EstadoPedidoState pagar() {
        throw new IllegalStateException("No se puede pagar un pedido entregado");
    }

    @Override
    public EstadoPedidoState enviar() {
        throw new IllegalStateException("No se puede enviar un pedido entregado");
    }

    @Override
    public EstadoPedidoState entregar() {
        throw new IllegalStateException("El pedido ya se encuentra entregado");
    }

    @Override
    public EstadoPedidoState cancelar() {
        throw new IllegalStateException("No se puede cancelar un pedido entregado");
    }

    @Override
    public EstadoPedido getEstado() {
        return EstadoPedido.ENTREGADO;
    }
}
