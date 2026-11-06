package com.bren.patrones.comportamiento.chainofresponsibility;

import com.bren.patrones.ecommerce.Pedido;

public class ValidadorDireccion extends ValidadorPedido{
    @Override
    public boolean validar(Pedido pedido) {
        System.out.println("Validando direccion...");

        if (pedido.getDireccionEnvio() == null || pedido.getDireccionEnvio().isBlank()){
            System.out.println("ERROR: El pedido no tiene una direccion de envio");
            return false;
        }

        System.out.println("Direccion valida");
        return validarSiguiente(pedido);
    }
}