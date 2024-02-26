package com.example.FacturacionEntregaProyectoFinalCanon.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.FacturacionEntregaProyectoFinalCanon.modelos.Recibo;
import com.example.FacturacionEntregaProyectoFinalCanon.modelos.ReciboDTO;
import com.example.FacturacionEntregaProyectoFinalCanon.service.ReciboService;

@RestController
@RequestMapping("/api/recibos")
public class reciboController {

    @Autowired
    private ReciboService reciboService;

     public reciboController(ReciboService reciboService) {
        this.reciboService = reciboService;
    }
    //llamada de obtener todos los recibos
    @GetMapping
    public List<ReciboDTO> getAllRecibos() {
        return reciboService.getAllRecibos();
    }
    //llamada de obtener un recibo usando un ID
    @GetMapping("{reciboId}")
    public ReciboDTO one(@PathVariable Long reciboId) {
		
		return this.reciboService.findById(reciboId);
	}
    //llmada de postear un recibo nuevo
    @PostMapping
	public ReciboDTO newEntity(@RequestBody Recibo recibo) {
		return this.reciboService.guardarRecibo(recibo);
	}






}
