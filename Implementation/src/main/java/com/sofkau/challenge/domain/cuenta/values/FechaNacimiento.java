package com.sofkau.challenge.domain.cuenta.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Date;
import java.util.Objects;

public class FechaNacimiento implements ValueObject<Date> {

    private final Date value;

    public FechaNacimiento(Date value){
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public Date value() {
        return value;
    }
}
