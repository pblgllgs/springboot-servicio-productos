package com.pblgllgs.app.productos.springbootservicioproductos.models.dao;

import com.pblgllgs.app.productos.springbootservicioproductos.models.entity.Producto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends CrudRepository<Producto,Long> {

}
