package com.bren.patrones.estructurales.adapter;

import java.math.BigDecimal;

public class MercadoPagoAPI {
    public boolean realizarPago(String referencia, BigDecimal importe) {
        System.out.println("--- Mercado Pago ---");
        System.out.println("Procesando pago mediante Mercado Pago");
        System.out.println("Referencia: " + referencia);
        System.out.println("Importe: $" + importe);
        System.out.println("--------------------");

        return importe.compareTo(BigDecimal.ZERO) > 0;
    }
}
