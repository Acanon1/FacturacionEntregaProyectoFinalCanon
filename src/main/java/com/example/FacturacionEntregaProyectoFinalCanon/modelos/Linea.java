package com.example.FacturacionEntregaProyectoFinalCanon.modelos;

import java.math.BigDecimal;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

//entidad de linea
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
    private BigDecimal precioUnitario;
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
    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    @Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Linea [lineaid=").append(lineaid).append(", cantidad=").append(cantidad).append(", ");
		if (descripcion != null)
			builder.append("descripcion=").append(descripcion).append(", ");
		if (precioUnitario != null)
			builder.append("precio=").append(precioUnitario);
		builder.append("]");
		return builder.toString();
	}
}
