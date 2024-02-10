    package com.example.FacturacionEntregaProyectoFinalCanon.controllers;

    import java.util.List;

    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

    import com.example.FacturacionEntregaProyectoFinalCanon.modelos.ReciboDetalles;
    import com.example.FacturacionEntregaProyectoFinalCanon.repositories.RecibodetallesRepository;
import com.example.FacturacionEntregaProyectoFinalCanon.service.ReciboDetallesService;

    @RestController
    @RequestMapping("/api/reciboDetalles")
    public class recibodetallesController {

        @Autowired
        private ReciboDetallesService reciboDetallesService;
        

        @GetMapping
        public List<ReciboDetalles> getReciboDetalles(){
            return reciboDetallesService.getAllReciboDetalles();
        }
        
    }
