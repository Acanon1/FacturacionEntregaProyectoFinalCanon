package com.example.FacturacionEntregaProyectoFinalCanon.modelos;

import java.time.LocalDate;
import java.util.List;

import org.springframework.cglib.core.Local;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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

@Getter
@Setter

@Entity
public class Recibo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_recibo")
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column
    private LocalDate creacion;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;


    private int cantidad_total;

    @Column
    private double total;

    @OneToMany(mappedBy = "reciboD")
    private List<ReciboDetalles> reciboDetalles;


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
    public int getCantidad_total(){
        return cantidad_total;
    }
    public void setCantidad_total(int cantidad_total){
        this.cantidad_total = cantidad_total;
    }

    public Recibo (){
        
    }
    public Recibo(long id, LocalDate creacion, double total, int cantidad_total, Cliente cliente){
        this.id = id;
        this.creacion = creacion;
        this.total = total;
        this.cantidad_total = cantidad_total;
        this.cliente = cliente;
    }
    @Override
    public String toString(){
        return "Recibo [id=" + id + ", fecha=" + creacion + ", total=" + total + "]";
	}


}



