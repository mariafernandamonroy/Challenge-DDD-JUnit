package com.sofkau.challenge.domain.cuenta.values;

import co.com.sofka.domain.generic.Identity;

public class CuentaId extends Identity {
    private CuentaId(String id){
        super(id);
    }

    public static CuentaId of(String id){
        return new CuentaId(id);
    }
}
