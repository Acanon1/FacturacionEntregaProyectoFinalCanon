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

    //metodo de obtener todos los productos
    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }
    //obtener un producto por ID
    public Producto getProductoById(Long productoId) {
        return productoRepository.findById(productoId)
                .orElseThrow(() -> new EntityNotFoundException("Producto no encontrado con ID: " + productoId));
    }
    //crear un nuevo producto
    public Producto createProducto(Producto producto) {
        return productoRepository.save(producto);
    }
    //actualizar un producto
    public Producto updateProducto(Long productoId, Producto producto) {
      
        Producto buscaProducto = productoRepository.findById(productoId).
            orElseThrow(()-> new RuntimeException("Producto no encontrado, ID: " + productoId));

        buscaProducto.setDescripcion(producto.getDescripcion());
        buscaProducto.setCodigo(producto.getCodigo());
        buscaProducto.setStock(producto.getStock());
        buscaProducto.setPrecio(producto.getPrecio());
        return productoRepository.save(buscaProducto);
    }
    //actualizar precio de un producto
    public Producto updatePrecio(Long productoId, Producto producto){
        Producto buscaProducto = productoRepository.findById(productoId).
            orElseThrow(()-> new RuntimeException("producto no encontrado: " + productoId));
        if(buscaProducto.getStock() != 0)
        buscaProducto.setPrecio(producto.getPrecio());
        return productoRepository.save(buscaProducto);
    }
    //borrar un producto
    public void deleteProducto(Long productoId) {
       
        getProductoById(productoId);
        productoRepository.deleteById(productoId);
    }
    //actualizar el stock de producti
    public Producto updateStock(Producto producto, int cantidad){
        int nuevo = producto.getStock() - cantidad;
        producto.setStock(nuevo);
        return productoRepository.save(producto);
    }
}
