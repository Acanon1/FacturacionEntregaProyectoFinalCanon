package com.example.FacturacionEntregaProyectoFinalCanon.controllers;
import org.springframework.web.bind.annotation.RestController;
import com.example.FacturacionEntregaProyectoFinalCanon.modelos.Cliente;
import com.example.FacturacionEntregaProyectoFinalCanon.repositories.clienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;




@RestController
public class clienteController {
    @Autowired
    private clienteRepository repo;

    @GetMapping
    public String index(){
        return "conectado";
    }
    @GetMapping("clientes")
    public List<Cliente> getClientes(){
        return  repo.findAll();
    }
}
