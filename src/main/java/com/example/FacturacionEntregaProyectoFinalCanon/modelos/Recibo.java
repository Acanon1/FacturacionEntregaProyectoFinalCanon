package com.example.FacturacionEntregaProyectoFinalCanon.modelos;

import java.time.LocalDate;
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

@Getter
@Setter

@Entity
public class Recibo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_recibo")
    private Long reciboid;
    @Temporal(TemporalType.DATE)
    @Column
    private LocalDate fecha;
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
    @Column
    private int cantidad;
    @Column
    private double total;
    @OneToMany(mappedBy = "recibo", fetch = FetchType.EAGER, cascade =  CascadeType.ALL)
    private Set<Linea> lineas;

    public Long getReciboid() {
        return reciboid;
    }
    public void setReciboid(Long reciboid) {
        this.reciboid = reciboid;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
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
    public int getCantidad(){
        return cantidad;
    }
    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }

    public Recibo (){
        
    }
}



