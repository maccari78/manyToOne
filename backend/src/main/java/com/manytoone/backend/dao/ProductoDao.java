package com.manytoone.backend.dao;

import com.manytoone.backend.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoDao extends JpaRepository<Producto, Long>{
    
}
