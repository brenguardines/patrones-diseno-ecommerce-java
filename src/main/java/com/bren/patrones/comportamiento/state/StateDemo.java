package com.bren.patrones.comportamiento.state;

import com.bren.patrones.creacionales.builder.PedidoBuilder;
import com.bren.patrones.ecommerce.Cliente;
import com.bren.patrones.ecommerce.MetodoDePago;
import com.bren.patrones.ecommerce.Pedido;
import com.bren.patrones.ecommerce.Producto;

import java.math.BigDecimal;

public class StateDemo {
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

        System.out.println("Estado inicial: " + pedido.getEstadoPedido());

        pedido.pagar();
        System.out.println("Luego de pagar: " + pedido.getEstadoPedido());

        pedido.enviar();
        System.out.println("Luego de enviar: " + pedido.getEstadoPedido());

        pedido.entregar();
        System.out.println("Luego de entregar: " + pedido.getEstadoPedido());
    }
}
