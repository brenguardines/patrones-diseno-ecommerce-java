package com.bren.patrones.ecommerce;

import com.bren.patrones.comportamiento.observer.ObservadorPedido;
import com.bren.patrones.comportamiento.state.EstadoCreado;
import com.bren.patrones.comportamiento.state.EstadoPedidoState;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private Long id;
    private Cliente cliente;
    private List<Producto> productos;
    private EstadoPedidoState estadoPedido;
    private MetodoDePago metodoDePago;
    private String direccionEnvio;
    private String cuponDescuento;
    private String observaciones;
    private boolean envioExpress;

    private final List<ObservadorPedido> observadores = new ArrayList<>();

    public Pedido(Long id, Cliente cliente, MetodoDePago metodoDePago) {
        this(
                id,
                cliente,
                new ArrayList<>(),
                metodoDePago,
                null,
                null,
                null,
                false
        );
    }

    public Pedido(Long id, Cliente cliente, List<Producto> productos, MetodoDePago metodoDePago, String direccionEnvio, String cuponDescuento, String observaciones, boolean envioExpress) {
        this.id = id;
        this.cliente = cliente;
        this.metodoDePago = metodoDePago;
        this.estadoPedido = new EstadoCreado();
        this.productos = new ArrayList<>();
        this.direccionEnvio = direccionEnvio;
        this.cuponDescuento = cuponDescuento;
        this.observaciones = observaciones;
        this.envioExpress = envioExpress;

        if (productos != null) {
            productos.forEach(this::agregarProducto);
        }
    }


    public Long getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Producto> getProductos() {
        return List.copyOf(productos);
    }

    public EstadoPedido getEstadoPedido() {
        return estadoPedido.getEstado();
    }

    public MetodoDePago getMetodoDePago() {
        return metodoDePago;
    }

    public String getDireccionEnvio() {
        return direccionEnvio;
    }

    public String getCuponDescuento() {
        return cuponDescuento;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public boolean isEnvioExpress() {
        return envioExpress;
    }

    public void agregarProducto(Producto producto) {
        if (producto == null) {
            throw new IllegalStateException("El producto no puede ser nulo");
        }

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
        cambiarEstado(estadoPedido.pagar());
    }

    public void enviar() {
        cambiarEstado(estadoPedido.enviar());
    }

    public void entregar() {
        cambiarEstado(estadoPedido.entregar());
    }

    public void cancelar() {
        cambiarEstado(estadoPedido.cancelar());
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
                ", direccionEnvio='" + direccionEnvio + '\'' +
                ", cuponDescuento='" + cuponDescuento + '\'' +
                ", observaciones='" + observaciones + '\'' +
                ", envioExpress=" + envioExpress +
                '}';
    }

    public void agregarObservador(ObservadorPedido observador) {
        if (observador == null) {
            throw new IllegalArgumentException("El observador no puede ser nulo");
        }

        observadores.add(observador);
    }

    public void eliminarObservador(ObservadorPedido observador) {
        observadores.remove(observador);
    }

    private void notificarObservadores() {
        observadores.forEach(observador -> observador.actualizar(this));
    }

    private void cambiarEstado(EstadoPedidoState nuevoEstado) {
        this.estadoPedido = nuevoEstado;
        notificarObservadores();
    }
}
