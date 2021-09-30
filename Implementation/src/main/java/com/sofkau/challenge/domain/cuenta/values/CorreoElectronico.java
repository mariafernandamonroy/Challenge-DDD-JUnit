package com.sofkau.challenge.domain.cuenta.values;

import co.com.sofka.domain.generic.ValueObject;

public class CorreoElectronico implements ValueObject<String> {

    private final String correElectronico;

    public CorreoElectronico(String correElectronico){

        this.correElectronico = correElectronico;
    }

    @Override
    public String value() {
        return correElectronico;
    }
}
