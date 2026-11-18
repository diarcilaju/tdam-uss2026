package com.incanatoapps.apipedido.service.impl;

import com.incanatoapps.apipedido.entity.Usuario;
import com.incanatoapps.apipedido.repository.RolRepository;
import com.incanatoapps.apipedido.repository.UsuarioRepository;
import com.incanatoapps.apipedido.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Set;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    private final PasswordEncoder passwordEncoder;
    @Autowired
    UsuarioRepository repository;
    @Autowired
    RolRepository rolRepository;

    public UsuarioServiceImpl(PasswordEncoder passwordEncoder){
        this.passwordEncoder=passwordEncoder;
    }

    @Override
    public Page<Usuario> findAll(Pageable pageable, String search) {
        return null;
    }

    @Override
    public Usuario findById(Long id) {
        return null;
    }

    @Override
    public Usuario create(Usuario obj) {
        if(repository.existsByUsername(obj.getUsername())){
            throw new ResponseStatusException(HttpStatus.CONFLICT,"El usuario ya existe");
        }
        if(obj.getPassword()==null || obj.getPassword().isBlank()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"La contraseña es obligatoria");
        }
        obj.setPassword(passwordEncoder.encode(obj.getPassword()));

        return repository.save(obj);
    }

    @Override
    public Usuario update(Long id, Usuario obj) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Set<Usuario> searchRoles(List<String> nombres) {
        return Set.of();
    }

    @Override
    public Usuario search(Long id) {
        return null;
    }
}
