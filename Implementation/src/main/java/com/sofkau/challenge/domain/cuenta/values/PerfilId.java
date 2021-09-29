package com.sofkau.challenge.domain.cuenta.values;

import co.com.sofka.domain.generic.Identity;

public class PerfilId extends Identity {
    private PerfilId(String id){
        super(id);
    }

    public PerfilId of(String id){
        return new PerfilId(id);
    }
}
