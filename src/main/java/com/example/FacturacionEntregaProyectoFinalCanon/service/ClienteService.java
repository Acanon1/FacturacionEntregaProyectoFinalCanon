package com.example.FacturacionEntregaProyectoFinalCanon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.FacturacionEntregaProyectoFinalCanon.modelos.Cliente;
import com.example.FacturacionEntregaProyectoFinalCanon.repositories.ClienteRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    public Cliente getClienteById(Long clienteId) {
        return clienteRepository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado con ID: " + clienteId));
    }

    public Cliente createCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente updateCliente(Long clienteId, Cliente cliente) {
        // Validar si el cliente existe antes de actualizar
        getClienteById(clienteId);
        cliente.setClienteid(clienteId);
        return clienteRepository.save(cliente);
    }


    public void deleteCliente(Long clienteId) {
        // Validar si el cliente existe antes de eliminar
        getClienteById(clienteId);
        clienteRepository.deleteById(clienteId);
    }
}
