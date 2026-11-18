package com.incanatoapps.apipedido.service.impl;

import com.incanatoapps.apipedido.entity.Producto;
import com.incanatoapps.apipedido.repository.ProductoRepository;
import com.incanatoapps.apipedido.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoServiceImpl implements ProductoService {
    @Autowired
    private ProductoRepository repository;

    @Transactional(readOnly = true)
    @Override
    public Page<Producto> findAll(Pageable pageable, String search) {
        if(search==null){
            return repository.findAll(pageable);
        }else{
            return repository.findByNombreContainingIgnoreCase(pageable, search);
        }
    }

    @Transactional(readOnly = true)
    @Override
    public Producto findById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Transactional
    @Override
    public Producto create(Producto obj) {
        return repository.save(obj);
    }

    @Transactional
    @Override
    public Producto update(Long id, Producto obj) {
        Producto updated=this.findById(id);
        updated.setNombre(obj.getNombre());
        updated.setCodigo(obj.getCodigo());
        updated.setPrecio(obj.getPrecio());
        return repository.save(updated);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        Producto deleted=this.findById(id);
        repository.delete(deleted);
    }
}
