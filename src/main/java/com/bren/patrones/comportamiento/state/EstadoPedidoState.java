package com.bren.patrones.comportamiento.state;

import com.bren.patrones.ecommerce.EstadoPedido;

public interface EstadoPedidoState {
    EstadoPedidoState pagar();
    EstadoPedidoState enviar();
    EstadoPedidoState entregar();
    EstadoPedidoState cancelar();
    EstadoPedido getEstado();
}
