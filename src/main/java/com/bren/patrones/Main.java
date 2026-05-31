package com.bren.patrones;

import com.bren.patrones.ecommerce.Cliente;
import com.bren.patrones.ecommerce.MetodoDePago;
import com.bren.patrones.ecommerce.Pedido;
import com.bren.patrones.ecommerce.Producto;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente(1L, "Brenda", "brenda@email.com");
        Producto producto = new Producto(
                1L,
                "Notebook Macbook",
                "Notebook para desarrollo backend",
                new BigDecimal("1200000"),
                10
        );

        Pedido pedido = new Pedido(1L, cliente, MetodoDePago.MERCADO_PAGO);
        pedido.agregarProducto(producto);
        System.out.println(pedido);
    }
}