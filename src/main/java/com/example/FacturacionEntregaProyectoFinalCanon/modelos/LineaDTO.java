package com.example.FacturacionEntregaProyectoFinalCanon.modelos;

public class LineaDTO {
    private int lineaid;
    private int cantidad;
    private String descripcion;
    private double precio;
    
    public int getLineaid() {
        return lineaid;
    }
    public void setLineaid(int lineaid) {
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
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    
}
