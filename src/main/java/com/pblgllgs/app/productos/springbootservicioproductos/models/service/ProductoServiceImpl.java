package com.pblgllgs.app.productos.springbootservicioproductos.models.service;

import com.pblgllgs.app.productos.springbootservicioproductos.models.dao.ProductoRepository;
import com.pblgllgs.app.productos.springbootservicioproductos.models.entity.Producto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductoServiceImpl implements IProductoService {

    private final ProductoRepository productoRepository;

    public ProductoServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> findAll() {
        return (List<Producto>)productoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Producto findById(Long id) {
        return productoRepository.findById(id).orElse(null);
    }
}
