package com.bren.patrones.comportamiento.state;

import com.bren.patrones.ecommerce.EstadoPedido;

public class EstadoEnviado implements EstadoPedidoState {
    @Override
    public EstadoPedidoState pagar() {
        throw new IllegalStateException("No se puede pagar un pedido enviado");
    }

    @Override
    public EstadoPedidoState enviar() {
        throw new IllegalStateException("El pedido ya se encuentra enviado");
    }

    @Override
    public EstadoPedidoState entregar() {
        return new EstadoEntregado();
    }

    @Override
    public EstadoPedidoState cancelar() {
        return new EstadoCancelado();
    }

    @Override
    public EstadoPedido getEstado() {
        return EstadoPedido.ENVIADO;
    }
}
