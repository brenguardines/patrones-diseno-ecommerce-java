package com.bren.patrones.comportamiento.strategy;

import com.bren.patrones.ecommerce.Pedido;
import com.bren.patrones.estructurales.adapter.ProcesadorPago;

public class PagoConMercadoPago implements EstrategiaPago {
    private final ProcesadorPago procesadorPago;

    public PagoConMercadoPago(ProcesadorPago procesadorPago) {
        if (procesadorPago == null) {
            throw new IllegalArgumentException(
                    "El procesador de pago no puede ser nulo"
            );
        }

        this.procesadorPago = procesadorPago;
    }

    @Override
    public boolean procesarPago(Pedido pedido) {
        System.out.println("Estrategia seleccionada: Mercado Pago");

        return procesadorPago.procesarPago(pedido);
    }
}
