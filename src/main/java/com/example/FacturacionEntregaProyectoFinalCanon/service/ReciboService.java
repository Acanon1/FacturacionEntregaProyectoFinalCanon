package com.example.FacturacionEntregaProyectoFinalCanon.service;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.FacturacionEntregaProyectoFinalCanon.modelos.Cliente;
import com.example.FacturacionEntregaProyectoFinalCanon.modelos.Linea;
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



    public List<Recibo> getAllRecibos(){
        return reciboRepository.findAll();
    }
    public Recibo getRecibobyId(Long reciboId) {
        return reciboRepository.findById(reciboId)
                .orElseThrow(() -> new EntityNotFoundException("Producto no encontrado con ID: " + reciboId));
    }
    public Recibo createRecibo(Recibo reciboRequest) {
        Recibo recibo = new Recibo();
        
        Cliente cliente = clienteRepository.findById(reciboRequest.getCliente().getClienteid())
                            .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado con ID: " + reciboRequest.getCliente().getClienteid()));
        recibo.setCliente(cliente);

        Set<Linea> lineas = new HashSet<>();
        for (Linea lineaRequest : reciboRequest.getLineas()) {
            Linea linea = new Linea();
            linea.setCantidad(lineaRequest.getCantidad());
            Producto producto = productoRepository.findById(lineaRequest.getProducto().getProductoid())
                                .orElseThrow(() -> new EntityNotFoundException("Producto no encontrado con ID: " + lineaRequest.getProducto().getProductoid()));
            linea.setProducto(producto);
            linea.setRecibo(recibo);
            lineas.add(linea);
        }
        recibo.setLineas(lineas);

        return reciboRepository.save(recibo);
    }



}
