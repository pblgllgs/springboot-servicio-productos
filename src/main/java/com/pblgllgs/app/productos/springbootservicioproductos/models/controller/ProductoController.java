package com.pblgllgs.app.productos.springbootservicioproductos.models.controller;

import com.pblgllgs.app.productos.springbootservicioproductos.models.entity.Producto;
import com.pblgllgs.app.productos.springbootservicioproductos.models.service.IProductoService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Value("${server.port}")
    private Integer port;

    private final Environment environment;

    private final IProductoService productoService;

    public ProductoController(Environment environment, IProductoService productoService) {
        this.environment = environment;
        this.productoService = productoService;
    }

    @GetMapping("/all")
    public List<Producto> listar(){
        return productoService.findAll().stream().map(producto -> {
            producto.setPort(port);
            return producto;
        }).collect(Collectors.toList());
    }

    @GetMapping("/ver/{id}")
    public Producto detalle(@PathVariable Long id){
        Producto producto = productoService.findById(id);
        producto.setPort(port);
        return producto;
    }




}
