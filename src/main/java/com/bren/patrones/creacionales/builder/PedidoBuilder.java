package com.bren.patrones.creacionales.builder;

import com.bren.patrones.ecommerce.*;

import java.util.ArrayList;
import java.util.List;

public class PedidoBuilder {
    private Long id;
    private Cliente cliente;
    private final List<Producto> productos = new ArrayList<>();
    private MetodoDePago metodoDePago;
    private String direccionEnvio;
    private String cuponDescuento;
    private String observaciones;
    private boolean envioExpress;

    public PedidoBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public PedidoBuilder conCliente(Cliente cliente) {
        this.cliente = cliente;
        return this;
    }
    public PedidoBuilder agregarProducto(Producto producto) {
        if (producto == null) {
            throw new IllegalStateException("El producto no puede ser nulo");
        }

        this.productos.add(producto);
        return this;
    }

    public PedidoBuilder conMetodoDePago(MetodoDePago metodoDePago) {
        this.metodoDePago = metodoDePago;
        return this;
    }

    public PedidoBuilder conDireccionEnvio(String direccionEnvio) {
        this.direccionEnvio = direccionEnvio;
        return this;
    }

    public PedidoBuilder conCuponDescuento(String cuponDescuento) {
        this.cuponDescuento = cuponDescuento;
        return this;
    }

    public PedidoBuilder conObservaciones(String observaciones) {
        this.observaciones = observaciones;
        return this;
    }

    public PedidoBuilder conEnvioExpress(boolean envioExpress) {
        this.envioExpress = envioExpress;
        return this;
    }

    public Pedido construir() {
        validarDatosObligatorios();

        return new Pedido(id, cliente, productos, metodoDePago, direccionEnvio, cuponDescuento, observaciones, envioExpress);
    }

    private void validarDatosObligatorios() {
        if (id == null) {
            throw new IllegalStateException("El pedido debe tener un id");
        }

        if (cliente == null) {
            throw new IllegalStateException("El pedido debe tener un cliente");
        }

        if (productos.isEmpty()) {
            throw new IllegalStateException("El pedido debe tener al menos un producto");
        }

        if (metodoDePago == null) {
            throw new IllegalStateException("El pedido debe tener un método de pago");
        }
    }
}
