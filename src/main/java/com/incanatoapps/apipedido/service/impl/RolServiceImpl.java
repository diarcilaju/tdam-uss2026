package com.incanatoapps.apipedido.service.impl;

import com.incanatoapps.apipedido.entity.Rol;
import com.incanatoapps.apipedido.entity.Usuario;
import com.incanatoapps.apipedido.repository.RolRepository;
import com.incanatoapps.apipedido.repository.UsuarioRepository;
import com.incanatoapps.apipedido.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RolServiceImpl implements RolService {
    @Autowired
    RolRepository repository;
    @Autowired
    UsuarioRepository usuarioRepository;

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
        Usuario usuario=usuarioRepository.findById(usuarioId)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Usuario no encontrado"));
        Set<Rol> roles=nombres.stream()
                .map(n->repository.findByNombre(n.toUpperCase())
                        .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Rol No existe "+n)))
                .collect(Collectors.toSet());
        usuario.setRoles(roles);
        usuarioRepository.save(usuario);
    }

    @Override
    public Rol search(Long id) {
        return repository.findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Rol no encontrado"));
    }
}
