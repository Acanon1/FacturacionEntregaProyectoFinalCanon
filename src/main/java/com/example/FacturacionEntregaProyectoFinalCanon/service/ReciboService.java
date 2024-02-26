package com.example.FacturacionEntregaProyectoFinalCanon.service;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.FacturacionEntregaProyectoFinalCanon.modelos.*;
import com.example.FacturacionEntregaProyectoFinalCanon.repositories.*;

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
	private RestTemplate restTemplate;

    //metodo de obtener todos los recibos
    public List<ReciboDTO> getAllRecibos() {
        return crearRecibos(this.reciboRepository.findAll());
    }
    //obtnener un recibo por ID
    public ReciboDTO findById(Long reciboId) {
        return reciboRepository.findById(reciboId)
                .map(this::crearRecibo)
                .orElse(new ReciboDTO());
    }
    //ver existencia de un cliente
    public boolean clienteExiste(Cliente cliente) {
        return cliente != null && clienteRepository.existsById(cliente.getClienteid());
    }
    //ver existencia de producto
    private boolean productoExiste(Set<Linea> lineas) {
        return lineas.stream()
                .allMatch(linea -> linea.getProducto() != null && productoRepository.existsById(linea.getProducto().getProductoid()));
    }
    

    //metodo de postear el recibo
    public ReciboDTO guardarRecibo(Recibo recibo){
        Boolean clienteE = clienteExiste(recibo.getCliente());
        Boolean productoE = productoExiste(recibo.getLineas());

        if (clienteE && productoE) {
            Recibo reciboGuardar = hacerRecibo(recibo);
            return crearRecibo(reciboRepository.save(reciboGuardar));
        } else {
            return new ReciboDTO();
        }
    }
    //tomas los objetos de  tipo recibo y crea una colecion de recibos
    public List<ReciboDTO> crearRecibos(List<Recibo> recibos) {
        return recibos.stream()
                .map(this::crearRecibo)
                .collect(Collectors.toList());
    }
    //conversion del objeto recibo a reciboDTO
    public ReciboDTO crearRecibo(Recibo recibo) {
        ReciboDTO forma = new ReciboDTO();
        forma.setReciboid(recibo.getReciboid());
        forma.setCantidad(recibo.getCantidad());
        forma.setFecha(recibo.getFecha());
        forma.setTotal(recibo.getTotal());
        forma.setCliente(recibo.getCliente());
        forma.setLineas(crearLineas(recibo.getLineas()));
        return forma;
    }
    //conversion y collecion de los objetos linea a lineaDTO
    public Set<LineaDTO> crearLineas(Set<Linea> lineas) {
        return lineas.stream()
                    .map(linea -> {
                        LineaDTO forma = new LineaDTO();
                        forma.setLineaid(linea.getLineaid());
                        forma.setCantidad(linea.getCantidad());
                        forma.setDescripcion(linea.getDescripcion());
                        forma.setPrecioUnitario(linea.getPrecioUnitario());
                        return forma;
                    })
                    .collect(Collectors.toSet());
    }
    
    //crea una nueva linea 
    private Linea crearLinea(Linea linea) {
        Linea lineaAGuardar = new Linea();
        Producto productoDB = productoRepository.findById(linea.getProducto().getProductoid())
                .orElseThrow(() -> new EntityNotFoundException("No se econtro el producto"));
        lineaAGuardar.setCantidad(linea.getCantidad());
        lineaAGuardar.setDescripcion(productoDB.getDescripcion());
        lineaAGuardar.setProducto(productoDB);
        return lineaAGuardar;
    }
    //armar el recibo final
    public Recibo hacerRecibo(Recibo recibo) {
        var reciboActual = new Recibo();
        
        Cliente cliente = clienteRepository.findById(recibo.getCliente().getClienteid())
                .orElseThrow(() -> new EntityNotFoundException("no se encontro el cliente"));
                reciboActual.setCliente(cliente);
        
                reciboActual.setLineas(new HashSet<>());
        for (Linea linea : recibo.getLineas()) {
            reciboActual.agregarLinea(crearLinea(linea));
        }
        
        reciboActual.setCantidad(reciboActual.getLineas().size());
        
        return reciboActual;
    }
    //insertar fecha de creacion del recibo
    public Recibo tiempo(Recibo recibo) {
        Recibo reciboActual = new Recibo();
        
        WorldCLock worldClock = this.restTemplate.getForObject("http://worldclockapi.com/api/json/utc/now", WorldCLock.class);
        String currentDateTime = worldClock.getCurrentDateTime();
        // "2021-12-08T17:36Z"
        try {
            Date date1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").parse(currentDateTime);
            reciboActual.setFecha(date1);
        } catch (ParseException e) {
            e.printStackTrace();
            reciboActual.setFecha(new Date());
        }
        
        return reciboActual;
    }
    
}
