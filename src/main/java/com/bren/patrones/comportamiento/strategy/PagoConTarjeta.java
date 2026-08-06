package com.bren.patrones.comportamiento.strategy;

import com.bren.patrones.ecommerce.Pedido;

import java.math.BigDecimal;

public class PagoConTarjeta implements EstrategiaPago {
    @Override
    public boolean procesarPago(Pedido pedido) {
        BigDecimal importe = pedido.calcularTotal();

        System.out.println("Estrategia seleccionada: Tarjeta");
        System.out.println("Procesando pago con tarjeta");
        System.out.println("Importe: $" + importe);

        return importe.compareTo(BigDecimal.ZERO) > 0;
    }
}
