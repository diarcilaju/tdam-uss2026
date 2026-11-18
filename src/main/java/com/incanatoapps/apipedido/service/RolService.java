package com.incanatoapps.apipedido.service;


import com.incanatoapps.apipedido.entity.Producto;
import com.incanatoapps.apipedido.entity.Rol;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RolService {
    Page<Rol> findAll(Pageable pageable, String search);
    Rol findById(Long id);
    Rol create(Rol obj);
    Rol update(Long id, Rol obj);
    void delete(Long id);
    void setRoles(Long usuarioId, List<String> nombres);
    Rol search(Long id);
}
