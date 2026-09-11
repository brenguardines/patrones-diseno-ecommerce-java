package com.bren.patrones.estructurales.decorator;

import java.math.BigDecimal;

public class SeguroEnvio extends DecoradorPedido {
    private static final BigDecimal COSTO = new BigDecimal("5000");
    public SeguroEnvio(ServicioPedido servicioPedido) {
        super(servicioPedido);
    }

    @Override
    public BigDecimal calcularCosto() {
        return super.calcularCosto().add(COSTO);
    }

    @Override
    public String obtenerDescripcion() {
        return super.obtenerDescripcion() + " + seguro de envio";
    }
}
