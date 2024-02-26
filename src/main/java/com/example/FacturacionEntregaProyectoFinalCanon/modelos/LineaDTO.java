package com.example.FacturacionEntregaProyectoFinalCanon.modelos;

import java.math.BigDecimal;


//entidad de linea tipo data transfer object
public class LineaDTO {
    private Long lineaid;
    private int cantidad;
    private String descripcion;
    private BigDecimal precioUnitario;
    
    public Long getLineaid() {
        return lineaid;
    }
    public void setLineaid(Long lineaid) {
        this.lineaid = lineaid;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }
    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    
}
