package com.example.FacturacionEntregaProyectoFinalCanon.modelos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

//entidad de recibo tipo data transfer object
public class ReciboDTO {

    private Long reciboid;
    private int cantidad;
    private Date fecha;
    private BigDecimal total;

    private Cliente cliente;

    private Set<LineaDTO> lineas;

    public Long  getReciboid() {
        return reciboid;
    }

    public void setReciboid(Long reciboid) {
        this.reciboid = reciboid;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Set<LineaDTO> getLineas() {
        return lineas;
    }

    public void setLineas(Set<LineaDTO> lineas) {
        this.lineas = lineas;
    }

    


}
