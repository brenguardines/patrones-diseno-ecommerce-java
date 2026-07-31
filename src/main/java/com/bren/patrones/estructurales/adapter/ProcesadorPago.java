package com.bren.patrones.estructurales.adapter;

import com.bren.patrones.ecommerce.Pedido;

public interface ProcesadorPago {
    boolean procesarPago(Pedido pedido);
}
