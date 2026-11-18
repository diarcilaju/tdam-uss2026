package com.incanatoapps.apipedido.dto;

import java.util.List;

public record UsuarioRequest (
        String userName,
        String password,
        List<String> roles
){}