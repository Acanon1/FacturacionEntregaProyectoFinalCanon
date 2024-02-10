package com.example.FacturacionEntregaProyectoFinalCanon.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.FacturacionEntregaProyectoFinalCanon.modelos.Recibo;

import com.example.FacturacionEntregaProyectoFinalCanon.service.ReciboService;

@RestController
@RequestMapping("/api/recibos")
public class reciboController {

    @Autowired
    private ReciboService reciboService;

    @GetMapping
    public List<Recibo> getAllRecibos() {
        return reciboService.getAllRecibos();
    }






}
