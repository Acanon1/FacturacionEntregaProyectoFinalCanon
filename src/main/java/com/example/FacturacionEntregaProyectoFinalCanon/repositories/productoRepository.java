package com.example.FacturacionEntregaProyectoFinalCanon.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.FacturacionEntregaProyectoFinalCanon.modelos.Producto;

public interface productoRepository extends JpaRepository<Producto,Long>{

    
}
