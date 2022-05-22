package com.manytoone.backend.services;

import com.manytoone.backend.dao.CategoriaDao;
import com.manytoone.backend.models.Categoria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImp implements CategoriaService{
    
    @Autowired
    private CategoriaDao categoriaDao;
    
    @Override
    public List<Categoria> findAll() {
        return categoriaDao.findAll();
    }
    
}
