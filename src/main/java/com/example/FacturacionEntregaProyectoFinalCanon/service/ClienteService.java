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
    //metodo de obtener todos los clientes
    public List<Cliente> getAllClientes() {
		return this.clienteRepository.findAll();
	}
    //metodo de obtener un cliente por ID
    public Cliente getClienteById(Long clienteId) {
        return clienteRepository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado con ID: " + clienteId));
    }
    //metodo de crear un nuevo cliente
    public Cliente createCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
    //actualizar un cliente
    public Cliente updateCliente(Long clienteId, Cliente cliente) {
        
        getClienteById(clienteId);
        cliente.setClienteid(clienteId);
        return clienteRepository.save(cliente);
    }

    //borrar un cliente
    public void deleteCliente(Long clienteId) {
        
        getClienteById(clienteId);
        clienteRepository.deleteById(clienteId);
    }
}
