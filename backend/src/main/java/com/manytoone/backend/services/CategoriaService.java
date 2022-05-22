package com.manytoone.backend.services;

import com.manytoone.backend.models.Categoria;
import java.util.List;

public interface CategoriaService {
    
    public List<Categoria> findAll();
}
