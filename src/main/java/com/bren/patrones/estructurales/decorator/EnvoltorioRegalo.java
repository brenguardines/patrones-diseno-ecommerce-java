package com.bren.patrones.estructurales.decorator;

import java.math.BigDecimal;

public class EnvoltorioRegalo extends DecoradorPedido {
    private static final BigDecimal COSTO = new BigDecimal("2000");
    public EnvoltorioRegalo(ServicioPedido servicioPedido) {
        super(servicioPedido);
    }

    @Override
    public BigDecimal calcularCosto() {
        return super.calcularCosto().add(COSTO);
    }

    @Override
    public String obtenerDescripcion() {
        return super.obtenerDescripcion() + " + envoltorio para regalo";
    }
}
