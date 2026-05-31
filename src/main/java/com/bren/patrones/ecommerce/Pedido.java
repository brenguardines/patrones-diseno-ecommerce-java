package com.bren.patrones.ecommerce;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private Long id;
    private Cliente cliente;
    private List<Producto> productos;
    private EstadoPedido estadoPedido;
    private MetodoDePago metodoDePago;

    public Pedido(Long id, Cliente cliente, MetodoDePago metodoPago) {
        this.id = id;
        this.cliente = cliente;
        this.metodoDePago = metodoPago;
        this.estadoPedido = EstadoPedido.CREADO;
        this.productos = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public EstadoPedido getEstadoPedido() {
        return estadoPedido;
    }

    public MetodoDePago getMetodoDePago() {
        return metodoDePago;
    }

    public void agregarProducto(Producto producto) {
        if (!producto.tieneStock()) {
            throw new IllegalStateException("El producto no tiene stock disponible");
        }

        productos.add(producto);
    }

    public BigDecimal calcularTotal() {
        return productos.stream()
                .map(Producto::getPrecio)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void pagar() {
        if (estadoPedido != EstadoPedido.CREADO) {
            throw new IllegalStateException("Solo se puede pagar un pedido creado");
        }

        this.estadoPedido = EstadoPedido.PAGADO;
    }

    public void enviar() {
        if (estadoPedido != EstadoPedido.PAGADO) {
            throw new IllegalStateException("Solo se puede enviar un pedido pagado");
        }

        this.estadoPedido = EstadoPedido.ENVIADO;
    }

    public void entregar() {
        if (estadoPedido != EstadoPedido.ENVIADO) {
            throw new IllegalStateException("Solo se puede entregar un pedido enviado");
        }

        this.estadoPedido = EstadoPedido.ENTREGADO;
    }

    public void cancelar() {
        if (estadoPedido == EstadoPedido.ENTREGADO) {
            throw new IllegalStateException("No se puede cancelar un pedido entregado");
        }

        this.estadoPedido = EstadoPedido.CANCELADO;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", productos=" + productos +
                ", estadoPedido=" + estadoPedido +
                ", metodoDePago=" + metodoDePago +
                ", total=" + calcularTotal() +
                '}';
    }
}
