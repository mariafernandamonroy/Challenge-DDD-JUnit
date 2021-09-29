package com.sofkau.challenge.domain.cuenta.values;

import co.com.sofka.domain.generic.Identity;

public class UsuarioId extends Identity {
    private UsuarioId(String id) {
        super(id);
    }

    public UsuarioId of(String id) {
        return new UsuarioId(id);
    }
}
