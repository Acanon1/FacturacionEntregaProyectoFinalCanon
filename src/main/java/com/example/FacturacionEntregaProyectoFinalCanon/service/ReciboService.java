package com.example.FacturacionEntregaProyectoFinalCanon.service;
import java.util.List;
import org.springframework.stereotype.Service;

import com.example.FacturacionEntregaProyectoFinalCanon.modelos.Recibo;
import com.example.FacturacionEntregaProyectoFinalCanon.repositories.ReciboRepository;

@Service
public class ReciboService {
    private ReciboRepository reciboRepository;

    public List<Recibo> getallRecibos(){
        return reciboRepository.findAll();
    }
}
