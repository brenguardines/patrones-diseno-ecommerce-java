package com.bren.patrones.comportamiento.observer;

import com.bren.patrones.creacionales.builder.PedidoBuilder;
import com.bren.patrones.ecommerce.Cliente;
import com.bren.patrones.ecommerce.MetodoDePago;
import com.bren.patrones.ecommerce.Pedido;
import com.bren.patrones.ecommerce.Producto;

import java.math.BigDecimal;

public class ObserverDemo {
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

        ObservadorPedido notificadorCliente = new NotificadorCliente();
        ObservadorPedido registroCambioEstado = new RegistroCambioEstado();

        pedido.agregarObservador(notificadorCliente);
        pedido.agregarObservador(registroCambioEstado);

        pedido.pagar();
        pedido.enviar();
        pedido.entregar();
    }
}
