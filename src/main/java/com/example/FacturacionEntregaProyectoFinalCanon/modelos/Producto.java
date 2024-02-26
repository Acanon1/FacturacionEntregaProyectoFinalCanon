package com.example.FacturacionEntregaProyectoFinalCanon.modelos;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

//entidad de productos
@Getter
@Setter
@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long productoid;
    @Column
    private Integer stock;
    @Column
    private String codigo;
    @Column
    private String descripcion;
    @Column
    private BigDecimal precio;
    public Long getProductoid() {
        return productoid;
    }
    public void setProductoid(Long productoid) {
        this.productoid = productoid;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public Integer getStock() {
        return stock;
    }
    public void setStock(Integer stock) {
        this.stock = stock;
    }
    public BigDecimal getPrecio() {
        return precio;
    }
    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    @Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Producto [");
		if (productoid != null)
			builder.append("productoid=").append(productoid).append(", ");
		if (stock != null)
			builder.append("cantidad=").append(stock).append(", ");
		if (codigo != null)
			builder.append("codigo=").append(codigo);
		builder.append("]");
		return builder.toString();
	}

    
}
