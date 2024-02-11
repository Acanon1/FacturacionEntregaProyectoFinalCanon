package com.example.FacturacionEntregaProyectoFinalCanon.modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class Linea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_linea")
    private Long lineaid;
    @Column
    private int cantidad;
    @Column
    private String descripcion;
    @Column(name = "precio_unitario")
    private double precioUnitario;
    @ManyToOne
    @JoinColumn(name = "id_recibo")
    private Recibo recibo;
    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;

    public Long getLineaid() {
        return lineaid;
    }
    public void setLineaid(Long lineaid) {
        this.lineaid = lineaid;
    }
    public Recibo getRecibo() {
        return recibo;
    }

    public void setRecibo(Recibo recibo) {
        this.recibo = recibo;
    }
    public Producto getProducto() {
        return producto;
    }
    
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    public double getPrecioUnitario() {
        return precioUnitario;
    }   

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }


}
