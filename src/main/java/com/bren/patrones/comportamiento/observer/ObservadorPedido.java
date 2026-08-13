package com.bren.patrones.comportamiento.observer;

import com.bren.patrones.ecommerce.Pedido;

public interface ObservadorPedido {
    void actualizar(Pedido pedido);
}
