package com.example.FacturacionEntregaProyectoFinalCanon.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.FacturacionEntregaProyectoFinalCanon.modelos.Cliente;

public interface ClienteRepository  extends JpaRepository<Cliente,Long>{
    
}
