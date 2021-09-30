package com.sofkau.challenge.domain.cuenta.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class CorreoElectronico implements ValueObject<String> {

    private final String correElectronico;

    public CorreoElectronico(String correElectronico){

        this.correElectronico = Objects.requireNonNull(correElectronico);
        if(this.correElectronico.length()<=2){
            throw new IllegalArgumentException("El correo debe tener mínimo 2 carácteres");
        }
    }

    @Override
    public String value() {
        return correElectronico;
    }
}
