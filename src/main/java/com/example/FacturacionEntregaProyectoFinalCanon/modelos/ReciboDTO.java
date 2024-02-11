package com.example.FacturacionEntregaProyectoFinalCanon.modelos;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.Column;

public class ReciboDTO {
    @Column(name = "id_recibo")
    private int reciboid;
    private int cantidad;
    private LocalDate creacion;
    private double total;

    private Cliente cliente;

    private Set<LineaDTO> lineas;

    public int getReciboid() {
        return reciboid;
    }

    public void setReciboid(int reciboid) {
        this.reciboid = reciboid;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public LocalDate getCreacion() {
        return creacion;
    }

    public void setCreacion(LocalDate creacion) {
        this.creacion = creacion;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
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
