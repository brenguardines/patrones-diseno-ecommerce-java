package com.bren.patrones.comportamiento.strategy;

import com.bren.patrones.ecommerce.Pedido;

public class ContextoPago {
    private EstrategiaPago estrategiaPago;

    public ContextoPago(EstrategiaPago estrategiaPago) {
        validarEstrategia(estrategiaPago);
        this.estrategiaPago = estrategiaPago;
    }

    public void cambiarEstrategia(EstrategiaPago estrategiaPago) {
        validarEstrategia(estrategiaPago);
        this.estrategiaPago = estrategiaPago;
    }

    public boolean procesarPago(Pedido pedido) {
        if (pedido == null) {
            throw new IllegalArgumentException("El pedido no puede ser nulo");
        }

        return estrategiaPago.procesarPago(pedido);
    }

    private void validarEstrategia(EstrategiaPago estrategiaPago) {
        if (estrategiaPago == null) {
            throw new IllegalArgumentException("La estrategia de pago no puede ser nula");
        }
    }
}
