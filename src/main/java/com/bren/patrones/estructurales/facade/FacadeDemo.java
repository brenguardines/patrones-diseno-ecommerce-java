package com.bren.patrones.estructurales.facade;

import com.bren.patrones.comportamiento.strategy.ContextoPago;
import com.bren.patrones.comportamiento.strategy.PagoConMercadoPago;
import com.bren.patrones.creacionales.builder.PedidoBuilder;
import com.bren.patrones.ecommerce.Cliente;
import com.bren.patrones.ecommerce.MetodoDePago;
import com.bren.patrones.ecommerce.Pedido;
import com.bren.patrones.ecommerce.Producto;
import com.bren.patrones.estructurales.adapter.MercadoPagoAPI;
import com.bren.patrones.estructurales.adapter.MercadoPagoAdapter;
import com.bren.patrones.estructurales.adapter.ProcesadorPago;

import java.math.BigDecimal;

public class FacadeDemo {

    public static void ejecutar() {

        Cliente cliente = new Cliente(
                1L, "Brenda", "bren@email.com");

        Producto producto = new Producto(
                1L, "Notebook MacBook", "Notebook para desarrollo", new BigDecimal("1500000"), 10);

        Pedido pedido = new PedidoBuilder()
                .conId(1L)
                .conCliente(cliente)
                .agregarProducto(producto)
                .conMetodoDePago(MetodoDePago.MERCADO_PAGO)
                .conDireccionEnvio("Av. Rivadavia 1234")
                .construir();

        MercadoPagoAPI mercadoPagoAPI = new MercadoPagoAPI();

        ProcesadorPago procesadorPago = new MercadoPagoAdapter(mercadoPagoAPI);

        PagoConMercadoPago estrategiaPago = new PagoConMercadoPago(procesadorPago);

        ContextoPago contextoPago = new ContextoPago(estrategiaPago);

        FacadeCompra facadeCompra = new FacadeCompra(contextoPago);

        System.out.println("Estado inicial: " + pedido.getEstadoPedido());

        boolean compraExitosa = facadeCompra.procesarCompra(pedido);

        System.out.println("Compra exitosa: " + compraExitosa);

        System.out.println("Estado final: " + pedido.getEstadoPedido());
    }
}