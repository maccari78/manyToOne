package com.manytoone.backend.services;

import com.manytoone.backend.models.Producto;
import java.util.List;

public interface ProductoService {
    
    public Producto save(Producto producto);
    
    public Producto findById(Long id);
    
    public List<Producto> findAll();
    
    public void delete(Long id);
}
