package com.bren.patrones.estructurales.decorator;

import java.math.BigDecimal;

public interface ServicioPedido {
    BigDecimal calcularCosto();
    String obtenerDescripcion();
}
