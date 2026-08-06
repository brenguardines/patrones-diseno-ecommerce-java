package com.bren.patrones.comportamiento.strategy;

import com.bren.patrones.ecommerce.Pedido;

public interface EstrategiaPago {
    boolean procesarPago(Pedido pedido);
}
