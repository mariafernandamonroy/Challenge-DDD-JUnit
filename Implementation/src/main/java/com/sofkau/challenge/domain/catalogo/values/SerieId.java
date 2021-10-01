package com.sofkau.challenge.domain.catalogo.values;

import co.com.sofka.domain.generic.Identity;

public class SerieId extends Identity {
    private SerieId(String id){
        super(id);
    }

    public static SerieId of(String id){
        return new SerieId(id);
    }
}
