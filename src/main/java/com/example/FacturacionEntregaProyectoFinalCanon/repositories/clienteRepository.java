package com.example.FacturacionEntregaProyectoFinalCanon.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.FacturacionEntregaProyectoFinalCanon.modelos.Cliente;

public interface clienteRepository  extends JpaRepository<Cliente,Long>{
    
}
