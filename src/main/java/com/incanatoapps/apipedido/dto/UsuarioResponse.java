package com.incanatoapps.apipedido.dto;

import com.incanatoapps.apipedido.entity.Rol;
import com.incanatoapps.apipedido.entity.Usuario;

import java.util.List;

public record UsuarioResponse (
        Long id, String username, List<String> role
){
    public static UsuarioResponse from(Usuario u){
        return new UsuarioResponse(u.getId(), u.getUsername(),u.getRoles().stream().map(Rol::getNombre).toList());
    }
}