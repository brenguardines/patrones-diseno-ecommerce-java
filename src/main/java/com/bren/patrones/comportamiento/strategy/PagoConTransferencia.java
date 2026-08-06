package com.bren.patrones.comportamiento.strategy;

import com.bren.patrones.ecommerce.Pedido;

import java.math.BigDecimal;

public class PagoConTransferencia implements EstrategiaPago {
    @Override
    public boolean procesarPago(Pedido pedido) {
        BigDecimal importe = pedido.calcularTotal();

        System.out.println("Estrategia seleccionada: Transferencia");
        System.out.println("Generando los datos para la transferencia");
        System.out.println("Referencia: TRANSF-PED-" + pedido.getId());
        System.out.println("Importe: $" + importe);

        return importe.compareTo(BigDecimal.ZERO) > 0;
    }
}
