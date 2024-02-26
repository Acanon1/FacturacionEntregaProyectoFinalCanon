package com.example.FacturacionEntregaProyectoFinalCanon.modelos;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

//entidad de recibos
@Getter
@Setter

@Entity
public class Recibo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_recibo")
    private Long reciboid;
    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date fecha;
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
    @Column
    private Integer cantidad;
    @Column
    private BigDecimal total;
    @OneToMany(mappedBy = "recibo", fetch = FetchType.EAGER, cascade =  CascadeType.ALL)
    private Set<Linea> lineas;

    public Long getReciboid() {
        return reciboid;
    }
    public void setReciboid(Long reciboid) {
        this.reciboid = reciboid;
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
    
    public Integer getCantidad(){
        return cantidad;
    }
    public void setCantidad(Integer cantidad){
        this.cantidad = cantidad;
    }
    public Set<Linea> getLineas() {
		return this.lineas;
	}

	public void setLineas(Set<Linea> lineas) {
		this.lineas = lineas;
	}
    public Linea agregarLinea(Linea linea) {
		getLineas().add(linea);
		linea.setRecibo(this);

		return linea;
	}

    public Recibo (){
        
    }
    @Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Comprobante [");
		if (reciboid != null)
			builder.append("comprobanteid=").append(reciboid).append(", ");
		if (cantidad != null)
			builder.append("cantidad=").append(cantidad).append(", ");
		if (fecha != null)
			builder.append("fecha=").append(fecha).append(", ");
        if (total != null)
			builder.append("total=").append(total).append(", ");
		builder.append("]");
		return builder.toString();
	}
}



