package com.bren.patrones.estructurales.decorator;

import com.bren.patrones.ecommerce.Pedido;

import java.math.BigDecimal;

public class PedidoBase implements ServicioPedido {
    private final Pedido pedido;

    public PedidoBase(Pedido pedido) {
        if (pedido == null) {
            throw new IllegalArgumentException("El pedido no puede ser nulo");
        }
        this.pedido = pedido;
    }
    @Override
    public BigDecimal calcularCosto() {
        return pedido.calcularTotal();
    }

    @Override
    public String obtenerDescripcion() {
        return "Pedido " + pedido.getId();
    }
}
