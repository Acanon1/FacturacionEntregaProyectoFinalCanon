package com.example.FacturacionEntregaProyectoFinalCanon.modelos;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
public class ReciboDetalles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_recibo_detalles")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_recibo")
    private Recibo reciboD;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto productoD;

    @Column
    private int cantidad;

    @Column(name = "precio_unitario")
    private double precioUnitario;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Recibo getRecibo() {
        return reciboD;
    }

    public void setRecibo(Recibo recibo) {
        this.reciboD = recibo;
    }
    public Producto getProducto() {
        return productoD;
    }
    
    public void setProducto(Producto producto) {
        this.productoD = producto;
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
