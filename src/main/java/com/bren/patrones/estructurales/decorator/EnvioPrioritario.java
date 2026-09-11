package com.bren.patrones.estructurales.decorator;

import java.math.BigDecimal;

public class EnvioPrioritario extends DecoradorPedido {
    private static final BigDecimal COSTO = new BigDecimal("8000");
    public EnvioPrioritario(ServicioPedido servicioPedido) {
        super(servicioPedido);
    }

    @Override
    public BigDecimal calcularCosto() {
        return super.calcularCosto().add(COSTO);
    }

    @Override
    public String obtenerDescripcion() {
        return super.obtenerDescripcion() + " + envio prioritario";
    }
}