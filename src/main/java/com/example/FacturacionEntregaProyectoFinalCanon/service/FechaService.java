package com.example.FacturacionEntregaProyectoFinalCanon.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FechaService {
    public String getFecha(){
        RestTemplate restTemplate = new RestTemplate();
        final String url = "http://worldclockapi.com/api/json/utc/now";
        return restTemplate.getForObject(url, String.class);
    }
}
