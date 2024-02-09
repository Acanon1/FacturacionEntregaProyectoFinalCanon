package com.example.FacturacionEntregaProyectoFinalCanon.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.FacturacionEntregaProyectoFinalCanon.modelos.Recibo;

public interface reciboRepository extends JpaRepository<Recibo,Long>{
    
}
