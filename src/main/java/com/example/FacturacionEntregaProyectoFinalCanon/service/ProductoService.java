package com.example.FacturacionEntregaProyectoFinalCanon.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.FacturacionEntregaProyectoFinalCanon.modelos.Producto;
import com.example.FacturacionEntregaProyectoFinalCanon.repositories.ProductoRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;


    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    public Producto getProductoById(Long productoId) {
        return productoRepository.findById(productoId)
                .orElseThrow(() -> new EntityNotFoundException("Producto no encontrado con ID: " + productoId));
    }

    public Producto createProducto(Producto producto) {
        // Puedes realizar validaciones antes de guardar el producto, si es necesario
        return productoRepository.save(producto);
    }

    public Producto updateProducto(Long productoId, Producto producto) {
        // Validar si el producto existe antes de actualizar
        Producto buscaProducto = productoRepository.findById(productoId).
            orElseThrow(()-> new RuntimeException("Producto no encontrado, ID: " + productoId));

        buscaProducto.setDescripcion(producto.getDescripcion());
        buscaProducto.setCodigo(producto.getCodigo());
        buscaProducto.setStock(producto.getStock());
        buscaProducto.setPrecio(producto.getPrecio());
        return productoRepository.save(buscaProducto);
    }
    public Producto updatePrecio(Long productoId, Producto producto){
        Producto buscaProducto = productoRepository.findById(productoId).
            orElseThrow(()-> new RuntimeException("producto no encontrado: " + productoId));
        if(buscaProducto.getStock() != 0)
        buscaProducto.setPrecio(producto.getPrecio());
        return productoRepository.save(buscaProducto);
    }

    public void deleteProducto(Long productoId) {
        // Validar si el producto 
        getProductoById(productoId);
        productoRepository.deleteById(productoId);
    }
    public Producto updateStock(Producto producto, int cantidad){
        int nuevo = producto.getStock() - cantidad;
        producto.setStock(nuevo);
        return productoRepository.save(producto);
    }
}
