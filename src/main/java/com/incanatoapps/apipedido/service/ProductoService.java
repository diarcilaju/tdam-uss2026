package com.incanatoapps.apipedido.service;

import com.incanatoapps.apipedido.entity.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductoService {
    Page<Producto> findAll(Pageable pageable, String search);
    Producto findById(Long id);
    Producto create(Producto obj);
    Producto update(Long id, Producto obj);
    void delete(Long id);
}
