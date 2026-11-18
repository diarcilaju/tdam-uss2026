package com.incanatoapps.apipedido.service;

import com.incanatoapps.apipedido.entity.Producto;
import com.incanatoapps.apipedido.entity.Rol;
import com.incanatoapps.apipedido.entity.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Set;

public interface UsuarioService {
    Page<Usuario> findAll(Pageable pageable, String search);
    Usuario findById(Long id);
    Usuario create(Usuario obj);
    Usuario update(Long id, Usuario obj);
    void delete(Long id);
    Set<Usuario> searchRoles(List<String> nombres);
    Usuario search(Long id);
}
