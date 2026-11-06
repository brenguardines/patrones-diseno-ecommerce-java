package com.bren.patrones.comportamiento.chainofresponsibility;

import com.bren.patrones.creacionales.builder.PedidoBuilder;
import com.bren.patrones.ecommerce.Cliente;
import com.bren.patrones.ecommerce.MetodoDePago;
import com.bren.patrones.ecommerce.Pedido;
import com.bren.patrones.ecommerce.Producto;

import java.math.BigDecimal;

public class ChainOfResponsibilityDemo {
    public static void ejecutar() {

    Cliente cliente = new Cliente(1L, "Brenda", "bren@email.com");
    Producto producto = new Producto(1L, "Notebook MacBook", "Notebook para desarrollo", new BigDecimal("1500000"), 10);
    Pedido pedidoValido = new PedidoBuilder()
            .conId(1L)
            .conCliente(cliente)
            .agregarProducto(producto)
            .conMetodoDePago(MetodoDePago.MERCADO_PAGO)
            .conDireccionEnvio("Av. Rivadavia 1234")
            .construir();

    Pedido pedidoSinDireccion = new PedidoBuilder()
            .conId(2L)
            .conCliente(cliente)
            .agregarProducto(producto)
            .conMetodoDePago(MetodoDePago.MERCADO_PAGO)
            .construir();

    ValidadorPedido validadorCliente = new ValidadorCliente();

    ValidadorPedido validadorProductos = new ValidadorProductos();

    ValidadorPedido validadorDireccion = new ValidadorDireccion();

    ValidadorPedido validadorMetodoPago = new ValidadorMetodoDePago();

    validadorCliente.establecerSiguiente(validadorProductos);
    validadorProductos.establecerSiguiente(validadorDireccion);
    validadorDireccion.establecerSiguiente(validadorMetodoPago);

    System.out.println("Validando pedido " + pedidoValido.getId());
    System.out.println();

    boolean esPedidoValido = validadorCliente.validar(pedidoValido);

    System.out.println();
    System.out.println("Pedido valido: " + esPedidoValido);

    System.out.println();
    System.out.println("--------------------");
    System.out.println();

    System.out.println("Validando pedido " + pedidoSinDireccion.getId());
    System.out.println();

    boolean esPedidoSinDireccionValido = validadorCliente.validar(pedidoSinDireccion);

    System.out.println();
    System.out.println("Pedido valido: " + esPedidoSinDireccionValido);
    }
}