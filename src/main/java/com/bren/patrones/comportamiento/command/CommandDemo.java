package com.bren.patrones.comportamiento.command;

import com.bren.patrones.creacionales.builder.PedidoBuilder;
import com.bren.patrones.ecommerce.Cliente;
import com.bren.patrones.ecommerce.MetodoDePago;
import com.bren.patrones.ecommerce.Pedido;
import com.bren.patrones.ecommerce.Producto;

import java.math.BigDecimal;

public class CommandDemo {
    public static void ejecutar() {

        Cliente cliente = new Cliente(1L, "Brenda", "bren@email.com");

        Producto notebook = new Producto(1L, "Notebook MacBook", "Notebook para desarrollo", new BigDecimal("1500000"), 10);

        Pedido pedidoCompra = new PedidoBuilder()
                .conId(1L)
                .conCliente(cliente)
                .agregarProducto(notebook)
                .conMetodoDePago(MetodoDePago.MERCADO_PAGO)
                .conDireccionEnvio("Av. Rivadavia 1234")
                .construir();

        Pedido pedidoCancelado = new PedidoBuilder()
                .conId(2L)
                .conCliente(cliente)
                .agregarProducto(notebook)
                .conMetodoDePago(MetodoDePago.MERCADO_PAGO)
                .conDireccionEnvio("Av. Rivadavia 1234")
                .construir();

        GestorComandos gestorComandos = new GestorComandos();

        ComandoPedido pagarPedido = new PagarPedidoCommand(pedidoCompra);
        ComandoPedido enviarPedido = new EnviarPedidoCommand(pedidoCompra);
        ComandoPedido cancelarPedido = new CancelarPedidoCommand(pedidoCancelado);

        System.out.println("Estado inicial pedido 1: " + pedidoCompra.getEstadoPedido());
        gestorComandos.ejecutar(pagarPedido);

        System.out.println("Luego de pagar pedido 1: " + pedidoCompra.getEstadoPedido());
        gestorComandos.ejecutar(enviarPedido);

        System.out.println("Luego de enviar pedido 1: " + pedidoCompra.getEstadoPedido());
        System.out.println();

        System.out.println("Estado inicial pedido 2: " + pedidoCancelado.getEstadoPedido());
        gestorComandos.ejecutar(cancelarPedido);

        System.out.println("Luego de cancelar pedido 2: " + pedidoCancelado.getEstadoPedido());
        System.out.println();

        System.out.println("Historial de comandos:");
        for (String accion : gestorComandos.obtenerHistorial()){
            System.out.println("- " + accion);
        }
    }
}
