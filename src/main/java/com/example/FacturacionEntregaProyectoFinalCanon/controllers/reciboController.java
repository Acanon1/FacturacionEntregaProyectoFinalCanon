package com.example.FacturacionEntregaProyectoFinalCanon.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import com.example.FacturacionEntregaProyectoFinalCanon.modelos.Recibo;
import com.example.FacturacionEntregaProyectoFinalCanon.repositories.ReciboRepository;

@RestController
public class reciboController {
    @Autowired
    private ReciboRepository repo;

    @GetMapping("recibos")
    public List<Recibo> getRecibos(){
        return repo.findAll();
    }


}
