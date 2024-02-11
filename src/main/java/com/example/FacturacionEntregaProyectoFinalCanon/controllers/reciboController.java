package com.example.FacturacionEntregaProyectoFinalCanon.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.FacturacionEntregaProyectoFinalCanon.modelos.Producto;
import com.example.FacturacionEntregaProyectoFinalCanon.modelos.Recibo;
import com.example.FacturacionEntregaProyectoFinalCanon.service.ProductoService;
import com.example.FacturacionEntregaProyectoFinalCanon.service.ReciboService;

@RestController
@RequestMapping("/api/recibos")
public class reciboController {

    @Autowired
    private ReciboService reciboService;

     public reciboController(ReciboService reciboService) {
        this.reciboService = reciboService;
    }

    @GetMapping
    public List<Recibo> getAllRecibos() {
        return reciboService.getAllRecibos();
    }
    @GetMapping("{reciboId}")
    public ResponseEntity<Recibo> getReciboById(@PathVariable Long reciboId) {
        Recibo recibo = reciboService.getRecibobyId(reciboId);
        return ResponseEntity.ok(recibo);
    }
    @PostMapping
    public ResponseEntity<Recibo> createProducto(@RequestBody Recibo recibo) {
        Recibo createdRecibo = reciboService.createRecibo(recibo);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRecibo);
    }






}
