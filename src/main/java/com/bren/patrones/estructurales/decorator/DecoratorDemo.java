package com.bren.patrones.estructurales.decorator;

import com.bren.patrones.creacionales.builder.PedidoBuilder;
import com.bren.patrones.ecommerce.Cliente;
import com.bren.patrones.ecommerce.MetodoDePago;
import com.bren.patrones.ecommerce.Pedido;
import com.bren.patrones.ecommerce.Producto;

import java.math.BigDecimal;

public class DecoratorDemo {
    public static void ejecutar() {
        Cliente cliente = new Cliente(1L, "Brenda", "bren@email.com");
        Producto producto = new Producto(1L, "Notebook MacBook", "Notebook para desarrollo", new BigDecimal("1500000"), 10);
        Pedido pedido = new PedidoBuilder()
                .conId(1L)
                .conCliente(cliente)
                .agregarProducto(producto)
                .conMetodoDePago(MetodoDePago.MERCADO_PAGO)
                .conDireccionEnvio("Av. Rivadavia 1234")
                .construir();

        ServicioPedido servicioPedido = new PedidoBase(pedido);

        System.out.println("Pedido base: " + servicioPedido.obtenerDescripcion());
        System.out.println("Costo base: $" + servicioPedido.calcularCosto());

        servicioPedido = new EnvoltorioRegalo(servicioPedido);
        servicioPedido = new SeguroEnvio(servicioPedido);
        servicioPedido = new EnvioPrioritario(servicioPedido);

        System.out.println();
        System.out.println("Descripcion final: " + servicioPedido.obtenerDescripcion());
        System.out.println("Costo final: $" + servicioPedido.calcularCosto());

    }
}
