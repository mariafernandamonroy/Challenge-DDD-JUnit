package com.sofkau.challenge.domain.catalogo.values;

import co.com.sofka.domain.generic.Identity;

public class PeliculaId extends Identity {
    private PeliculaId(String id){
        super(id);
    }

    public PeliculaId of(String id){
        return new PeliculaId(id);
    }
}
