package com.bren.patrones.comportamiento.chainofresponsibility;

import com.bren.patrones.ecommerce.Pedido;

public class ValidadorMetodoDePago extends ValidadorPedido{
    @Override
    public boolean validar(Pedido pedido) {
        System.out.println("Validando metodo de pago...");

        if (pedido.getMetodoDePago() == null){
            System.out.println("ERROR: El pedido no tiene un metodo de pago");
            return false;
        }

        System.out.println("Metodo de pago valido");
        return validarSiguiente(pedido);
    }
}