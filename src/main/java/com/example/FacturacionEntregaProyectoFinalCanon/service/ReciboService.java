package com.example.FacturacionEntregaProyectoFinalCanon.service;
import java.time.LocalDate;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.FacturacionEntregaProyectoFinalCanon.modelos.Cliente;
import com.example.FacturacionEntregaProyectoFinalCanon.modelos.Producto;
import com.example.FacturacionEntregaProyectoFinalCanon.modelos.Recibo;
import com.example.FacturacionEntregaProyectoFinalCanon.repositories.ClienteRepository;
import com.example.FacturacionEntregaProyectoFinalCanon.repositories.ProductoRepository;
import com.example.FacturacionEntregaProyectoFinalCanon.repositories.ReciboRepository;

import jakarta.persistence.EntityNotFoundException;


@Service
public class ReciboService {
    @Autowired
    private ReciboRepository reciboRepository;
    @Autowired
	private ClienteRepository clienteRepository;
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private FechaService fechaService;
    @Autowired
    private ProductoService productoService;

    public List<Recibo> getAllRecibos(){
        return reciboRepository.findAll();
    }
    public Recibo getRecibobyId(Long reciboId) {
        return reciboRepository.findById(reciboId)
                .orElseThrow(() -> new EntityNotFoundException("Producto no encontrado con ID: " + reciboId));
    }
    public Recibo crearRecibo(Recibo recibo ){
        Recibo recibos = new Recibo();
        Cliente clientes = clienteService.getClienteById();
        recibos.setCliente(clientes);
        Recibo guardar = reciboRepository.save(recibos);
    }

}
