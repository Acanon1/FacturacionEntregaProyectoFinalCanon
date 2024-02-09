package com.example.FacturacionEntregaProyectoFinalCanon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.FacturacionEntregaProyectoFinalCanon.modelos.Producto;
import com.example.FacturacionEntregaProyectoFinalCanon.repositories.ProductoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductoService {

    private ProductoRepository productoRepository;

    @Autowired
    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

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
        getProductoById(productoId);
        producto.setId(productoId);
        return productoRepository.save(producto);
    }

    public void deleteProducto(Long productoId) {
        // Validar si el producto existe antes de eliminar
        getProductoById(productoId);
        productoRepository.deleteById(productoId);
    }
}
