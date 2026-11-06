package com.bren.patrones.comportamiento.chainofresponsibility;

import com.bren.patrones.ecommerce.Pedido;

public class ValidadorProductos extends ValidadorPedido{
    @Override
    public boolean validar(Pedido pedido) {
        System.out.println("Validando productos...");

        if (pedido.getProductos().isEmpty()){
            System.out.println("ERROR: El pedido no tiene productos");
            return false;
        }

        System.out.println("Productos validos");
        return validarSiguiente(pedido);
    }
}