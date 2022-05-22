package com.manytoone.backend.services;

import com.manytoone.backend.dao.ProductoDao;
import com.manytoone.backend.models.Producto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImp implements ProductoService{
    
    @Autowired
    private ProductoDao productoDao;
    
    @Override
    public Producto save(Producto producto) {
        return productoDao.save(producto);
    }

    @Override
    public Producto findById(Long id) {
        return productoDao.findById(id).orElse(null);
    }

    @Override
    public List<Producto> findAll() {
        return productoDao.findAll();
    }

    @Override
    public void delete(Long id) {
       productoDao.deleteById(id);
    }
    
    
}
