package com.bren.patrones.estructurales.decorator;

import java.math.BigDecimal;

public abstract class DecoradorPedido implements ServicioPedido {
    protected final ServicioPedido servicioPedido;

    protected DecoradorPedido(ServicioPedido servicioPedido) {
        if (servicioPedido == null) {
            throw new IllegalArgumentException("El servicio del pedido no puede ser nulo");
        }
        this.servicioPedido = servicioPedido;
    }

    @Override
    public BigDecimal calcularCosto() {
        return servicioPedido.calcularCosto();
    }

    @Override
    public String obtenerDescripcion() {
        return servicioPedido.obtenerDescripcion();
    }
}
