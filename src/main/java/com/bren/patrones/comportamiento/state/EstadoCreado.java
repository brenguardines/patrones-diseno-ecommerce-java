package com.bren.patrones.comportamiento.state;

import com.bren.patrones.ecommerce.EstadoPedido;

public class EstadoCreado implements EstadoPedidoState {
    @Override
    public EstadoPedidoState pagar() {
        return new EstadoPagado();
    }

    @Override
    public EstadoPedidoState enviar() {
        throw new IllegalStateException("Solo se puede enviar un pedido pagado");
    }

    @Override
    public EstadoPedidoState entregar() {
        throw new IllegalStateException("Solo se puede entregar un pedido enviado");
    }

    @Override
    public EstadoPedidoState cancelar() {
        return new EstadoCancelado();
    }

    @Override
    public EstadoPedido getEstado() {
        return EstadoPedido.CREADO;
    }
}
