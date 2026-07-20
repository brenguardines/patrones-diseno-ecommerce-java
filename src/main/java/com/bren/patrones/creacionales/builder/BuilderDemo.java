package com.bren.patrones.creacionales.builder;

import com.bren.patrones.ecommerce.Cliente;
import com.bren.patrones.ecommerce.MetodoDePago;
import com.bren.patrones.ecommerce.Pedido;
import com.bren.patrones.ecommerce.Producto;

import java.math.BigDecimal;

public class BuilderDemo {

    public static void ejecutar() {
        Cliente cliente = new Cliente(1L, "Brenda", "bren@email.com");
        Producto notebook = new Producto(1L, "Notebook MacBook", "Notebook para desarrollo", new BigDecimal("1500000"), 10);
        Producto teclado = new Producto(2L, "Teclado", "Teclado para programar", new BigDecimal("70000"), 5);

        Pedido pedido = new PedidoBuilder()
                .conId(1L)
                .conCliente(cliente)
                .agregarProducto(notebook)
                .agregarProducto(teclado)
                .conMetodoDePago(MetodoDePago.MERCADO_PAGO)
                .conDireccionEnvio("Av. Rivadavia 1234")
                .conCuponDescuento("DESCUENTO10")
                .conObservaciones("Entregar despues de las 18hs")
                .conEnvioExpress(true)
                .construir();

        System.out.println(pedido);
    }
}
