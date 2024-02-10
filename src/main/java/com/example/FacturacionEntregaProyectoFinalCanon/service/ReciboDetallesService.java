package com.example.FacturacionEntregaProyectoFinalCanon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.FacturacionEntregaProyectoFinalCanon.modelos.ReciboDetalles;
import com.example.FacturacionEntregaProyectoFinalCanon.repositories.RecibodetallesRepository;

@Service
public class ReciboDetallesService {

    @Autowired
    private RecibodetallesRepository recibodetallesRepository;

    public List<ReciboDetalles> getAllReciboDetalles(){
        return recibodetallesRepository.findAll();
    }
    
}
