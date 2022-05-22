package com.manytoone.backend.controllers;

import com.manytoone.backend.models.Categoria;
import com.manytoone.backend.models.Producto;
import com.manytoone.backend.services.CategoriaService;
import com.manytoone.backend.services.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/productos")
public class ProductoController {
    
    @Autowired
    private ProductoService productoService;
    
    @Autowired
    private CategoriaService categoriaService;
    
    @GetMapping("/listar")
    public ResponseEntity<List<Producto>> listarProductos() {
        return new ResponseEntity<>(productoService.findAll(), HttpStatus.OK);
    }
    
    @GetMapping("/categorias")
    public ResponseEntity<List<Categoria>> listarCategorias() {
        return new ResponseEntity<>(categoriaService.findAll(), HttpStatus.OK);
    }
    
    @GetMapping("{id}")
    public ResponseEntity<Producto> obtenerProducto(@PathVariable Long id) {
        return new ResponseEntity<>(productoService.findById(id), HttpStatus.OK);
    }
    
    @PostMapping("/crear")
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto) {
        return new ResponseEntity<>(productoService.save(producto), HttpStatus.CREATED);
    }
    
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable Long id, @RequestBody Producto producto) {
        Producto productoEncontrado = productoService.findById(id);
        
        if (productoEncontrado == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
        try {
            productoEncontrado.setNombre(producto.getNombre());
            productoEncontrado.setPrecio(producto.getPrecio());
            productoEncontrado.setImagen(producto.getImagen());
            productoEncontrado.setCategoria(producto.getCategoria());
            return new ResponseEntity<>(productoService.save(productoEncontrado), HttpStatus.CREATED);
        } catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> actualizarProducto(@PathVariable Long id) {
        productoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
