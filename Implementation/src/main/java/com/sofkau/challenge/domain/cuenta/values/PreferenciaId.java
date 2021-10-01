package com.sofkau.challenge.domain.cuenta.values;

import co.com.sofka.domain.generic.Identity;

public class PreferenciaId extends Identity {
    private PreferenciaId(String id){
        super(id);
    }

    public static PreferenciaId of(String id){
        return new PreferenciaId(id);
    }
}
