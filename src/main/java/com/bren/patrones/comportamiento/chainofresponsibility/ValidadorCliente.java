package com.bren.patrones.comportamiento.chainofresponsibility;

import com.bren.patrones.ecommerce.Pedido;

public class ValidadorCliente extends ValidadorPedido{
    @Override
    public boolean validar(Pedido pedido) {
        System.out.println("Validando cliente...");

        if (pedido.getCliente() == null){
            System.out.println("ERROR: El pedido no tiene un cliente asociado");
            return false;
        }

        System.out.println("Cliente valido");
        return validarSiguiente(pedido);
    }
}
