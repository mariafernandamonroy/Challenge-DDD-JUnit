package com.sofkau.challenge.domain.catalogo.values;

import co.com.sofka.domain.generic.Identity;

public class CatalogoId extends Identity {
    private CatalogoId(String id){
        super(id);
    }

    public CatalogoId of(String id){
        return new CatalogoId(id);
    }
}
