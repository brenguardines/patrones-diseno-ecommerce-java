package com.bren.patrones.estructurales.adapter;

import com.bren.patrones.ecommerce.Pedido;

import java.math.BigDecimal;

public class MercadoPagoAdapter implements ProcesadorPago {

    private final MercadoPagoAPI mercadoPagoAPI;

    public MercadoPagoAdapter(MercadoPagoAPI mercadoPagoAPI) {
        this.mercadoPagoAPI = mercadoPagoAPI;
    }

    @Override
    public boolean procesarPago(Pedido pedido) {
        System.out.println("Adaptando la informacion del pedido para Mercado Pago");

        String referencia = "PED-" + pedido.getId();
        BigDecimal importe = pedido.calcularTotal();

        return mercadoPagoAPI.realizarPago(referencia, importe);
    }
}
