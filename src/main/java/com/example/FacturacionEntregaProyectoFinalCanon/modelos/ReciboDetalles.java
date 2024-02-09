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
    private Recibo recibo;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;

    @Column
    private int cantidad;

    @Column(name = "precio_unitario")
    private double precioUnitario;

    // Getters y setters
}
