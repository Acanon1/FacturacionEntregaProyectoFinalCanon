package com.example.FacturacionEntregaProyectoFinalCanon.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.FacturacionEntregaProyectoFinalCanon.modelos.Recibo;
import com.example.FacturacionEntregaProyectoFinalCanon.repositories.reciboRepository;

@RestController
public class reciboController {
    @Autowired
    private reciboRepository repo;

    @GetMapping("recibos")
    public List<Recibo> getRecibos(){
        return repo.findAll();
    }
}
