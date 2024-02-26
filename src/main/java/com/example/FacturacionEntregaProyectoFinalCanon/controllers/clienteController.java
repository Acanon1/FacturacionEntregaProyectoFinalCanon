package com.example.FacturacionEntregaProyectoFinalCanon.controllers;
import com.example.FacturacionEntregaProyectoFinalCanon.modelos.Cliente;

import com.example.FacturacionEntregaProyectoFinalCanon.service.ClienteService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clientes")
public class clienteController {

    @Autowired
    private ClienteService clienteService;
    //llamada de obtener todos los clientes
    @GetMapping
    public List<Cliente> getAllClientes() {
        return clienteService.getAllClientes();
    }
    //llamada de obtener cliente usando el ID
    @GetMapping("{clienteId}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable Long clienteId) {
        Cliente cliente = clienteService.getClienteById(clienteId);
        return ResponseEntity.ok(cliente);
    }
    //llamada de postear cliente nuevo
    @PostMapping
    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) {
        Cliente createdCliente = clienteService.createCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCliente);
    }
    //llamada de cambiar un cliente
    @PutMapping("{clienteId}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable Long clienteId, @RequestBody Cliente cliente) {
        Cliente updatedCliente = clienteService.updateCliente(clienteId, cliente);
        return ResponseEntity.ok(updatedCliente);
    }
    //llamada de borrar un cliente
    @DeleteMapping("{clienteId}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long clienteId) {
        clienteService.deleteCliente(clienteId);
        return ResponseEntity.noContent().build();
    }
}