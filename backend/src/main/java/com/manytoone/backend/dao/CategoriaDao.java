package com.manytoone.backend.dao;

import com.manytoone.backend.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaDao extends JpaRepository<Categoria, Long>{
    
}
