package com.bren.patrones.comportamiento.state;

import com.bren.patrones.ecommerce.EstadoPedido;

public class EstadoPagado implements EstadoPedidoState {
    @Override
    public EstadoPedidoState pagar() {
        throw new IllegalStateException("El pedido ya se encuentra pagado");
    }

    @Override
    public EstadoPedidoState enviar() {
        return new EstadoEnviado();
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
        return EstadoPedido.PAGADO;
    }
}
