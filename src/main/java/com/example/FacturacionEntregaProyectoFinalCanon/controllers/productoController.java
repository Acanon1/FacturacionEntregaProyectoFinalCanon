package com.example.FacturacionEntregaProyectoFinalCanon.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.FacturacionEntregaProyectoFinalCanon.modelos.Producto;

import com.example.FacturacionEntregaProyectoFinalCanon.service.ProductoService;


@RestController
@RequestMapping("/api/productos")
public class productoController {
    @Autowired
    private ProductoService productoService;

    
    public productoController(ProductoService productoService) {
        this.productoService = productoService;
    }
    //llamada de obtener todos los productos
    @GetMapping
    public List<Producto> getAllProductos() {
        return productoService.getAllProductos();
    }
    //llamada de obtener un producto usando el ID
    @GetMapping("{productoId}")
    public ResponseEntity<Producto> getProductoById(@PathVariable Long productoId) {
        Producto producto = productoService.getProductoById(productoId);
        return ResponseEntity.ok(producto);
    }
    //llamada de postear un nuevo producto
    @PostMapping
    public ResponseEntity<Producto> createProducto(@RequestBody Producto producto) {
        Producto createdProducto = productoService.createProducto(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProducto);
    }
    //editar un productos usando ID
    @PutMapping("{productoId}")
    public ResponseEntity<Producto> updateProducto(@PathVariable Long productoId, @RequestBody Producto producto) {
        Producto updatedProducto = productoService.updateProducto(productoId, producto);
        return ResponseEntity.ok(updatedProducto);
    }
    //llamada de  editar algun atributo de un producto usando ID
    @PatchMapping("{productoId}")
    public ResponseEntity<Producto> updatePrecio(@PathVariable Long productoId, @RequestBody Producto producto) {
        Producto updatedPrecio = productoService.updatePrecio(productoId, producto);
        return ResponseEntity.ok(updatedPrecio);
    }
    //llamada de borrar un producto usando ID
    @DeleteMapping("{productoId}")
    public ResponseEntity<Void> deleteProducto(@PathVariable Long productoId) {
        productoService.deleteProducto(productoId);
        return ResponseEntity.noContent().build();
    }
}
