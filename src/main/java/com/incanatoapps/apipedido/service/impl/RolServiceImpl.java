package com.incanatoapps.apipedido.service.impl;

import com.incanatoapps.apipedido.entity.Rol;
import com.incanatoapps.apipedido.repository.RolRepository;
import com.incanatoapps.apipedido.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolServiceImpl implements RolService {
    @Autowired
    RolRepository repository;

    @Override
    public Page<Rol> findAll(Pageable pageable, String search) {
        if(search==null){
            return repository.findAll(pageable);
        }else{
            return repository.findByNombreContainingIgnoreCase(pageable, search);
        }
    }

    @Override
    public Rol findById(Long id) {
        return null;
    }

    @Override
    public Rol create(Rol obj) {
        return null;
    }

    @Override
    public Rol update(Long id, Rol obj) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void setRoles(Long usuarioId, List<String> nombres) {

    }

    @Override
    public Rol search(Long id) {
        return null;
    }
}
