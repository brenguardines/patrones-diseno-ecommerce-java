package com.bren.patrones.estructurales.adapter;

import com.bren.patrones.creacionales.builder.PedidoBuilder;
import com.bren.patrones.ecommerce.Cliente;
import com.bren.patrones.ecommerce.MetodoDePago;
import com.bren.patrones.ecommerce.Pedido;
import com.bren.patrones.ecommerce.Producto;

import java.math.BigDecimal;

public class AdapterDemo {
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

        MercadoPagoAPI mercadoPagoAPI = new MercadoPagoAPI();
        ProcesadorPago procesadorPago = new MercadoPagoAdapter(mercadoPagoAPI);

        boolean pagoExitoso = procesadorPago.procesarPago(pedido);
        if (pagoExitoso) {
            pedido.pagar();
        }
        System.out.println("Pago exitoso: " + pagoExitoso);
        System.out.println("Estado del pedido: " + pedido.getEstadoPedido());
    }
}
