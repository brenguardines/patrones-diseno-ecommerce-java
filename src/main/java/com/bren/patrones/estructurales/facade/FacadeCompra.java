package com.bren.patrones.estructurales.facade;

import com.bren.patrones.comportamiento.strategy.ContextoPago;
import com.bren.patrones.ecommerce.Pedido;

public class FacadeCompra {
    private final ContextoPago contextoPago;

    public FacadeCompra(ContextoPago contextoPago){
        if (contextoPago == null){
            throw new IllegalArgumentException("El contexto de pago no puede ser nulo");
        }
        this.contextoPago = contextoPago;
    }

    public boolean procesarCompra(Pedido pedido){
        if (pedido == null){
            throw new IllegalArgumentException("El pedido no puede ser nulo");
        }

        boolean pagoExitoso = contextoPago.procesarPago(pedido);

        if (pagoExitoso) { pedido.pagar();}

        return pagoExitoso;
    }
}
