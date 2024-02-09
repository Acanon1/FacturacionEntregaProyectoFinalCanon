package com.example.FacturacionEntregaProyectoFinalCanon.controllers;
import org.springframework.web.bind.annotation.RestController;
import com.example.FacturacionEntregaProyectoFinalCanon.modelos.Cliente;

import com.example.FacturacionEntregaProyectoFinalCanon.service.ClienteService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class clienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/api/clientes")
    public List<Cliente> getAllClientes() {
        return clienteService.getAllClientes();
    }

    @GetMapping("/api/clientes/{clienteId}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable Long clienteId) {
        Cliente cliente = clienteService.getClienteById(clienteId);
        return ResponseEntity.ok(cliente);
    }

    @PostMapping
    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) {
        Cliente createdCliente = clienteService.createCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCliente);
    }

    @PutMapping("/api/clientes/{clienteId}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable Long clienteId, @RequestBody Cliente cliente) {
        Cliente updatedCliente = clienteService.updateCliente(clienteId, cliente);
        return ResponseEntity.ok(updatedCliente);
    }

    @DeleteMapping("/api/clientes/{clienteId}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long clienteId) {
        clienteService.deleteCliente(clienteId);
        return ResponseEntity.noContent().build();
    }
}