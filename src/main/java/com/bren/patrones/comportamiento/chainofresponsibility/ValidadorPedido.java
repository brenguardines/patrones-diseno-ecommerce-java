package com.bren.patrones.comportamiento.chainofresponsibility;

import com.bren.patrones.ecommerce.Pedido;

public abstract class ValidadorPedido {
    private ValidadorPedido siguiente;

    public void establecerSiguiente(ValidadorPedido siguiente){
        this.siguiente = siguiente;
    }

    protected boolean validarSiguiente(Pedido pedido){
        if (siguiente == null){
            return true;
        }
        return siguiente.validar(pedido);
    }

    public abstract boolean validar(Pedido pedido);
}
